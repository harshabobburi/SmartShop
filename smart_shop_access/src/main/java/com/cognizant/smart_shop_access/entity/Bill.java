package com.cognizant.smart_shop_access.entity;

import java.util.List;

public class Bill {
	
	private List<Product> products;
	private List<Integer> quantities;
	private int totalAmount;
	private String contactNumber;
	
	
	public int getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(int totalAmount) {
		this.totalAmount = totalAmount;
	}
	public String getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
	public List<Product> getProducts() {
		return products;
	}
	public void setProducts(List<Product> products) {
		this.products = products;
	}
	public List<Integer> getQuantities() {
		return quantities;
	}
	public void setQuantities(List<Integer> quantities) {
		this.quantities = quantities;
	}
	public Bill(List<Product> products, List<Integer> quantities, int totalAmount, String contactNumber) {
		this.products = products;
		this.quantities = quantities;
		this.totalAmount = totalAmount;
		this.contactNumber = contactNumber;
	}
	public Bill() {
	}	
}
