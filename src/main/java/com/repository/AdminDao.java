package com.repository;

import java.sql.Date;

import org.hibernate.Session;

import com.model.Admin;

public class AdminDao {
	
	private Session session;
	
	public AdminDao(Session session) {
		 this.session = session;
	}

	
	//新增admin
	public Admin insert(Admin insertAdmin) {
		session.persist(insertAdmin);
		return insertAdmin;
	}
	
	
}
