package com.clarivate.foodapp.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.clarivate.foodapp.dto.Menu;
import com.clarivate.foodapp.repository.MenuRepository;

@Component
public class MenuDao {
	private static final Optional<Menu> Menu = null;
	
	@Autowired
	MenuRepository menuRepository;
	
	public Menu addMenu(Menu menu) {
		return menuRepository.save(menu);
	}
	
	public List<Menu> getAllMenu(){
		return menuRepository.findAll();
	}

	public Menu getMenuById(int id) {
		Optional<Menu> menu = menuRepository.findById(id);
		if(menu.isPresent()) {
			return menu.get();
		}
		return null;
	}
	public Menu updateMenu(Menu menu) {
		
		return menuRepository.save(menu);
	}

	public String deleteMenu(int id) {
		Optional<Menu> menu = menuRepository.findById(id);
		if(menu.isPresent()) {
			menuRepository.delete(menu.get());
			return "Menu has been deleted";
		}
		
		return "Menu Id dosen't exists";
	}

	public Menu getMenuByUserId(int id) {
		Menu menu = menuRepository.findByUserId(id);
		if(menu != null) {
			return menu;
		}
		return null;
	}
}
