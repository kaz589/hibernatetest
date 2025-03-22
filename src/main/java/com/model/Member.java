package com.model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "member")
public class Member {
	
	@Id@Column(name = "member_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer member_id;
	
	@Column(name = "full_name")
	String full_name;
	
	@Column(name = "username")
	String username;
	
	@Column(name = "password")
	String password;
	
	@Column(name = "email")
	String email;
	
	@Column(name = "total_miles")
	Integer total_miles;
	
	@Column(name = "phone_number")
	String phone_number;
	
	@Column(name = "registration_date")
	Date registration_date;
	
	@Column(name = "email_verified")
	boolean email_verified;
	
	@Column(name = "phone_verified")
	boolean phone_verified;
	
	@Column(name = "membership_level")
	String membership_level;
	
		
	public Member() {
	}

	
	

	public Member(String full_name, String username, String password, String email, Integer total_miles,
			String phone_number, Date registration_date, boolean email_verified, boolean phone_verified,
			String membership_level) {
		super();
		this.full_name = full_name;
		this.username = username;
		this.password = password;
		this.email = email;
		this.total_miles = total_miles;
		this.phone_number = phone_number;
		this.registration_date = registration_date;
		this.email_verified = email_verified;
		this.phone_verified = phone_verified;
		this.membership_level = membership_level;
	}




	public Integer getMember_id() {
		return member_id;
	}


	public void setMember_id(Integer member_id) {
		this.member_id = member_id;
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


	public Integer getTotal_miles() {
		return total_miles;
	}


	public void setTotal_miles(Integer total_miles) {
		this.total_miles = total_miles;
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


	public boolean isEmail_verified() {
		return email_verified;
	}


	public void setEmail_verified(boolean email_verified) {
		this.email_verified = email_verified;
	}


	public boolean isPhone_verified() {
		return phone_verified;
	}


	public void setPhone_verified(boolean phone_verified) {
		this.phone_verified = phone_verified;
	}


	public String getMembership_level() {
		return membership_level;
	}


	public void setMembership_level(String membership_level) {
		this.membership_level = membership_level;
	}
	
	
	
}
