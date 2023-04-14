package com.clarivate.foodapp.services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.clarivate.foodapp.dao.ResponseStructure;
import com.clarivate.foodapp.dao.UserDao;
import com.clarivate.foodapp.dto.User;

@Service
public class UserServiceImpl {
	
	@Autowired
	UserDao userDao;
	
	public ResponseStructure<User> saveUser(User user){
		ResponseStructure<User> responseStructure = new ResponseStructure<User>();
		
		User tempUser = userDao.addUser(user);
		
		if(tempUser != null) {
			responseStructure.setStatusCode(HttpStatus.CREATED.value());
			responseStructure.setMsg("Data added into db successfully");
			responseStructure.setData(userDao.addUser(tempUser));
		}
		return responseStructure;
	}
	
	public ResponseStructure<List<User>> getAllUsers(){
		ResponseStructure<List<User>> responseStructure = new ResponseStructure<List<User>>();
		
		List<User> userList = userDao.getAllUsers();
		
		if (userList.isEmpty()) {
			responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
			responseStructure.setMsg("No data present in the db");
			responseStructure.setData(null);
		} else {
			responseStructure.setStatusCode(HttpStatus.FOUND.value());
			responseStructure.setMsg("User Details");
			responseStructure.setData(userList);
		}
		
		return responseStructure;
	}
	
	public ResponseStructure<User> getUserById(int id) {

		ResponseStructure<User> responseStructure = new ResponseStructure<User>();

		User user = userDao.getUserById(id);

		if (user != null) {
			responseStructure.setStatusCode(HttpStatus.FOUND.value());
			responseStructure.setMsg("User Details Obtained");
			responseStructure.setData(user);
		} else {
			responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
			responseStructure.setMsg("User Details Not Found");
			responseStructure.setData(null);
		}
		return responseStructure;
	}
	
	public ResponseStructure<User> getUser(User user) {

		ResponseStructure<User> responseStructure = new ResponseStructure<User>();

		User currentUser = userDao.getUser(user);
	
		if (currentUser != null) {
			responseStructure.setStatusCode(HttpStatus.FOUND.value());
			responseStructure.setMsg("User creds are correct");
			responseStructure.setData(currentUser);
		} else {
			responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
			responseStructure.setMsg("Invalid Email Id.");
			responseStructure.setData(null);
		}
		return responseStructure;
	}
	
	public ResponseStructure<List<User>> getStaff() {

		ResponseStructure<List<User>> responseStructure = new ResponseStructure<List<User>>();

		List<User> currentUser = userDao.getStaff();
	
		if (currentUser != null) {
			responseStructure.setStatusCode(HttpStatus.FOUND.value());
			responseStructure.setMsg("Staff Details");
			responseStructure.setData(currentUser);
		} else {
			responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
			responseStructure.setMsg("Invalid .");
			responseStructure.setData(null);
		}
		return responseStructure;
	}

	public ResponseStructure<String> deleteUser(int id) {

		ResponseStructure<String> responseStructure = new ResponseStructure<String>();

		User user = userDao.getUserById(id);

		if (user != null) {
			responseStructure.setStatusCode(HttpStatus.FOUND.value());
			responseStructure.setMsg("User Details Deleted Successfully");
			responseStructure.setData(userDao.deleteUser(id));
		} else {
			responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
			responseStructure.setMsg("User Details Not Found");
			responseStructure.setData(null);
		}
		return responseStructure;

	}

	public ResponseStructure<User> updateUser(User user,int id) {
		
		ResponseStructure<User> responseStructure = new ResponseStructure<User>();
		
		User u1 = userDao.getUserById(id);
		
		if (u1 == null) {
			responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
			responseStructure.setMsg("User data missing");
			responseStructure.setData(null);

		} else {
			responseStructure.setStatusCode(HttpStatus.FOUND.value());
			responseStructure.setMsg("User is present");
			responseStructure.setData(userDao.updateUser(user,id));

		}
		return responseStructure;

	}

	public ResponseStructure<User> isEmailRegistered(String email) {
		ResponseStructure<User> responseStructure = new ResponseStructure<User>();
		User user = userDao.isEmailRegistered(email);
		if (user == null) {
			responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
			responseStructure.setMsg("User data missing");
			responseStructure.setData(null);

		} else {
			responseStructure.setStatusCode(HttpStatus.FOUND.value());
			responseStructure.setMsg("User is present");
			responseStructure.setData(user);

		}
		return responseStructure;
	}

}
