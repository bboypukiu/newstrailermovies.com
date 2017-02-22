package models.util;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import models.entity.auto.Product;
import models.entity.auto.Productcategory;
import services.ProductCategoryServices;
import services.ProductServices;
import constant.Constant;



public class BBUtil {

	

	/**
	 * <strong>makeUserShortName</strong><br>
	 * <br>
	 *
	 * @param user
	 * @return
	 */
	// public static String makeUserShortName(CcUser user){
	//
	// if(user == null){
	// return "";
	// }else{
	// StringBuilder builder = new StringBuilder();
	// if(user.getUserFirstName() != null){
	// builder.append(user.getUserFirstName());
	// }
	//
	// if(user.getUserLastName() != null && user.getUserFirstName() != null){
	// builder.append(" ");
	// }
	//
	// if(user.getUserLastName() != null){
	// builder.append(user.getUserLastName());
	// }
	//
	// return builder.toString();
	// }
	// }

	/**
	 * <strong>resizeImage</strong><br>
	 * <br>
	 *
	 * @return
	 */
	public static BufferedImage resizeImage(BufferedImage originalImage,
			int newWidth, int newHeight) {
		BufferedImage resizedImage = new BufferedImage(newWidth, newHeight,
				originalImage.getType());
		Graphics2D g = resizedImage.createGraphics();
		g.drawImage(originalImage, 0, 0, newWidth, newHeight, null);
		g.dispose();
		return resizedImage;
	}
	
	public static String subDescription(String des,int leng) {
		String substring=des;
		if (des!=null && des.length()>leng) {
			substring = des.substring(0,leng);
		}
		
		return substring+"...";
	}
	
	public static String getTime(Date time) {
		Calendar ca = Calendar.getInstance();
		ca.setTime(time);
		int y = ca.get(Calendar.YEAR);
		int m = ca.get(Calendar.MONTH)+1;
		return y+"";
	}
	
	
	// dung vv
	public static int totalPageCategory(int cate) {
		List<Product> listProductByCategory = ProductServices.listProductByCategory(cate);
		int totalPageCategory = 1;
		if (listProductByCategory.size() > 0) {
			double tmp = (double) listProductByCategory.size()
					/ Constant.Product_ROWINCatePAGE;
			totalPageCategory = (int) Math.ceil(tmp);
		}
		return totalPageCategory;
	}

	public static String getCategoryName(int id) {
		String cateName ="";
		Productcategory productCategoryById = ProductCategoryServices.productCategoryById(id);
		if (productCategoryById!=null) {
			cateName =productCategoryById.getName();
		}
		return cateName;
	}
}