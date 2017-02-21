package backend;

import java.awt.image.BufferedImage;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.imageio.ImageIO;

import org.apache.commons.io.FilenameUtils;

import com.fasterxml.jackson.databind.node.ObjectNode;

import models.entity.auto.Country;
import models.entity.auto.News;
import models.entity.auto.Product;
import models.entity.auto.Productcategory;
import models.entity.auto.Country;
import models.util.BBUtil;
import play.*;
import play.api.Play;
import play.data.DynamicForm;
import play.data.Form;
import play.libs.Json;
import play.mvc.*;
import play.mvc.Http.MultipartFormData;
import play.mvc.Http.MultipartFormData.FilePart;
import services.CountryServices;
import services.NewsServices;
import services.ProductCategoryServices;
import services.ProductServices;
import services.CountryServices;
import views.html.administrator.*;

public class CountryAdministratorController extends Controller {


	public static Result countryList() {

		// list productBaner
		List<Country> listAllCountry = CountryServices.listAllCountry();
		return ok(countryList.render(listAllCountry));
	}

	public static Result countryAdd() {
		return ok(countryAdd.render(null));
	}

	public static Result countryEdit(int id) {
		Country CountryById = CountryServices.countryById(id);
		return ok(countryEdit.render(CountryById));
	}

	public static Result saveCountry() {

		DynamicForm form = Form.form().bindFromRequest();

		String typeName = String.valueOf(form.data().get("countryName"));
		int deleted = Integer.parseInt(String.valueOf(form.data().get("optionsRadios")));
		Country countryById = null;
		if (String.valueOf(form.data().get("countryId")) != null
				&& String.valueOf(form.data().get("countryId")) != ""
				&& !String.valueOf(form.data().get("countryId")).isEmpty()) {
			int countryId = Integer.parseInt(String.valueOf(form.data()
					.get("countryId")));
			countryById = CountryServices.countryById(countryId);

		}

		ObjectNode jsonResult = Json.newObject();

		Calendar cal = Calendar.getInstance();
		Date date = cal.getTime();
		if (countryById != null) {
			countryById.setName(typeName);
			countryById.setDeleted(deleted);
			countryById.save();
			jsonResult.put("status", "OK");
		} else {
			Country country = new Country();
			country.setName(typeName);
			country.setDeleted(deleted);
			country.save();
			jsonResult.put("status", "OK");
		}

		List<Country> listAllCountry = CountryServices.listAllCountry();
		return ok(countryList.render(listAllCountry));
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
