package com.clarivate.foodapp.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.clarivate.foodapp.dto.FoodOrder;

public interface FoodOrderRepository  extends JpaRepository<FoodOrder, Integer>{

	public FoodOrder findByUserIdAndId(int id,int id1);

	public List<FoodOrder> findByUserId(int id);

	public int countByUserId(int staff_id);
	
	public int countByStatus(String status);


}
