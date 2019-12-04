package com.cognizant.smart_shop_access.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="purchase_details")
public class PurchaseDetails {
	
	@Id
	@Column(name="pd_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="pd_pr_code")
	private String product;
	
	@ManyToOne
	@JoinColumn(name="pd_pu_id")
	private Purchase purchase;
	
	@Column(name="pd_quantity")
	private int quantity;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	public PurchaseDetails() {
	}

	@Override
	public String toString() {
		return "PurchaseDetails [id=" + id + ", product=" + product + ", purchase=" + purchase + ", quantity="
				+ quantity + "]";
	}

	public PurchaseDetails(String product, Purchase purchase, int quantity) {
		this.product = product;
		this.purchase = purchase;
		this.quantity = quantity;
	}
	
}