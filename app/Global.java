import static play.mvc.Results.ok;

import java.io.File;
import java.text.ParseException;
import java.util.Locale;

import play.Application;
import play.Configuration;
import play.GlobalSettings;
import play.Logger;
import play.api.mvc.Handler;
import play.data.format.Formatters;
import play.libs.F;
import play.libs.F.Promise;
import play.libs.Json;
import play.mvc.Action;
import play.mvc.Http;
import play.mvc.Http.RequestHeader;
import play.mvc.SimpleResult;


import views.html.index;
import views.html.invalid;

import com.fasterxml.jackson.databind.node.ObjectNode;

/**
 * <strong>Global</strong><br>
 * <br>
 * 
 * @author dungvv
 * @version $Id$
 */
public class Global extends GlobalSettings{

	/*
	 * (non-Javadoc)
	 * @see play.GlobalSettings#onStart(play.Application)
	 */
	@Override
	public void onStart(Application application){
		Logger.info("======= application start =======");

		

		super.onStart(application);

	}

	/*
	 * (non-Javadoc)
	 * @see play.GlobalSettings#beforeStart(play.Application)
	 */
	@Override
	public void beforeStart(Application application){

		Formatters.register(String.class, new Formatters.SimpleFormatter<String>() {

			@Override
			public String parse(String input, Locale locale) throws ParseException{
				if(input != null){
					input = input.trim();
				}
				return input;
			}

			@Override
			public String print(String input, Locale locale){
				return input;
			}

		});

		super.beforeStart(application);
	}

	/*
	 * (non-Javadoc)
	 * @see play.GlobalSettings#onStop(play.Application)
	 */
	@Override
	public void onStop(Application application){
		Logger.info("======= application stop =======");

		// cancellable.cancel();

		super.onStop(application);
	}



	// @Override
	// public Result onError(RequestHeader request, Throwable t){
	// return internalServerError(views.html.error(t));
	// }

	// CORS対応
	/**
	 * <strong>ActionWrapper</strong><br>
	 * <br>
	 * 
	 * @author hoangdx
	 * @version $Id$
	 */

	 private class ActionWrapper extends Action.Simple {
	        public ActionWrapper(Action<?> action) {
	            this.delegate = action;
	        }

	        @Override
	        public Promise<SimpleResult> call(Http.Context ctx) throws java.lang.Throwable {
	            Promise<SimpleResult> result = this.delegate.call(ctx);
	            Http.Response response = ctx.response();
	            response.setHeader("Access-Control-Allow-Origin", "*");
	            return result;
	        }
	    }

	    @Override
	    public Action<?> onRequest(Http.Request request, java.lang.reflect.Method actionMethod) {
	        return new ActionWrapper(super.onRequest(request, actionMethod));
	    }

	/*
	 * (non-Javadoc)
	 * @see play.GlobalSettings#onRouteRequest(play.mvc.Http.RequestHeader)
	 */
	@Override
	public Handler onRouteRequest(Http.RequestHeader requestHeader){
//		Logger.info("======= application route request =======" + requestHeader.uri());

		return super.onRouteRequest(requestHeader);
	}

	/*
	 * (non-Javadoc)
	 * @see play.GlobalSettings#onBadRequest(play.mvc.Http.RequestHeader, java.lang.String)
	 */
	@Override
	public F.Promise<SimpleResult> onBadRequest(Http.RequestHeader requestHeader, String s){
		Logger.info("======= application bad request =======");
		return super.onBadRequest(requestHeader, s);
	}

	/*
	 * (non-Javadoc)
	 * @see play.GlobalSettings#onLoadConfig(play.Configuration, java.io.File, java.lang.ClassLoader)
	 */
	@Override
	public Configuration onLoadConfig(Configuration configuration, File file, ClassLoader classLoader){
		Logger.info("======= application load config =======");
		return super.onLoadConfig(configuration, file, classLoader);
	}

	@Override
	public Promise<SimpleResult> onHandlerNotFound(RequestHeader request){
		return Promise.<SimpleResult>pure(ok(invalid.render()));
	}
}