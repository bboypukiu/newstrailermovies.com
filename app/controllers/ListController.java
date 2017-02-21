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
public class ListController extends Controller {

	@SuppressWarnings("static-access")
	public static Result list() {
	Map<String, Object> map = new HashMap<String, Object>();

		
		ProductServices service  = new ProductServices();
		//list productBaner
		List<Product> listAllProduct =service.listAllProduct();
        //	list	banner-bottom 
		
		map.put("listAllProduct", listAllProduct);

        return ok(list.render(map));
    }


	
}
