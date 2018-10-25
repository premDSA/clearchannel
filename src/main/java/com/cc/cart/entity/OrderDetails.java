package com.cc.cart.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class OrderDetails {
	


	public OrderDetails(int orderId, int itemId) {
		super();
		this.orderId = orderId;
		this.itemId = itemId;
	}
	
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int orderNumber;
	@Column
	private int orderId;
	@Column
	private int itemId;
	@Column(name="STATUS_DATE",columnDefinition = "Date default SYSDATE")
	private Date orderDate;
	public int getOrderNumber() {
		return orderNumber;
	}
	public void setOrderNumber(int orderNumber) {
		this.orderNumber = orderNumber;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	
}

