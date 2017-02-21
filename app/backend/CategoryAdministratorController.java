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
import models.entity.auto.Producttype;
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
import services.ProductTypeServices;
import views.html.administrator.*;

public class CategoryAdministratorController extends Controller {

	public static Result categoryList() {

		// list productBaner
		List<Productcategory> listAllProductCategory = ProductCategoryServices
				.listAllProductCategory();
		return ok(categoryList.render(listAllProductCategory));
	}

	public static Result categoryAdd() {
		return ok(categoryAdd.render(null));
	}

	public static Result categoryEdit(int id) {
		Productcategory productCategoryById = ProductCategoryServices
				.productCategoryById(id);
		return ok(categoryEdit.render(productCategoryById));
	}

	public static Result saveCategory() {

		DynamicForm form = Form.form().bindFromRequest();

		String categoryName = String.valueOf(form.data().get("categoryName"));
		int deleted = Integer.parseInt(String.valueOf(form.data().get("optionsRadios")));
		Productcategory categoryById = null;
		if (String.valueOf(form.data().get("categoryId")) != null
				&& String.valueOf(form.data().get("categoryId")) != ""
				&& !String.valueOf(form.data().get("categoryId")).isEmpty()) {
			int categoryId = Integer.parseInt(String.valueOf(form.data()
					.get("categoryId")));
			categoryById = ProductCategoryServices.productCategoryById(categoryId);

		}

		ObjectNode jsonResult = Json.newObject();

		Calendar cal = Calendar.getInstance();
		Date date = cal.getTime();
		if (categoryById != null) {
			categoryById.setName(categoryName);
			categoryById.setDeleted(deleted);
			categoryById.save();
			jsonResult.put("status", "OK");
		} else {
			Productcategory procate = new Productcategory();
			procate.setName(categoryName);
			procate.setDeleted(deleted);
			procate.save();
			jsonResult.put("status", "OK");
		}

		List<Productcategory> listAllProductCategory = ProductCategoryServices.listAllProductCategory();
		return ok(categoryList.render(listAllProductCategory));
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
