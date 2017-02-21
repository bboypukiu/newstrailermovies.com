package models.util;

import java.util.List;

import models.entity.auto.Country;
import models.entity.auto.Productcategory;
import models.entity.auto.Producttype;
import services.CountryServices;
import services.ProductCategoryServices;
import services.ProductTypeServices;

public class CommonData {
	
	public static List<Producttype> listAllProductType(){
		List<Producttype> listAllProductType = ProductTypeServices.listAllProductType();
		return listAllProductType;
	}
	
	
	public static List<Productcategory> listAllProductCategory(){
		ProductCategoryServices proCateService = new ProductCategoryServices();
		List<Productcategory> listAllProductCategory = proCateService.listAllProductCategory();
		return listAllProductCategory;
	}
	
	public static List<Country> listAllCountry(){
		CountryServices service = new CountryServices();
		List<Country> listAllCountry = service.listAllCountry();
		return listAllCountry;
	}

}
