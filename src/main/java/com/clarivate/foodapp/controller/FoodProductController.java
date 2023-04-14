package com.clarivate.foodapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.clarivate.foodapp.dao.ResponseStructure;
import com.clarivate.foodapp.dto.FoodProducts;
import com.clarivate.foodapp.repository.FoodProductRepository;
import com.clarivate.foodapp.services.FoodProductService;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/foodproducts")
public class FoodProductController {
	
	
	
	@Autowired
	FoodProductService foodProductService;

	/**
	 * @param foodProduct
	 * @param id
	 * @return
	 */
	@PostMapping("/save/{menu_id}")
	public ResponseStructure<List<FoodProducts>> saveAllFoodProducts(@RequestBody List<FoodProducts> foodProduct,@PathVariable int menu_id) {
		return foodProductService.saveAllFoodProducts(foodProduct,menu_id);
	}
	
	// return all menu 
//	@GetMapping("/get")
//	public ResponseStructure<List<FoodProducts>> getAllFoodProduct() {
//		return foodProductService.getAllFoodProducts();
//	}
//	
	
	// By menu id
	@GetMapping("/get/{menu_id}")
	public ResponseStructure<List<FoodProducts>> getFoodProductsByMenuId(@PathVariable int menu_id) {
		return foodProductService.getFoodProductsByMenuId(menu_id);
	}
	
	@GetMapping("/getbyfoodProduct/{id}")
	public ResponseStructure<FoodProducts> getFoodProductById(@PathVariable int id) {
		return foodProductService.getFoodProductsById(id);
	}

	@GetMapping("/name/{name}")
	public ResponseStructure<List<FoodProducts>> getFoodProductByNameContaining(@PathVariable String name) {
		return foodProductService.getFoodProductsByNameContaining(name);
	}
	
	@GetMapping("/type/{type}")
	public ResponseStructure<List<FoodProducts>> getFoodProductByType(@PathVariable String type) {
		return foodProductService.getFoodProductsByType(type);
	}
	
	@GetMapping("/availability/{availability}")
	public ResponseStructure<List<FoodProducts>> getFoodProductByAvailability(@PathVariable boolean availability) {
		return foodProductService.getFoodProductsByAvailability(availability);
	}
	
	
	@DeleteMapping("/delete/{id}")
	public ResponseStructure<String> deleteFoodProduct(@PathVariable int id) {
		return foodProductService.deleteFoodProducts(id);
	}

	@DeleteMapping("/deleteAll/{menu_id}")
	public ResponseStructure<String> deleteAllFoodProductsByMenuId(@PathVariable int id) {
		return foodProductService.deleteFoodProductsByMenuId(id);
	}
	
	@PutMapping("/update/{menu_id}/{product_id}")
	public ResponseStructure<FoodProducts> updateFoodProducts(@RequestBody FoodProducts foodProduct,@PathVariable int menu_id,@PathVariable int product_id) {
		return foodProductService.updateFoodProducts(foodProduct,menu_id,product_id);
	}
	
	@GetMapping("/orderby")
	public ResponseStructure<List<FoodProducts>> get(){
		return foodProductService.get();
	}
	
	@GetMapping("/types")
	public ResponseStructure<List<String>> getTypes(){
		return foodProductService.getTypes();
	}
	
}
