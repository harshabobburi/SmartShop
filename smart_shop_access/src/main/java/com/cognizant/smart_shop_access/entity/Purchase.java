package com.cognizant.smart_shop_access.entity;

import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="purchase")
public class Purchase {

	@Id
	@Column(name="pu_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne
	@JoinColumn(name="pu_us_id")
	private User user;
	
	@Column(name="pu_total_amount")
	private int total_amount;
	
	@Column(name="pu_reward_points")
	private int reward_points;
	
	@Column(name="pu_date")
	private Date date;
	
	@OneToMany(mappedBy="purchase")
	private List<PurchaseDetails> purchaseDetailsList;

	public Purchase(User user, int total_amount, int reward_points, Date date) {
		this.user = user;
		this.total_amount = total_amount;
		this.reward_points = reward_points;
		this.date = date;
	}

	public List<PurchaseDetails> getPurchaseDetailsList() {
		return purchaseDetailsList;
	}

	public void setPurchaseDetailsList(List<PurchaseDetails> purchaseDetailsList) {
		this.purchaseDetailsList = purchaseDetailsList;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public int getTotal_amount() {
		return total_amount;
	}

	public void setTotal_amount(int total_amount) {
		this.total_amount = total_amount;
	}

	public int getReward_points() {
		return reward_points;
	}

	public void setReward_points(int reward_points) {
		this.reward_points = reward_points;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Purchase() {
	}

	@Override
	public String toString() {
		return "Purchase [id=" + id + ", user=" + user + ", total_amount=" + total_amount + ", reward_points="
				+ reward_points + ", date=" + date + ", purchaseDetails=" + purchaseDetailsList + "]";
	}
}
