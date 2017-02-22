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
import models.entity.auto.News;
import play.db.ebean.Model.Finder;

/**
 * <strong>FujiUsersServices</strong><br>
 * <br>
 *
 * @author VuVanDung
 * @version $Id$
 */
public class NewsServices {
	
	
	public static Finder<Long,News> find = new Finder(Long.class, News.class);
	
	/**
     * fujiUsersById 
     * @param id FujiUsers id
     * TODO fujiUsersById 
     * @return
     */
	public static News newsById(int id) {
		News productById = Ebean.find(News.class, id);
		return productById;
	}
	public static List<News> listAllNews() {
		return find.order(" created_date DESC").findList();
	}
	public static List<News> listNewTop() {
		return find.order(" created_date DESC").setMaxRows(15).findList();
	}
	
	
	
}
