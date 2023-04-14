package com.clarivate.foodapp.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "item")
public class Item {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String type;
	private int quantity;
	private float price;

//	
	@ManyToOne
	@JoinColumn
	private FoodOrder foodOrder;
	
	@JsonBackReference
	public FoodOrder getFoodOrder() {
		return foodOrder;
	}
//
	public void setFoodOrder(FoodOrder foodOrder) {
		this.foodOrder = foodOrder;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public int getId() {
		return this.id;
	}
	@Override
	public String toString() {
		return "Item [id=" + id + ", name=" + name + ", type=" + type + ", quantity=" + quantity + ", price=" + price
				+ ", foodOrder=" + foodOrder + "]";
	}

}
