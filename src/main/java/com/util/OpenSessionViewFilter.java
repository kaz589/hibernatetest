package com.util;

import java.io.IOException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import jakarta.annotation.Priority;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebFilter(urlPatterns = "/*",filterName = "B")
public class OpenSessionViewFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.getCurrentSession();
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		HttpSession web_Session = httpRequest.getSession();
		
		try {
			
			
			String requestURI = httpRequest.getRequestURI();
			
			
			String username = (String) web_Session.getAttribute("username");
			String URLPATTEN= httpRequest.getContextPath() + "/admin/login.html";
			String servletlogin="/FlightTicketingSystem/login";
			String htmlInsert = "/FlightTicketingSystem/admin/NewAdmin.html";
			String servletInsert="/FlightTicketingSystem/NewAdmin";
			String jspInsert = "/FlightTicketingSystem/admin/NewAdmin.jsp";
			
			// 如果當前請求不是登錄頁面，並且用戶沒有登錄，則重定向到登錄頁
            if (!requestURI.equals(URLPATTEN) && 
            	!requestURI.equals(servletlogin) && 
            	!requestURI.equals(htmlInsert) && 
            	!requestURI.equals(servletInsert)&&
            	!requestURI.equals(jspInsert)&&
            	username == null) {
                httpResponse.sendRedirect(httpRequest.getContextPath() + "/admin/login.html");
                return; // 終止後續過濾器處理，避免繼續執行
            }
			session.beginTransaction();
			
			
			System.out.println("Transaction Begin");
			
			chain.doFilter(request, response);
			
			session.getTransaction().commit();
			System.out.println("Transaction Commit");			
		}catch(Exception e) {
			session.getTransaction().rollback();
			System.out.println("Transaction Rollback");	
			e.printStackTrace();
		}finally {
			System.out.println("Session Closed");	
		}		
		

	}

}
