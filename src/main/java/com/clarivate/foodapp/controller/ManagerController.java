package com.clarivate.foodapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.clarivate.foodapp.dao.ResponseStructure;
import com.clarivate.foodapp.dto.Menu;
import com.clarivate.foodapp.services.MenuService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/manager")
public class ManagerController {

	@Autowired
	MenuService menuService;
	
	@GetMapping("/menu/{menu_id}")
	public ResponseStructure<Menu> getAvailableItems(@PathVariable int menu_id) {
		return menuService.getMenuById(menu_id);
	}
}
