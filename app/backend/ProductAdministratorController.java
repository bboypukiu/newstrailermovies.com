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

public class ProductAdministratorController extends Controller {

	public static Result index() {
		ProductServices service = new ProductServices();
		// list productBaner
		List<Product> listAllProduct = service.listAllProduct();
		return ok(productList.render(listAllProduct));
	}

	public static Result productEdit(int id) {
		ProductServices service = new ProductServices();
		// list productBaner
		Product productById = service.productById(id);
		ProductTypeServices proTypeService = new ProductTypeServices();
		List<Producttype> listAllProductType = proTypeService
				.listAllProductType();

		Map<String, Object> message = new HashMap<String, Object>();
		Map<String, String> listAllProductTypemap = new HashMap<String, String>();
		for (Producttype productType : listAllProductType) {
			listAllProductTypemap.put(productType.id + "", productType.name);
		}

		ProductCategoryServices proCateService = new ProductCategoryServices();
		List<Productcategory> listAllProductCategory = proCateService
				.listAllProductCategory();
		Map<String, String> listAllProductCtegorymap = new HashMap<String, String>();
		for (Productcategory cate : listAllProductCategory) {
			listAllProductCtegorymap.put(cate.id + "", cate.name);
		}
		List<Country> listAllCountry = CountryServices.listAllCountry();
		Map<String, String> listAllCountrymap = new HashMap<String, String>();
		for (Country cou : listAllCountry) {
			listAllCountrymap.put(cou.id + "", cou.name);
		}

		message.put("listAllProductTypemap", listAllProductTypemap);
		message.put("listAllProductCtegorymap", listAllProductCtegorymap);
		message.put("listAllCountrymap", listAllCountrymap);
		return ok(productEdit.render(productById, message));
	}

	@SuppressWarnings("static-access")
	public static Result productAdd() {

		ProductTypeServices proTypeService = new ProductTypeServices();
		List<Producttype> listAllProductType = proTypeService
				.listAllProductType();

		Map<String, Object> message = new HashMap<String, Object>();
		Map<String, String> listAllProductTypemap = new HashMap<String, String>();
		for (Producttype productType : listAllProductType) {
			listAllProductTypemap.put(productType.id + "", productType.name);
		}

		ProductCategoryServices proCateService = new ProductCategoryServices();
		List<Productcategory> listAllProductCategory = proCateService
				.listAllProductCategory();
		Map<String, String> listAllProductCtegorymap = new HashMap<String, String>();
		for (Productcategory cate : listAllProductCategory) {
			listAllProductCtegorymap.put(cate.id + "", cate.name);
		}

		List<Country> listAllCountry = CountryServices.listAllCountry();
		Map<String, String> listAllCountrymap = new HashMap<String, String>();
		for (Country cou : listAllCountry) {
			listAllCountrymap.put(cou.id + "", cou.name);
		}

		message.put("listAllProductTypemap", listAllProductTypemap);
		message.put("listAllProductCtegorymap", listAllProductCtegorymap);
		message.put("listAllCountrymap", listAllCountrymap);

		return ok(productAdd.render(null, message));
	}

	public static Result saveProduct() {

		DynamicForm form = Form.form().bindFromRequest();

		String proTitle = String.valueOf(form.data().get("proTitle"));
		String description = String.valueOf(form.data().get("description"));
		String linkvideo = String.valueOf(form.data().get("linkvideo"));
		int deleted = Integer.parseInt(String.valueOf(form.data().get(
				"optionsRadios")));
		int category = Integer.parseInt(String.valueOf(form.data().get(
				"category")));
		int type = Integer.parseInt(String.valueOf(form.data().get("type")));
		int country = Integer.parseInt(String.valueOf(form.data()
				.get("country")));
		String imgmax = "";
		String imgmin = "";
		String imgnomal = "";
		Product productById = null;
		if (String.valueOf(form.data().get("proId")) != null
				&& String.valueOf(form.data().get("proId")) != ""
				&& !String.valueOf(form.data().get("proId")).isEmpty()) {
			int proId = Integer.parseInt(String.valueOf(form.data()
					.get("proId")));
			productById = ProductServices.productById(proId);

		}

		ObjectNode jsonResult = Json.newObject();
		try {
			MultipartFormData body = request().body().asMultipartFormData();
			FilePart filePart = body.getFile("image");
			if (filePart != null) {
				String fileName = filePart.getFilename();
				String contentType = filePart.getContentType();
				File file = filePart.getFile();

				Calendar cal = Calendar.getInstance();
				SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
				Date date = cal.getTime();
				// String newFileName = df.format(date) + "-" + fileName;

				String absolutePath = Play.current().path().getAbsolutePath();

				String path = absolutePath + "/public/images/";

				// Files.copy(file.toPath(), (new File(path +
				// newFileName)).toPath(), StandardCopyOption.REPLACE_EXISTING);

				// Crop image
				String fileNameCrop = df.format(date) + "_max_"
						+ fileName.replaceAll("[^a-zA-Z0-9 - .]", "");
				fileNameCrop = fileNameCrop.replace(" ", "");
				BufferedImage originalImage = ImageIO.read(file);
				BufferedImage resizeImageJpg = BBUtil.resizeImage(
						originalImage, 1300, 500);
				ImageIO.write(resizeImageJpg,
						FilenameUtils.getExtension(fileName), new File(path
								+ fileNameCrop));

				String fileNameCropmin = df.format(date) + "_min_"
						+ fileName.replaceAll("[^a-zA-Z0-9 - .]", "");
				fileNameCropmin = fileNameCropmin.replace(" ", "");
				BufferedImage resizeImageJpgmin = BBUtil.resizeImage(
						originalImage, 182, 268);
				ImageIO.write(resizeImageJpgmin,
						FilenameUtils.getExtension(fileName), new File(path
								+ fileNameCropmin));

				String fileNameCropnomal = df.format(date) + "_nomal_"
						+ fileName.replaceAll("[^a-zA-Z0-9 - .]", "");
				fileNameCropnomal = fileNameCropnomal.replace(" ", "");
				BufferedImage resizeImageJpgnomal = BBUtil.resizeImage(
						originalImage, 182, 268);
				ImageIO.write(resizeImageJpgnomal,
						FilenameUtils.getExtension(fileName), new File(path
								+ fileNameCropnomal));
				imgmax = "images/" + fileNameCrop;
				imgmin = "images/" + fileNameCropmin;
				imgnomal = "images/" + fileNameCropnomal;
				productById.setImgmax(imgmax);
				productById.setImgmin(imgmin);
				productById.setImgnomal(imgnomal);
			}
			FilePart filePart2 = body.getFile("imagePoster");
			if (filePart2 != null) {
				String fileName = filePart2.getFilename();
				String contentType = filePart2.getContentType();
				File file = filePart2.getFile();

				Calendar cal = Calendar.getInstance();
				SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
				Date date = cal.getTime();
				// String newFileName = df.format(date) + "-" + fileName;

				String absolutePath = Play.current().path().getAbsolutePath();

				String path = absolutePath + "/public/images/";

				// Files.copy(file.toPath(), (new File(path +
				// newFileName)).toPath(), StandardCopyOption.REPLACE_EXISTING);

				// Crop image
				BufferedImage originalImage = ImageIO.read(file);

				String fileNameCropmin = df.format(date) + "_min_"+ fileName.replaceAll("[^a-zA-Z0-9 - .]", "");
				fileNameCropmin = fileNameCropmin.replace(" ", "");
				BufferedImage resizeImageJpgmin = BBUtil.resizeImage(originalImage, 182, 268);
				ImageIO.write(resizeImageJpgmin,FilenameUtils.getExtension(fileName), new File(path+ fileNameCropmin));

				String fileNameCropnomal = df.format(date) + "_nomal_"+ fileName.replaceAll("[^a-zA-Z0-9 - .]", "");
				fileNameCropnomal = fileNameCropnomal.replace(" ", "");
				BufferedImage resizeImageJpgnomal = BBUtil.resizeImage(originalImage, 182, 268);	
				ImageIO.write(resizeImageJpgnomal,FilenameUtils.getExtension(fileName), new File(path+ fileNameCropnomal));
				imgmin = "images/" + fileNameCropmin;
				imgnomal = "images/" + fileNameCropnomal;
				productById.setImgmin(imgmin);
				productById.setImgnomal(imgnomal);
			}

		} catch (Exception e) {
			e.printStackTrace();
			jsonResult.put("status", "NOK");
		}

		Calendar cal = Calendar.getInstance();
		Date date = cal.getTime();
		if (productById != null) {
			productById.setTitle(proTitle);
			productById.setDescription(description);
			productById.setLinkvideo(linkvideo);
			productById.setDeleted(deleted);
			productById.setCategory(category);
			productById.setType(type);
			productById.setUpdatedDate(date);
			productById.setCountry(country);
			productById.setVisible(0);
			productById.save();
			jsonResult.put("status", "OK");
		} else {
			Product pro = new Product();
			pro.setTitle(proTitle);
			pro.setDescription(description);
			pro.setImgmax(imgmax);
			pro.setImgmin(imgmin);
			pro.setImgnomal(imgnomal);
			pro.setLinkvideo(linkvideo);
			pro.setDeleted(deleted);
			pro.setCategory(category);
			pro.setUpdatedDate(date);
			pro.setVisible(0);
			pro.setType(type);
			pro.setCountry(country);
			pro.save();
			jsonResult.put("status", "OK");
		}

		ProductServices service = new ProductServices();
		// list productBaner
		List<Product> listAllProduct = service.listAllProduct();
		return ok(productList.render(listAllProduct));
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
