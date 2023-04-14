package com.clarivate.foodapp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.clarivate.foodapp.dao.FoodOrderDao;
import com.clarivate.foodapp.dao.ResponseStructure;
import com.clarivate.foodapp.dao.UserDao;
import com.clarivate.foodapp.dto.FoodOrder;
import com.clarivate.foodapp.dto.Menu;
import com.clarivate.foodapp.dto.User;

@Service
public class FoodOrderService {
	
	@Autowired
	FoodOrderDao foodOrderDao;

	@Autowired
	UserDao userDao;
// Create new food order
//	public ResponseStructure<FoodOrder> saveFoodOrder(FoodOrder foodOrder) {
//		ResponseStructure<FoodOrder> responseStructure = new ResponseStructure<FoodOrder>();
//		
//		FoodOrder foodOrder1 = foodOrderDao.addFoodOrder(foodOrder);
//
//		if (foodOrder1 != null) {
//			responseStructure.setStatusCode(HttpStatus.CREATED.value());
//			responseStructure.setMsg("Data added into db successfully");
//			responseStructure.setData(foodOrderDao.addFoodOrder(foodOrder1));
//		}
//		return responseStructure;
//	}

	
		public ResponseStructure<FoodOrder> saveFoodOrder(FoodOrder foodOrder, int id){
		
		ResponseStructure<FoodOrder> response = new ResponseStructure<FoodOrder>();
		
		User user = userDao.getUserById(id);
		
		if(user == null) {
			response.setStatusCode(HttpStatus.NOT_FOUND.value());
			response.setMsg("Food Order not found");
			response.setData(null);
		} else {
			response.setStatusCode(HttpStatus.FOUND.value());
			response.setMsg("Food Order Details");
			foodOrder.setUser(user);
			response.setData(foodOrderDao.addFoodOrder(foodOrder));
			
		}
		return response;
		
	}
	
		
	// Get All food orders
	
	public ResponseStructure<List<FoodOrder>> getAllFoodOrdersData() {

		ResponseStructure<List<FoodOrder>> responseStructure = new ResponseStructure<List<FoodOrder>>();

		List<FoodOrder> foodOrderList = foodOrderDao.getAllFoodOrder();

		if (foodOrderList.isEmpty()) {
			responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
			responseStructure.setMsg("No data present in the db");
			responseStructure.setData(null);
		} else {
			responseStructure.setStatusCode(HttpStatus.FOUND.value());
			responseStructure.setMsg("Food Order Details");
			responseStructure.setData(foodOrderList);
		}
		return responseStructure;
	}

	// Get food order by Id
	
	public ResponseStructure<List<FoodOrder>> getFoodOrderByStaffId(int id) {

		ResponseStructure<List<FoodOrder>> responseStructure = new ResponseStructure<List<FoodOrder>>();

		List<FoodOrder> foodOrder = foodOrderDao.getFoodOrderByUserId(id);

		if (!foodOrder.isEmpty()) {
			responseStructure.setStatusCode(HttpStatus.FOUND.value());
			responseStructure.setMsg("Food Order details Obtained");
			responseStructure.setData(foodOrder);
		} else {
			responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
			responseStructure.setMsg("No Food Order Found");
			responseStructure.setData(null);
		}
		return responseStructure;
	}

	public ResponseStructure<FoodOrder> getFoodOrderById(int id) {

		ResponseStructure<FoodOrder> responseStructure = new ResponseStructure<FoodOrder>();

		FoodOrder foodOrder = foodOrderDao.getFoodOrderById(id);

		if (foodOrder != null) {
			responseStructure.setStatusCode(HttpStatus.FOUND.value());
			responseStructure.setMsg("Food Order details Obtained");
			responseStructure.setData(foodOrder);
		} else {
			responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
			responseStructure.setMsg("Food Order details Not Found");
			responseStructure.setData(null);
		}
		return responseStructure;
	}

	
	// Delete food order by id
	
	public ResponseStructure<String> deleteFoodOrder(int id) {

		ResponseStructure<String> responseStructure = new ResponseStructure<String>();

		FoodOrder foodOrder = foodOrderDao.getFoodOrderById(id);

		if (foodOrder != null) {
			responseStructure.setStatusCode(HttpStatus.FOUND.value());
			responseStructure.setMsg("Food Order details Deleted Successfully");
			responseStructure.setData(foodOrderDao.deleteFoodOrder(id));
		} else {
			responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
			responseStructure.setMsg("Food Order details Not Found");
			responseStructure.setData(null);
		}
		return responseStructure;

	}

	
	// Update food order by id
	
	public ResponseStructure<FoodOrder> updateFoodOrder(FoodOrder foodOrder, int user_id, int foodOrder_id) {
		
		ResponseStructure<FoodOrder> responseStructure = new ResponseStructure<FoodOrder>();
		
		FoodOrder foodOrder1 = foodOrderDao.getFoodOrderById(foodOrder_id); 
		
		if (foodOrder1 == null) {
			responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
			responseStructure.setMsg("Food Order data not found");
			responseStructure.setData(null);

		} else {
			responseStructure.setStatusCode(HttpStatus.FOUND.value());
			responseStructure.setMsg("Food Order is present");
			responseStructure.setData(foodOrderDao.updateFoodOrder(foodOrder,user_id,foodOrder_id));

		}
		return responseStructure;

	}


	public ResponseStructure<FoodOrder> updateFoodOrderStatus(FoodOrder foodOrder, String status,int id) {
ResponseStructure<FoodOrder> responseStructure = new ResponseStructure<FoodOrder>();
		
		
		if (foodOrder == null) {
			responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
			responseStructure.setMsg("Food Order data not found");
			responseStructure.setData(null);

		} else {
			responseStructure.setStatusCode(HttpStatus.FOUND.value());
			responseStructure.setMsg("Food Order is present");
			responseStructure.setData(foodOrderDao.updateFoodOrderSave(foodOrder,status,id));

			return responseStructure;
		}
		return null;
	}


	public ResponseStructure<FoodOrder> updateFoodOrderByStaffId(FoodOrder foodOrder) {
		
ResponseStructure<FoodOrder> responseStructure = new ResponseStructure<FoodOrder>();
		
		
		if (foodOrder == null) {
			responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
			responseStructure.setMsg("Food Order data not found");
			responseStructure.setData(null);

		} else {
			responseStructure.setStatusCode(HttpStatus.FOUND.value());
			responseStructure.setMsg("Food Order is present");
			responseStructure.setData(foodOrderDao.updateFoodOrderSaveByStaffId(foodOrder));

			return responseStructure;
		}
		return null;
	}


	public int totalCount(int staff_id) {
		
		int  foodOrderCount = foodOrderDao.countById(staff_id);
		if (foodOrderCount > -1) {
			return foodOrderCount;
		} else {			
			return 0;
		}
	}


	public int statusCount(String status) {
		int  foodOrderCount = foodOrderDao.countByStatus(status);
		if (foodOrderCount > -1) {
			return foodOrderCount;
		} else {			
			return 0;
		}
	}
}