/**
 * 
 */
package services;

import java.util.List;

import com.avaje.ebean.Ebean;
import com.avaje.ebean.Expr;
import com.avaje.ebean.Expression;
import com.avaje.ebean.ExpressionList;
import com.avaje.ebean.Page;
import com.avaje.ebean.PagingList;
import models.entity.auto.Product;
import play.db.ebean.Model.Finder;

/**
 * <strong>FujiUsersServices</strong><br>
 * <br>
 *
 * @author VuVanDung
 * @version $Id$
 */
public class ProductServices {
	
	
	public static Finder<Long,Product> find = new Finder(Long.class, Product.class);
	
	/**
     * fujiUsersById 
     * @param id FujiUsers id
     * TODO fujiUsersById 
     * @return
     */
	public static Product productById(int id) {
		Product productById = Ebean.find(Product.class, id);
		return productById;
	}
	public static List<Product> listAllProduct() {
		return find.order(" created_date DESC").findList();
	}
	public static List<Product> listBaner() {
		return find.order(" created_date DESC ").setMaxRows(12).findList();
	}
	public static List<Product> listFooter() {
		return find.order(" created_date DESC ").setMaxRows(3).findList();
	}
	public static List<Product> listBanerBottom() {
		return find.order(" time DESC ").findList();
	}
	
	public static List<Product> listRight() {
		return find.order(" time DESC ").setMaxRows(5).findList();
	}
	
	public static List<Product> listProductByType(int type) {
			return find.where().eq(Product.TYPE_PROPERTY,type).order(" created_date DESC").setMaxRows(24).findList();
		}
	public static List<Product> listProductByCategory(int cate) {
		return find.where().eq(Product.CATEGORY_PROPERTY,cate).order(" created_date DESC").findList();
	}
	public static List<Product> listProductByCountry(int country) {
		return find.where().eq(Product.COUNTRY_PROPERTY,country).order(" created_date DESC").findList();
	}
	
	public static List<Product> listProductByCategory(int cate ,int numberpage, int PRODUCT_ROWINPAGE) {
		PagingList<Product> findPagingList = find.where()
				.eq(Product.CATEGORY_PROPERTY, cate)
				.order(" created_date DESC ")
				.findPagingList(PRODUCT_ROWINPAGE);
		Page<Product> page = findPagingList.getPage(numberpage - 1);
		List<Product> listProductByType = page.getList();
		return listProductByType;
	}
	
	
	
}
