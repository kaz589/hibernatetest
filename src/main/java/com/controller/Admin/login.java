package com.controller.Admin;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.repository.AdminDao;
import com.util.HibernateUtil;


@WebServlet("/login")
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public login() {
        super();

    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session_Hibernate = factory.getCurrentSession();
		System.out.println("Authentication filter triggered");
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		AdminDao admin = new AdminDao(session_Hibernate);
		String password_search = admin.getPassword(username);
		System.out.println("搜尋到的:"+password_search);
			
		if (password_search == null) {
		    // 帳號不存在，直接跳轉到錯誤頁面
		    System.out.println("查無此帳號");
		    HttpServletResponse httpResponse = (HttpServletResponse) response;
		    httpResponse.sendRedirect("topic2/errorPage.jsp?error=username not found");
		    return;  // 這裡應該結束執行，避免繼續執行後面的邏輯
		} 

		// 如果帳號存在，檢查密碼
		if (password.equals(password_search)) {
//		    System.out.println("密碼正確");
			HttpServletRequest httpRequest = (HttpServletRequest) request;
			HttpSession session = httpRequest.getSession();        //密碼正確的話  給session
			session.setAttribute("username", username);
			
			
		    
		} else {
		    System.out.println("密碼錯誤");
		    HttpServletResponse httpResponse_password = (HttpServletResponse) response;
		    httpResponse_password.sendRedirect("admin/errorPage.jsp?error=Incorrect password");  // 密碼錯誤，跳轉錯誤頁面
		}
		
		

		
		request.getRequestDispatcher("/admin/TotalHomePage.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
