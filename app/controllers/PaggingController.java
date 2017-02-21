package controllers;


import constant.Constant;
import play.data.DynamicForm;
import play.data.Form;
import play.mvc.Result;
import views.html.*;
import play.*;
import play.api.templates.Html;
import play.mvc.*;
import services.ProductServices;

/**
 * <strong>PaggingController</strong><br>
 * <br>
 *
 * @author VuVanDung
 * @version $Id$
 */
public class PaggingController extends Controller {
	
	
	public static Result pagging_Genres_PagesNews(Integer cate,Integer page) {

		return ok(genres_result.render(ProductServices.listProductByCategory(cate,page,Constant.Product_ROWINCatePAGE)));
	}
	
	/**
     * javascriptRoutes 
     * @return
     */
	  public static Result javascriptRoutes() {
		    response().setContentType("text/javascript");
		    return ok(
		      Routes.javascriptRouter("myJsRoutes",
		        routes.javascript.PaggingController.pagging_Genres_PagesNews()
		      )
		    );
		  }
	
	
}