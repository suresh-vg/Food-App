package com.clarivate.foodapp.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.clarivate.foodapp.dto.Item;
import com.clarivate.foodapp.dto.User;
import com.clarivate.foodapp.repository.ItemRepository;

@Component
public class ItemDao {

	private static final Optional<Item> Item = null;
	
	@Autowired
	ItemRepository itemRepository;
	
	public Item  addItem(Item item) {
		return itemRepository.save(item);
	}
	
	public List<Item>  addAllItem(List<Item> item) {
		return itemRepository.saveAll(item);  
	}
	
	public List<Item> getAllItems(){
		return itemRepository.findAll();
	}
	
	
	public Item getItemById(int id) {
		Optional<Item> item = itemRepository.findById(id);
		return item.get();
	}
	
	
	
	public String deleteItem(int id) {
		Optional<Item> optional = itemRepository.findById(id);
		
		if(optional.isPresent()) {
			itemRepository.delete(optional.get());
			return "Item data "+ id +" has been deleted successfully";
		} else {
			return "Item data with ID:"+ id +" doesn't exist";
		}
	}
	
	public Item updateItem (Item item) {
		return itemRepository.save(item);
	}

	public int get() {
		int count = itemRepository.countByName("Paneer Chilly");
		return count;
	}


	
	
}
