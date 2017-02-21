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



import models.entity.auto.Country;
import play.db.ebean.Model.Finder;

/**
 * <strong>FujiUsersServices</strong><br>
 * <br>
 *
 * @author VuVanDung
 * @version $Id$
 */
public class CountryServices {
	
	
	public static Finder<Long,Country> find = new Finder(Long.class, Country.class);
	
	/**
     * fujiUsersById 
     * @param id FujiUsers id
     * TODO fujiUsersById 
     * @return
     */
	public static Country countryById(int id) {
		Country countryById = Ebean.find(Country.class, id);
		return countryById;
	}
	public static List<Country> listAllCountry() {
		return find.findList();
	}
	
	
}
