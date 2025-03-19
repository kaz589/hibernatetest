package com.controller.Admin;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.model.Admin;

import com.service.AdminService;
import com.util.HibernateUtil;


@WebServlet("/NewAdmin")
public class NewAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public NewAdmin() {
        super();
    }

    
Connection conn;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String full_name = request.getParameter("full_name");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		String phone_number = request.getParameter("phone_number");
		
		
		//處理日期類型
		String registration_date_str = request.getParameter("registration_date");
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date parsedDate = null;
		try {
			parsedDate = dateFormat.parse(registration_date_str);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		java.sql.Date registration_date = new java.sql.Date(parsedDate.getTime());
		
		
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.getCurrentSession();
		AdminService adminService = new AdminService(session);
		
		Admin adminBean = new Admin(full_name,username,password,email,phone_number,registration_date);
		adminService.insert(adminBean);
		

		request.setAttribute("admin", adminBean);
		request.getRequestDispatcher("/admin/NewAdmin.jsp").forward(request, response);
		}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}


