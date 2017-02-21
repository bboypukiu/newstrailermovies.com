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

public class NewsAdministratorController extends Controller {

	public static Result newsList() {

		// list productBaner
		List<News> listAllNews = NewsServices.listAllNews();
		return ok(newsList.render(listAllNews));
	}

	public static Result newsAdd() {
		return ok(newsAdd.render(null));
	}

	public static Result newsEdit(int id) {
		News newsById = NewsServices.newsById(id);
		return ok(newsEdit.render(newsById));
	}
	
	public static Result saveNews() {

		DynamicForm form = Form.form().bindFromRequest();

		String proTitle = String.valueOf(form.data().get("newsTitle"));
		String description = String.valueOf(form.data().get("description"));
		int deleted = Integer.parseInt(String.valueOf(form.data().get("optionsRadios")));

		String imgmax = "";
		String imgnomal = "";
		News newsById = null;
		if (String.valueOf(form.data().get("newsId")) != null
				&& String.valueOf(form.data().get("newsId")) != ""
				&& !String.valueOf(form.data().get("newsId")).isEmpty()) {
			int newsId = Integer.parseInt(String.valueOf(form.data()
					.get("newsId")));
			newsById = NewsServices.newsById(newsId);

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
				String fileNameCrop = df.format(date) + "_news_max_"+ fileName.replaceAll("[^a-zA-Z0-9 - .]", "");
				fileNameCrop = fileNameCrop.replace(" ", "");
				BufferedImage originalImage = ImageIO.read(file);
				BufferedImage resizeImageJpg = BBUtil.resizeImage(originalImage, 1300, 500);
				ImageIO.write(resizeImageJpg,FilenameUtils.getExtension(fileName), new File(path+ fileNameCrop));

				String fileNameCropnomal = df.format(date) + "_news_nomal_"+ fileName.replaceAll("[^a-zA-Z0-9 - .]", "");
				fileNameCropnomal = fileNameCropnomal.replace(" ", "");
				BufferedImage resizeImageJpgnomal = BBUtil.resizeImage(originalImage, 182, 268);
				ImageIO.write(resizeImageJpgnomal,
						FilenameUtils.getExtension(fileName), new File(path
								+ fileNameCropnomal));
				imgmax = "images/" + fileNameCrop;

				imgnomal = "images/" + fileNameCropnomal;
				newsById.setImgmax(imgmax);
				newsById.setImgnomal(imgnomal);
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

				String fileNameCropnomal = df.format(date) + "_news_nomal_"+ fileName.replaceAll("[^a-zA-Z0-9 - .]", "");
				fileNameCropnomal = fileNameCropnomal.replace(" ", "");
				BufferedImage resizeImageJpgnomal = BBUtil.resizeImage(originalImage, 182, 268);	
				ImageIO.write(resizeImageJpgnomal,FilenameUtils.getExtension(fileName), new File(path+ fileNameCropnomal));
				
				imgnomal = "images/" + fileNameCropnomal;
				newsById.setImgnomal(imgnomal);
			}

		} catch (Exception e) {
			e.printStackTrace();
			jsonResult.put("status", "NOK");
		}

		Calendar cal = Calendar.getInstance();
		Date date = cal.getTime();
		if (newsById != null) {
			newsById.setTitle(proTitle);
			newsById.setDescription(description);
			newsById.setDeleted(deleted);
			newsById.setUpdatedDate(date);
			newsById.save();
			jsonResult.put("status", "OK");
		} else {
			News pro = new News();
			pro.setTitle(proTitle);
			pro.setDescription(description);
			pro.setImgmax(imgmax);
			pro.setImgnomal(imgnomal);
			pro.setDeleted(deleted);
			pro.setUpdatedDate(date);
			pro.setCreatedDate(date);
			pro.save();
			jsonResult.put("status", "OK");
		}

		List<News> listAllNews = NewsServices.listAllNews();
		return ok(newsList.render(listAllNews));
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
