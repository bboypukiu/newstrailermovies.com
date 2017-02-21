package controllers;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import constant.Constant;
import models.entity.auto.Country;
import models.entity.auto.Product;
import models.entity.auto.Productcategory;
import models.entity.auto.Producttype;
import models.util.BBUtil;
import play.mvc.*;
import services.CountryServices;
import services.ProductCategoryServices;
import services.ProductServices;
import services.ProductTypeServices;
import views.html.*;
public class GenresController extends Controller {

	@SuppressWarnings("static-access")
	public static Result genres(int id) {
		Map<String, Object> map = new HashMap<String, Object>();
		ProductServices service  = new ProductServices();
		List<Product> listProductBannerBottom =service.listBanerBottom();
		map.put("listProductBannerBottom", listProductBannerBottom);
		
		
		List<Product> listProductByCategory = service.listProductByCategory(id,1,Constant.Product_ROWINCatePAGE);
		
		map.put("listProductByCategory", listProductByCategory);
		
		int totalPageCategory = BBUtil.totalPageCategory(id);
		
		map.put("totalPageCategory", totalPageCategory);
		map.put("id", id);
		
        return ok(genres.render(map));
    }


	
}
