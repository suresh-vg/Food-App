package com.clarivate.foodapp.dto;



import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="foodOrder")
public class FoodOrder {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String status;
	private float totalPrice;

	private String orderCreatedTime;

	private String orderDeliveryTime;
	
	private String customerName;
	private long contactNumber;

	
	@OneToMany(cascade = CascadeType.ALL,mappedBy="foodOrder",fetch=FetchType.LAZY)
	private List<Item> item;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;

	@JsonManagedReference
	public List<Item> getItem() {
		return item;
	}

	public void setItem(List<Item> item) {
		this.item = item;
	}

	@JsonBackReference
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public float getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(float totalPrice) {
		this.totalPrice = totalPrice;
	}

	public String getOrderCreatedTime() {
		return orderCreatedTime;
	}

	public void setOrderCreatedTime(String orderCreatedTime) {
		this.orderCreatedTime = orderCreatedTime;
	}

	public String getOrderDeliveryTime() {
		return orderDeliveryTime;
	}

	public void setOrderDeliveryTime(String orderDeliveryTime) {
		this.orderDeliveryTime = orderDeliveryTime;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public long getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(long contactNumber) {
		this.contactNumber = contactNumber;
	}

	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		return "FoodOrder [id=" + id + ", status=" + status + ", totalPrice=" + totalPrice + ", orderCreatedTime="
				+ orderCreatedTime + ", orderDeliveryTime=" + orderDeliveryTime + ", customerName=" + customerName
				+ ", contactNumber=" + contactNumber + ", item=" + item + ", user=" + user + "]";
	}

	public void setId(int id) {
		this.id = id;
	}

	
}
