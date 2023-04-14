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
import com.clarivate.foodapp.dto.FoodOrder;
import com.clarivate.foodapp.services.FoodOrderService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/foodorder")
public class FoodOrderController {
	
	@Autowired
	FoodOrderService foodOrderService;

	@PostMapping("/save/{staff_id}")
	public ResponseStructure<FoodOrder> saveFoodOrder(@RequestBody FoodOrder foodOrder,@PathVariable int staff_id) {
		return foodOrderService.saveFoodOrder(foodOrder, staff_id);
	}
//
	@GetMapping("/get")
	public ResponseStructure<List<FoodOrder>> getAllFoodOrders() {
		return foodOrderService.getAllFoodOrdersData();
	}

	@GetMapping("/get/{staff_id}")
	public ResponseStructure<List<FoodOrder>> getFoodOrderByStaffId(@PathVariable int staff_id) {
		return foodOrderService.getFoodOrderByStaffId(staff_id);
	}
	
	@GetMapping("/bill/{id}")
	public ResponseStructure<FoodOrder> getFoodOrderById(@PathVariable int id) {
		return foodOrderService.getFoodOrderById(id);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseStructure<String> deleteFoodOrder(@PathVariable int id) {
		return foodOrderService.deleteFoodOrder(id);

	}

	@PutMapping("/update/{staff_id}/{foodOrder_id}")
	public ResponseStructure<FoodOrder> updateFoodOrder(@RequestBody FoodOrder foodOrder,@PathVariable int staff_id,@PathVariable Integer foodOrder_id) {
		return foodOrderService.updateFoodOrder(foodOrder,staff_id,foodOrder_id);
	}
	
	@GetMapping("/total-count/{staff_id}")
	public int foodOrderCount(@PathVariable int staff_id) {
		return foodOrderService.totalCount(staff_id);
	}
	
	@GetMapping("/count-status/{status}")
	public int foodOrderCountByStatus(@PathVariable String  status) {
		return foodOrderService.statusCount(status);
	}
	
}
//	@PutMapping("/foodOrder/update")
//	public ResponseStructure<FoodOrder> updateFoodOrder(@RequestBody FoodOrder foodOrder) {
//		return foodOrderService.updateFoodOrderByStaffId(foodOrder);
//	}
	
//	@PutMapping("/foodOrder/{id}/{status}")
//	public ResponseStructure<FoodOrder> upateFoodOrderStatus(@RequestBody FoodOrder foodOrder, @PathVariable String status,@PathVariable int id){
//		return foodOrderService.updateFoodOrderStatus(foodOrder,status,id);
//	}
	