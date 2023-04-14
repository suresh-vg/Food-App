package com.clarivate.foodapp.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import com.clarivate.foodapp.dto.Menu;



public interface MenuRepository  extends JpaRepository<Menu, Integer>{

	Menu findByUserId(int id);

}
