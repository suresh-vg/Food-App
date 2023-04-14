package com.clarivate.foodapp.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
//import org.springframework.http.HttpStatus;

import com.clarivate.foodapp.dao.ResponseStructure;
import com.clarivate.foodapp.dto.User;
import com.clarivate.foodapp.services.UserServiceImpl;



@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	UserServiceImpl userService;

	
	@GetMapping("/get")
	public ResponseStructure<List<User>> getStaff() {
		return userService.getStaff();
	}
	
	
	@PostMapping("/save")
	public ResponseStructure<User> addUser(@RequestBody User user) {
		return userService.saveUser(user);
	}


	
	@GetMapping("/email/{email}")
	public ResponseStructure<User> isEmailRegistered(@PathVariable String email) {
		return userService.isEmailRegistered(email);
	}
	
	@PostMapping("/auth")
	public ResponseStructure<User> getUser(@RequestBody User user) {
		return userService.getUser(user);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseStructure<String> deleteUser(@PathVariable int id) {
		return userService.deleteUser(id);

	}

	@PutMapping("/update/{id}")
	public ResponseStructure<User> updateUser(@RequestBody User user,@PathVariable int id) {
		return userService.updateUser(user,id);
	}
	
	

}