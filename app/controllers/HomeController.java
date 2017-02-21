package controllers;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import models.entity.auto.Country;
import models.entity.auto.Product;
import models.entity.auto.Productcategory;
import models.entity.auto.Producttype;
import play.mvc.*;
import services.CountryServices;
import services.ProductCategoryServices;
import services.ProductServices;
import services.ProductTypeServices;
import views.html.*;
public class HomeController extends Controller {
	
	
	

	public static Result index() {
		Map<String, Object> map = new HashMap<String, Object>();

		
		ProductServices service  = new ProductServices();
		//list productBaner
		List<Product> listproductBaner =service.listBaner();
        //	list	banner-bottom 
		List<Product> listProductBannerBottom =service.listBanerBottom();
		List<Product> listFooter =service.listFooter();
		
		
		List<Producttype> listAllProductType = ProductTypeServices.listAllProductType();
		Map<String, String> listAllProductTypemap = new HashMap<String, String>();
		for (Producttype productType : listAllProductType) {
			listAllProductTypemap.put(productType.id+"", productType.name);
		}
		
		ProductCategoryServices proCateService = new ProductCategoryServices();
		List<Productcategory> listAllProductCategory = proCateService.listAllProductCategory();
		Map<String, String> listAllProductCtegorymap = new HashMap<String, String>();
		
		for (Productcategory cate : listAllProductCategory) {
			listAllProductCtegorymap.put(cate.id+"", cate.name);
		}
		List<Country> listAllCountry = CountryServices.listAllCountry();
		Map<String, String> listAllCountrymap = new HashMap<String, String>();
		for (Country cou : listAllCountry) {
			listAllCountrymap.put(cou.id+"", cou.name);
		}
		
		map.put("listAllProductTypemap", listAllProductTypemap);
		map.put("listAllProductCtegorymap", listAllProductCtegorymap);
		map.put("listAllCountrymap", listAllCountrymap);
		map.put("listBaner", listproductBaner);
		map.put("listFooter", listFooter);
		
		map.put("listProductBannerBottom", listProductBannerBottom);
		for (Producttype producttype : listAllProductType) {
			List<Product> list = service.listProductByType(producttype.getId());
			map.put("listProductByType_"+producttype.getId(), list);
		}

		
        return ok(index.render(map));
    }
	
	 public static Result single(int id) {
		 ProductServices service  = new ProductServices();
		    Product pro = service.productById(id);
		    List<Product> listRight =service.listRight();
		    List<Product> listProductBannerBottom =service.listBanerBottom();
	        return ok(single.render(pro,listRight,listProductBannerBottom));
	        
	    }
	
}
