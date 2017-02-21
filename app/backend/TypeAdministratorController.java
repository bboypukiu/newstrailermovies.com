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

public class TypeAdministratorController extends Controller {


	public static Result typeList() {

		// list productBaner
		List<Producttype> listAllProductType = ProductTypeServices.listAllProductType();
		return ok(typeList.render(listAllProductType));
	}

	public static Result typeAdd() {
		return ok(typeAdd.render(null));
	}

	public static Result typeEdit(int id) {
		Producttype productTypeById = ProductTypeServices.productTypeById(id);
		return ok(typeEdit.render(productTypeById));
	}

	public static Result saveType() {

		DynamicForm form = Form.form().bindFromRequest();

		String typeName = String.valueOf(form.data().get("typeName"));
		int deleted = Integer.parseInt(String.valueOf(form.data().get("optionsRadios")));
		Producttype typeById = null;
		if (String.valueOf(form.data().get("typeId")) != null
				&& String.valueOf(form.data().get("typeId")) != ""
				&& !String.valueOf(form.data().get("typeId")).isEmpty()) {
			int typeId = Integer.parseInt(String.valueOf(form.data()
					.get("typeId")));
			typeById = ProductTypeServices.productTypeById(typeId);

		}

		ObjectNode jsonResult = Json.newObject();

		Calendar cal = Calendar.getInstance();
		Date date = cal.getTime();
		if (typeById != null) {
			typeById.setName(typeName);
			typeById.setDeleted(deleted);
			typeById.save();
			jsonResult.put("status", "OK");
		} else {
			Producttype protype = new Producttype();
			protype.setName(typeName);
			protype.setDeleted(deleted);
			protype.save();
			jsonResult.put("status", "OK");
		}

		List<Producttype> listAllProductType = ProductTypeServices.listAllProductType();
		return ok(typeList.render(listAllProductType));
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
