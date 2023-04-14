package com.clarivate.foodapp.repository;



import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.clarivate.foodapp.dto.Item;

public interface ItemRepository  extends JpaRepository<Item, Integer>{


	int countByName(String name);

	

}
