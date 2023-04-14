package com.clarivate.foodapp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.clarivate.foodapp.dao.MenuDao;
import com.clarivate.foodapp.dao.ResponseStructure;
import com.clarivate.foodapp.dao.UserDao;
import com.clarivate.foodapp.dto.Menu;
import com.clarivate.foodapp.dto.User;

@Service
public class MenuService {

	@Autowired
	MenuDao menuDao;
	
	@Autowired
	UserDao userDao;
	
/**	
	public ResponseStructure<Menu> saveMenu(Menu menu){
		
		ResponseStructure<Menu> response = new ResponseStructure<Menu>();
		
		Menu Menu2 = menuDao.addMenu(menu);
		
		if(Menu2 != null) {
			response.setStatusCode(HttpStatus.CREATED.value());
			response.setMsg("Menu added successfully");
			response.setData(Menu2);
		}
		return response;
	}
	*/
	
	public ResponseStructure<Menu> saveMenu(Menu menu, int id){
		
		ResponseStructure<Menu> response = new ResponseStructure<Menu>();
		
		User user = userDao.getUserById(id);
		System.out.println(user);
		if(user == null) {
			response.setStatusCode(HttpStatus.NOT_FOUND.value());
			response.setMsg("Menu not saved");
			response.setData(null);
		} else {
			response.setStatusCode(HttpStatus.FOUND.value());
			response.setMsg("Menu Details");
			menu.setUser(user);
			response.setData(menuDao.addMenu(menu));
			
		}
		return response;
		
	}
	
	
	
	public ResponseStructure<List<Menu>> getAllMenus(){
		
		ResponseStructure<List<Menu>> response = new ResponseStructure<List<Menu>>();
		List<Menu> list=menuDao.getAllMenu();
		
		if(list.isEmpty()) {
			response.setStatusCode(HttpStatus.NOT_FOUND.value());
			response.setMsg("Menu not found");
			response.setData(null);
		} else {
			response.setStatusCode(HttpStatus.FOUND.value());
			response.setMsg("Menu Details");
			response.setData(list);
			
		}
		return response;
	}
	
	public ResponseStructure<Menu> getMenuById(int id) {

		ResponseStructure<Menu> responseStructure = new ResponseStructure<Menu>();

		Menu menu = menuDao.getMenuById(id);

		if (menu != null) {
			responseStructure.setStatusCode(HttpStatus.FOUND.value());
			responseStructure.setMsg("Menu Details Obtained");
			responseStructure.setData(menu);
		} else {
			responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
			responseStructure.setMsg("Menu Details Not Found");
			responseStructure.setData(null);
		}
		return responseStructure;
	
	}
	
	public ResponseStructure<String> deleteMenu(int id) {

		ResponseStructure<String> responseStructure = new ResponseStructure<String>();

		Menu user = menuDao.getMenuById(id);

		if (user != null) {
			responseStructure.setStatusCode(HttpStatus.FOUND.value());
			responseStructure.setMsg("Menu Details Deleted Successfully");
			responseStructure.setData(menuDao.deleteMenu(id));
		} else {
			responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
			responseStructure.setMsg("Menu Details Not Found");
			responseStructure.setData(null);
		}
		return responseStructure;

	}

	public ResponseStructure<Menu> updateMenu(Menu user,int id) {
		
		ResponseStructure<Menu> responseStructure = new ResponseStructure<Menu>();
		
		Menu u1 = menuDao.getMenuById(id);
		
		if (u1 == null) {
			responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
			responseStructure.setMsg("Menu data missing");
			responseStructure.setData(null);

		} else {
			responseStructure.setStatusCode(HttpStatus.FOUND.value());
			responseStructure.setMsg("Menu is present");
			responseStructure.setData(menuDao.updateMenu(user));

		}
		return responseStructure;

	}



	public ResponseStructure<Menu> getMenuByUserId(int id) {
		ResponseStructure<Menu> responseStructure = new ResponseStructure<Menu>();

		Menu menu = menuDao.getMenuByUserId(id);

		if (menu != null) {
			responseStructure.setStatusCode(HttpStatus.FOUND.value());
			responseStructure.setMsg("Menu Details Obtained");
			responseStructure.setData(menu);
		} else {
			responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
			responseStructure.setMsg("Menu Details Not Found");
			responseStructure.setData(null);
		}
		return responseStructure;
	}
	

}
