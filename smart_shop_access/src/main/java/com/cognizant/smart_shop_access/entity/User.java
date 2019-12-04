package com.cognizant.smart_shop_access.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="user")
public class User {

	@Id
	@Column(name="us_id")
	private String id;
	@Column(name="us_firstname")
	private String firstname;
	@Column(name="us_lastname")
	private String lastname;
	@Column(name="us_age")
	private int age;
	@Column(name="us_gender")
	private String gender;
	@Column(name="us_contactnumber")
	private String contactnumber;
	@Column(name="us_password")
	private String password;
	@Column(name="us_type")
	private String type;
	@Column(name="us_status")
	private String status;
	@Column(name="us_secret_question_1")
	private String secret_question_1;
	@Column(name="us_secret_question_2")
	private String secret_question_2;
	@Column(name="us_secret_question_3")
	private String secret_question_3;
	@Column(name="us_secret_answer_1")
	private String secret_answer_1;
	@Column(name="us_secret_answer_2")
	private String secret_answer_2;
	@Column(name="us_secret_answer_3")
	private String secret_answer_3;
	@OneToMany(mappedBy="user")
	private Set<Purchase> purchase;
	public User() {}
	public User(String id, String firstname, String lastname, int age, String gender, String contactnumber,
			String password, String type, String status, String secret_question_1, String secret_question_2,
			String secret_question_3, String secret_answer_1, String secret_answer_2, String secret_answer_3) {
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.age = age;
		this.gender = gender;
		this.contactnumber = contactnumber;
		this.password = password;
		this.type = type;
		this.status = status;
		this.secret_question_1 = secret_question_1;
		this.secret_question_2 = secret_question_2;
		this.secret_question_3 = secret_question_3;
		this.secret_answer_1 = secret_answer_1;
		this.secret_answer_2 = secret_answer_2;
		this.secret_answer_3 = secret_answer_3;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getContactnumber() {
		return contactnumber;
	}
	public void setContactnumber(String contactnumber) {
		this.contactnumber = contactnumber;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getSecret_question_1() {
		return secret_question_1;
	}
	public void setSecret_question_1(String secret_question_1) {
		this.secret_question_1 = secret_question_1;
	}
	public String getSecret_question_2() {
		return secret_question_2;
	}
	public void setSecret_question_2(String secret_question_2) {
		this.secret_question_2 = secret_question_2;
	}
	public String getSecret_question_3() {
		return secret_question_3;
	}
	public void setSecret_question_3(String secret_question_3) {
		this.secret_question_3 = secret_question_3;
	}
	public String getSecret_answer_1() {
		return secret_answer_1;
	}
	public void setSecret_answer_1(String secret_answer_1) {
		this.secret_answer_1 = secret_answer_1;
	}
	public String getSecret_answer_2() {
		return secret_answer_2;
	}
	public void setSecret_answer_2(String secret_answer_2) {
		this.secret_answer_2 = secret_answer_2;
	}
	public String getSecret_answer_3() {
		return secret_answer_3;
	}
	public void setSecret_answer_3(String secret_answer_3) {
		this.secret_answer_3 = secret_answer_3;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", age=" + age + ", gender="
				+ gender + ", contactnumber=" + contactnumber + ", password=" + password + ", type=" + type
				+ ", status=" + status + ", secret_question_1=" + secret_question_1 + ", secret_question_2="
				+ secret_question_2 + ", secret_question_3=" + secret_question_3 + ", secret_answer_1="
				+ secret_answer_1 + ", secret_answer_2=" + secret_answer_2 + ", secret_answer_3=" + secret_answer_3
				+ "]";
	}
}
