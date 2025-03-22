package com.repository;

import java.sql.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

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
	
	public String getPassword(String username) {
		String hql = "Select password From Admin WHERE username=:username";
		Query<String> query = session.createQuery(hql); 
		query.setParameter("username", username);
		String password_search= query.uniqueResult();
		return password_search;
	}
	
	
	
}
