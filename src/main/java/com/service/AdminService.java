package com.service;

import org.hibernate.Session;

import com.model.Admin;
import com.repository.AdminDao;

public class AdminService {
	
	private AdminDao adminDao;
	
	public AdminService(Session session) {
		adminDao = new AdminDao(session);
	}
	
	public Admin insert(Admin adminBean) {
		return adminDao.insert(adminBean);
	}
	
	

}
