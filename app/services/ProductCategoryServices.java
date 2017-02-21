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




import models.entity.auto.Productcategory;
import models.entity.auto.Producttype;
import play.db.ebean.Model.Finder;

/**
 * <strong>FujiUsersServices</strong><br>
 * <br>
 *
 * @author VuVanDung
 * @version $Id$
 */
public class ProductCategoryServices {
	
	
	public static Finder<Long,Productcategory> find = new Finder(Long.class, Productcategory.class);
	
	/**
     * fujiUsersById 
     * @param id FujiUsers id
     * TODO fujiUsersById 
     * @return
     */
	public static Productcategory productCategoryById(int id) {
		Productcategory productCategoryById = Ebean.find(Productcategory.class, id);
		return productCategoryById;
	}
	public static List<Productcategory> listAllProductCategory() {
		return find.findList();
	}
	
	
}
