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
import com.clarivate.foodapp.dto.Item;
import com.clarivate.foodapp.services.ItemService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/items")
public class ItemController {

	@Autowired
	ItemService itemService;


	@PostMapping("/save/{food_order_id}")
	public ResponseStructure<List<Item>> saveAllItem(@RequestBody List<Item> item, @PathVariable int food_order_id) {
		System.out.println(item);
		return itemService.saveAllItem(item, food_order_id);
	}

	/** Get All Item */
	@GetMapping("/get")
	public ResponseStructure<List<Item>> getAllItems() {
		return itemService.getAllItems();
	}

	/** Get Item By Using Id */
	@GetMapping("/get/{id}")
	public ResponseStructure<Item> getItemById(@PathVariable int id) {
		return itemService.getItemById(id);
	}


	@DeleteMapping("/delete/{id}")
	public ResponseStructure<String> deleteItem(@PathVariable int id) {
		return itemService.deleteItem(id);
	}

	@PutMapping("/update/{id}")
	public ResponseStructure<Item> updateItem(@RequestBody Item item, @PathVariable int id) {
		return itemService.updateItem(item, id);
	}
	@GetMapping("/getdistval")
	public int get(){
		return itemService.get();
	}
}