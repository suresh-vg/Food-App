package com.clarivate.foodapp.dao;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.clarivate.foodapp.dto.FoodProducts;
import com.clarivate.foodapp.dto.Menu;
import com.clarivate.foodapp.repository.FoodProductRepository;
import com.clarivate.foodapp.repository.MenuRepository;





@Component
public class FoodProductDao {
	@Autowired
	FoodProductRepository  foodProductRepository;
	
	@Autowired
	MenuRepository menuRepository;
	
	// POST  DAO's
	
	/**	
	 * Add's Single Food Products
	 * @param FoodProduct
	 * */
	public FoodProducts addFoodProduct(FoodProducts foodProduct) {
		return foodProductRepository.save(foodProduct);
	}

	public List<FoodProducts>  addAllFoodProducts(List<FoodProducts> foodProducts) {
		return foodProductRepository.saveAll(foodProducts);
	}
	
	//	GET  DAO's
	
	/**	
	 * Get's All Food Products
	 * */
	
	public List<FoodProducts> getAllFoodProduct(){
		return foodProductRepository.findAll();
	}
	
	/**	
	 * Get's All Food Products by menu_id
	 * @param menu_id
	 * */
	public List<FoodProducts> getFoodProductsByMenuId(int id){
		return foodProductRepository.findByMenuId(id);
	}
	

	/**	
	 * Get's All Food Products by id
	 * @param id
	 * */
	public FoodProducts getFoodProductById(int id) {
		Optional<FoodProducts> foodProduct = foodProductRepository.findById(id);
		
		if(foodProduct.isPresent()) {			
			return foodProduct.get();
		}
		else {
			return null;
		}
	}
	

	/**	
	 * Get's All Food Products by name containing string passed
	 * @param pattern
	 * */
	public List<FoodProducts> getFoodProductByNameContaining(String name) {
		List<FoodProducts> foodProduct = foodProductRepository.findByNameContaining(name);
		
		if(foodProduct.isEmpty()) {			
			return null;
		}
		else {
			return foodProduct;
		}
	}
	
	public List<FoodProducts> getFoodProductByType(String type) {
		List<FoodProducts> foodProduct = foodProductRepository.findByType(type);
		if(foodProduct.isEmpty()) {			
			return null;
		}
		else {
			return foodProduct;
		}
	}
	public List<FoodProducts> getFoodProductByAvailability(boolean type) {
		List<FoodProducts> foodProduct = foodProductRepository.findByAvailability(type);
		if(foodProduct.isEmpty()) {			
			return null;
		}
		else {
			return foodProduct;
		}
	}
	
	// PUT DAO's 

	/**	
	 * Update FoodProduts by id
	 * @param id
	 * */
	public FoodProducts updateFoodProduct(FoodProducts foodProduct,int menu_id,int product_id) {
		foodProduct.setId(product_id);
		Menu menu = menuRepository.getById(menu_id);
		foodProduct.setMenu(menu);
		return foodProductRepository.save(foodProduct);
	}
	
	
	// DELETE DAO's 
	
	/**	
	 * Delete FoodProduts by id
	 * @param id
	 * */
	public String deleteFoodProduct(int id) {
		Optional<FoodProducts> foodProduct = foodProductRepository.findById(id);
		
		if(foodProduct.isPresent()) {
			foodProductRepository.delete(foodProduct.get());
			return "Food product data "+ id +" has been deleted successfully";
		} else {
			return "Food product with ID:"+ id +" doesn't exist";
		}
	}
	/**	
	 * Delete FoodProduts by id
	 * @param id
	 * */
	// fp1 fp2 fp3
	public String deleteFoodProductByMenuId(int id) {
		List<FoodProducts> foodProduct = getFoodProductsByMenuId(id);
		
		if(!foodProduct.isEmpty()) {
			Iterator<FoodProducts> it = foodProduct.iterator();
			while(it.hasNext()) {
				deleteFoodProduct(it.next().getId());
			}
			return "Food product data with menu"+ id +" has been deleted successfully";
		} else {
			return "Food product with menu id:"+ id +" doesn't exist";
		}
	}

	public List<FoodProducts> get() {
		List<FoodProducts> foodProduct = foodProductRepository.findAllByOrderByTypeDesc();
		if(foodProduct.isEmpty()) {			
			return null;
		}
		else {
			return foodProduct;
		}
	}

	public List<String> getTypes() {
		List<String> types = foodProductRepository.getDistinctEmployeesByName();
		if(types.isEmpty()) {			
			return null;
		}
		else {
			return types;
		}
	}

	}
