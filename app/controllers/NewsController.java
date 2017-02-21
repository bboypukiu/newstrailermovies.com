package controllers;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import models.entity.auto.Country;
import models.entity.auto.News;
import models.entity.auto.Product;
import models.entity.auto.Productcategory;
import models.entity.auto.Producttype;
import play.mvc.*;
import services.CountryServices;
import services.NewsServices;
import services.ProductCategoryServices;
import services.ProductServices;
import services.ProductTypeServices;
import views.html.*;
public class NewsController extends Controller {
	
	
	

	public static Result news() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<News> listAllNews = NewsServices.listAllNews();
		map.put("listAllNews", listAllNews);
		ProductServices service  = new ProductServices();
		//list productBaner
		List<Product> listproductBaner =service.listBaner();
		map.put("listproductBaner",listproductBaner);
		
		
		List<News> listNewTop = NewsServices.listNewTop();
		map.put("listNewTop",listNewTop);
        return ok(news.render(map));
    }

	 public static Result newssingle(int id) {
		 NewsServices service  = new NewsServices();
		 News news = service.newsById(id);
		 
		 Map<String, Object> map = new HashMap<String, Object>();
			List<News> listAllNews = NewsServices.listAllNews();
			map.put("listAllNews", listAllNews);
			ProductServices proservice  = new ProductServices();
			//list productBaner
			List<Product> listProductBannerBottom =proservice.listBanerBottom();
			
			
			map.put("listProductBannerBottom",listProductBannerBottom);
			List<News> listNewTop = NewsServices.listNewTop();
			map.put("listNewTop",listNewTop);
	        return ok(newssingle.render(news,map));
	        
	    }
	
}
