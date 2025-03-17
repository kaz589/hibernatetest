package com.controller.Admin;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import com.model.Admin;
import com.model.House;
import com.service.AdminService;
import com.service.HouseService;
import com.util.HibernateUtil;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.hibernate.Session;
import org.hibernate.SessionFactory;


@WebServlet("/DemoAdminServletAction")
public class DemoAdminServletAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public DemoAdminServletAction() {
        
       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		processAction(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		processAction(request, response);
	}
	
	private void processAction(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setContentType("text/html;charset=UTF-8");
		
		
		String full_name = request.getParameter("full_name");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		String phone_number = request.getParameter("phone_number");
		
				
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.getCurrentSession();
		
		AdminService adminService = new AdminService(session);
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		
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
		
		
		
		Admin adminBean;
		

			
			//放資料進入adminBean
			adminBean = new Admin(full_name,username,password,email,phone_number,registration_date);
			//放資料進資料庫
			/*Admin resultBean = */adminService.insert(adminBean);
			System.out.println("新增成功");
		
		 
		
		
	}

}
