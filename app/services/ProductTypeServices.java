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



import models.entity.auto.Producttype;
import play.db.ebean.Model.Finder;

/**
 * <strong>FujiUsersServices</strong><br>
 * <br>
 *
 * @author VuVanDung
 * @version $Id$
 */
public class ProductTypeServices {
	
	
	public static Finder<Long,Producttype> find = new Finder(Long.class, Producttype.class);
	
	/**
     * fujiUsersById 
     * @param id FujiUsers id
     * TODO fujiUsersById 
     * @return
     */
	public static Producttype productTypeById(int id) {
		Producttype productTypeById = Ebean.find(Producttype.class, id);
		return productTypeById;
	}
	public static List<Producttype> listAllProductType() {
		return find.findList();
	}
	
	
}
