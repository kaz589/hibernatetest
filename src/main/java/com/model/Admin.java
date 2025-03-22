package com.model;


import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "admin")
public class Admin {
	
	@Id @Column(name = "admin_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer admin_id;
	
	@Column(name = "full_name")
	String full_name;
	
	@Column(name = "username")
	String username;
	
	@Column(name = "password")
	String password;
	
	@Column(name = "email")
	String email;
	
	@Column(name = "phone_number")
	String phone_number;
	
	@Column(name = "registration_date")
	Date registration_date;

	public Admin() {
		super();
	}
	
	

	public Admin(String full_name, String username, String password, String email, String phone_number,
			Date registration_date) {
		super();
		this.full_name = full_name;
		this.username = username;
		this.password = password;
		this.email = email;
		this.phone_number = phone_number;
		this.registration_date = registration_date;
	}



	public Integer getAdmin_id() {
		return admin_id;
	}

	public void setAdmin_id(Integer admin_id) {
		this.admin_id = admin_id;
	}

	public String getFull_name() {
		return full_name;
	}

	public void setFull_name(String full_name) {
		this.full_name = full_name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone_number() {
		return phone_number;
	}

	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}

	public Date getRegistration_date() {
		return registration_date;
	}

	public void setRegistration_date(Date registration_date) {
		this.registration_date = registration_date;
	}




}
