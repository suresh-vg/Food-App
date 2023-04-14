package com.clarivate.foodapp.services;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.clarivate.foodapp.dao.FoodProductDao;
import com.clarivate.foodapp.dao.MenuDao;
import com.clarivate.foodapp.dao.ResponseStructure;
import com.clarivate.foodapp.dto.FoodOrder;
import com.clarivate.foodapp.dto.FoodProducts;
import com.clarivate.foodapp.dto.Item;
import com.clarivate.foodapp.dto.Menu;


@Service
public class FoodProductService {

	@Autowired
	FoodProductDao foodProductDao;
	@Autowired
	MenuDao menuDao;
	
	/*public ResponseStructure<FoodProducts> saveFoodProducts(FoodProducts foodProduct) {
		ResponseStructure<FoodProducts> responseStructure = new ResponseStructure<FoodProducts>();

		FoodProducts foodProduct1 = foodProductDao.addFoodProduct(foodProduct);

		if (foodProduct1 != null) {
			responseStructure.setStatusCode(HttpStatus.CREATED.value());
			responseStructure.setMsg("Data added into db successfully");
			responseStructure.setData(foodProductDao.addFoodProduct(foodProduct1));
		}
		return responseStructure;
	}*/
	
	/**
	 * @param foodProduct
	 * @param id
	 * @return
	 */
	public ResponseStructure<FoodProducts> saveFoodProducts(FoodProducts foodProduct, int id) {
	ResponseStructure<FoodProducts> response= new ResponseStructure<FoodProducts>();
	 
	Menu menu =menuDao.getMenuById(id);
	System.out.println(menu);
	if(menu == null) {
		response.setStatusCode(HttpStatus.NOT_FOUND.value());
        response.setMsg("Food Product not saved");
        response.setData(null);
		
	}
	else {
		response.setStatusCode(HttpStatus.FOUND.value());
        response.setMsg("Food Product Details");
        foodProduct.setMenu(menu);
        response.setData(foodProductDao.addFoodProduct(foodProduct));
	}
	return response;
	
	}
	
	/**
	 * @param foodProducts
	 * @param id
	 * @return
	 */
	public ResponseStructure<List<FoodProducts>> saveAllFoodProducts(List<FoodProducts> foodProducts, int id) {

		ResponseStructure<List<FoodProducts>> response = new ResponseStructure<List<FoodProducts>>();
		
		// menu -> 1
		// menu -> { id,userid}
		Menu menu = menuDao.getMenuById(id);
		
		if (menu == null) {
			response.setStatusCode(HttpStatus.NOT_FOUND.value());
			response.setMsg("Food Products not  saved");
			response.setData(null);
		} else {
			response.setStatusCode(HttpStatus.FOUND.value());
			response.setMsg("Food Products Details has been saved");
			
			Iterator<FoodProducts> it = foodProducts.iterator();
			while (it.hasNext()) {
				it.next().setMenu(menu);
			}
			
			response.setData(foodProductDao.addAllFoodProducts(foodProducts));
		}
		return response;
	}

	
	

	/**
	 * @return
	 */
	public ResponseStructure<List<FoodProducts>> getAllFoodProducts() {

		ResponseStructure<List<FoodProducts>> responseStructure = new ResponseStructure<List<FoodProducts>>();

		List<FoodProducts> foodProductList = foodProductDao.getAllFoodProduct();

		if (foodProductList.isEmpty()) {
			responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
			responseStructure.setMsg("No data present in the db");
			responseStructure.setData(null);
		} else {
			responseStructure.setStatusCode(HttpStatus.FOUND.value());
			responseStructure.setMsg("Food Product Details");
			responseStructure.setData(foodProductList);
		}
		return responseStructure;
	}
	
	/**
	 * @param id
	 * @return
	 */
	public ResponseStructure<FoodProducts> getFoodProductsById(int id) {

		ResponseStructure<FoodProducts> responseStructure = new ResponseStructure<FoodProducts>();

		FoodProducts foodProduct = foodProductDao.getFoodProductById(id);

		if (foodProduct != null) {
			responseStructure.setStatusCode(HttpStatus.FOUND.value());
			responseStructure.setMsg("Food Product details Obtained");
			responseStructure.setData(foodProduct);
		} else {
			responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
			responseStructure.setMsg("Food product details Not Found");
			responseStructure.setData(null);
		}
		return responseStructure;
	}
	
	/**
	 * @param id
	 * @return
	 */
	public ResponseStructure<List<FoodProducts>> getFoodProductsByMenuId(int id) {

		ResponseStructure<List<FoodProducts>> responseStructure = new ResponseStructure<List<FoodProducts>>();

		List<FoodProducts> foodProduct = foodProductDao.getFoodProductsByMenuId(id);

		if (foodProduct != null) {
			responseStructure.setStatusCode(HttpStatus.FOUND.value());
			responseStructure.setMsg("Food Product details Obtained");
			responseStructure.setData(foodProduct);
		} else {
			responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
			responseStructure.setMsg("Food product details Not Found");
			responseStructure.setData(null);
		}
		return responseStructure;
	}
	
	/**
	 * @param name
	 * @return
	 */
	public ResponseStructure<List<FoodProducts>> getFoodProductsByNameContaining(String name) {

		ResponseStructure<List<FoodProducts>> responseStructure = new ResponseStructure<List<FoodProducts>>();

		List<FoodProducts> foodProduct = foodProductDao.getFoodProductByNameContaining(name);

		if (foodProduct != null) {
			responseStructure.setStatusCode(HttpStatus.FOUND.value());
			responseStructure.setMsg("Food Product details Obtained");
			responseStructure.setData(foodProduct);
		} else {
			responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
			responseStructure.setMsg("Food product details Not Found");
			responseStructure.setData(null);
		}
		return responseStructure;
	}
	
	public ResponseStructure<List<FoodProducts>> getFoodProductsByType(String type) {

		ResponseStructure<List<FoodProducts>> responseStructure = new ResponseStructure<List<FoodProducts>>();

		List<FoodProducts> foodProduct = foodProductDao.getFoodProductByType(type);

		if (foodProduct != null) {
			responseStructure.setStatusCode(HttpStatus.FOUND.value());
			responseStructure.setMsg("Food Product details Obtained");
			responseStructure.setData(foodProduct);
		} else {
			responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
			responseStructure.setMsg("Food product details Not Found");
			responseStructure.setData(null);
		}
		return responseStructure;
	}

	public ResponseStructure<List<FoodProducts>> getFoodProductsByAvailability(boolean type) {

		ResponseStructure<List<FoodProducts>> responseStructure = new ResponseStructure<List<FoodProducts>>();

		List<FoodProducts> foodProduct = foodProductDao.getFoodProductByAvailability(type);

		if (foodProduct != null) {
			responseStructure.setStatusCode(HttpStatus.FOUND.value());
			responseStructure.setMsg("Food Product details Obtained");
			responseStructure.setData(foodProduct);
		} else {
			responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
			responseStructure.setMsg("Food product details Not Found");
			responseStructure.setData(null);
		}
		return responseStructure;
	}
	
	// Delete food order by id
	
	/**
	 * @param id
	 * @return String
	 */
	public ResponseStructure<String> deleteFoodProducts(int id) {

		ResponseStructure<String> responseStructure = new ResponseStructure<String>();

		FoodProducts foodProduct = foodProductDao.getFoodProductById(id);

		if (foodProduct != null) {
			responseStructure.setStatusCode(HttpStatus.FOUND.value());
			responseStructure.setMsg("Food Product details Deleted Successfully");
			responseStructure.setData(foodProductDao.deleteFoodProduct(id));
		} else {
			responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
			responseStructure.setMsg("Food Product details Not Found");
			responseStructure.setData(null);
		}
		return responseStructure;

	}
	
	/**
	 * @param id
	 * @return
	 */
	public ResponseStructure<String> deleteFoodProductsByMenuId(int id) {

		ResponseStructure<String> responseStructure = new ResponseStructure<String>();

		List<FoodProducts> foodProduct = foodProductDao.getFoodProductsByMenuId(id);

		if (foodProduct != null) {
			responseStructure.setStatusCode(HttpStatus.FOUND.value());
			responseStructure.setMsg("Food Product details Deleted Successfully");
			responseStructure.setData(foodProductDao.deleteFoodProductByMenuId(id));
		} else {
			responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
			responseStructure.setMsg("Food Product details Not Found");
			responseStructure.setData(null);
		}
		return responseStructure;

	}

	
	// Update food order by id
	
	/**
	 * @param foodProduct
	 * @param id
	 * @return
	 */
	public ResponseStructure<FoodProducts> updateFoodProducts(FoodProducts foodProduct,int menu_id,int product_id) {
		
		ResponseStructure<FoodProducts> responseStructure = new ResponseStructure<FoodProducts>();
		
//		FoodProducts foodProduct1 = foodProductDao.getFoodProductById(id);
		
		if (foodProduct == null) {
			responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
			responseStructure.setMsg("Food Products data not found");
			responseStructure.setData(null);

		} else {
			responseStructure.setStatusCode(HttpStatus.FOUND.value());
			responseStructure.setMsg("Food Product is present");
			responseStructure.setData(foodProductDao.updateFoodProduct(foodProduct, menu_id,product_id));

		}
		return responseStructure;

	}

	public ResponseStructure<List<FoodProducts>> get() {
		ResponseStructure<List<FoodProducts>> responseStructure = new ResponseStructure<List<FoodProducts>>();
		List<FoodProducts> foodProduct = foodProductDao.get();
		if (foodProduct == null) {
			responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
			responseStructure.setMsg("Food Products data not found");
			responseStructure.setData(null);

		} else {
			responseStructure.setStatusCode(HttpStatus.FOUND.value());
			responseStructure.setMsg("Food Product is present");
			responseStructure.setData(foodProduct);

		}
		return responseStructure;

	}

	public ResponseStructure<List<String>> getTypes() {
		ResponseStructure<List<String>> responseStructure = new ResponseStructure<List<String>>();
		List<String> types = foodProductDao.getTypes();
		if (types == null) {
			responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
			responseStructure.setMsg("Failed to retrive Distinct values");
			responseStructure.setData(null);

		} else {
			responseStructure.setStatusCode(HttpStatus.FOUND.value());
			responseStructure.setMsg("Retrived Distinct Values Of Type");
			responseStructure.setData(types);

		}
		return responseStructure;
	}
}
