package com.clarivate.foodapp.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.clarivate.foodapp.dto.FoodOrder;
import com.clarivate.foodapp.dto.User;
import com.clarivate.foodapp.repository.FoodOrderRepository;
import com.clarivate.foodapp.repository.UserRepository;


@Component
public class FoodOrderDao {
	
	private static final Optional<FoodOrder> foodOrder = null;

	@Autowired
	FoodOrderRepository foodOrderRepository;
	
	@Autowired
	UserRepository userRepository;

	public FoodOrder addFoodOrder(FoodOrder foodOrder) {
		return foodOrderRepository.save(foodOrder);
	}

	public List<FoodOrder> getAllFoodOrder() {
		return foodOrderRepository.findAll();
	}

	public FoodOrder getFoodOrderById(int id) {
		Optional<FoodOrder> foodOrder = foodOrderRepository.findById(id);
		
		if(foodOrder.isPresent()) {			
			return foodOrder.get();
		}
		else {
			return null;
		}
	}
	
	public String deleteFoodOrder(int id) {
		Optional<FoodOrder> foodOrder = foodOrderRepository.findById(id);
		
		if(foodOrder.isPresent()) {
			foodOrderRepository.delete(foodOrder.get());
			return "Food order data "+ id +" has been deleted successfully";
		} else {
			return "Food order with ID:"+ id +" doesn't exist";
		}
	}
	
	public FoodOrder updateFoodOrder(FoodOrder foodOrder,int user_id,int foodOrder_id) {
		// user Object
		User user = userRepository.getById(user_id);
		
		
		foodOrder.setId(foodOrder_id);
		foodOrder.setUser(user);
		
		// Update food order
		
//		currentFoodOrder.setCustomerName(foodOrder.getCustomerName()); // name
//		currentFoodOrder.setContactNumber(foodOrder.getContactNumber()); // number
//		currentFoodOrder.setOrderCreatedTime(foodOrder.getOrderCreatedTime()); // created time
//		currentFoodOrder.setOrderDeliveryTime(foodOrder.getOrderDeliveryTime()); // order time
//		currentFoodOrder.setTotalPrice(foodOrder.getTotalPrice()); // price
//		currentFoodOrder.setStatus(foodOrder.isStatus()); // status
//		currentFoodOrder.setUser(user); // user
//		currentFoodOrder.setId(foodOrder_id); // order id
		
		return foodOrderRepository.save(foodOrder);
	}


	public FoodOrder updateFoodOrderSave(FoodOrder foodOrder, String status, int id) {
		return foodOrderRepository.save(foodOrder);
	}

	public FoodOrder updateFoodOrderSaveByStaffId(FoodOrder foodOrder2) {
		FoodOrder foodOrder = foodOrderRepository.findByUserIdAndId(foodOrder2.getId(),foodOrder2.getId());
		return foodOrder;
	}

	public List<FoodOrder> getFoodOrderByUserId(int id) {
		List<FoodOrder> foodOrder = foodOrderRepository.findByUserId(id);
		
		if(foodOrder.isEmpty()) {
			return foodOrder;
		}
		return foodOrder;
	}

	public int countById(int staff_id) {
		int count = foodOrderRepository.countByUserId(staff_id);
		return count;
	}

	public int countByStatus(String status) {
		int count = foodOrderRepository.countByStatus(status);
		return count;
	}

}
// initial commit
