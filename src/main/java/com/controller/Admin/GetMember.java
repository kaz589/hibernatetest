	package com.controller.Admin;
	
	import jakarta.servlet.ServletException;
	import jakarta.servlet.annotation.WebServlet;
	import jakarta.servlet.http.HttpServlet;
	import jakarta.servlet.http.HttpServletRequest;
	import jakarta.servlet.http.HttpServletResponse;
	import java.io.IOException;
	import java.sql.Connection;
	import java.sql.PreparedStatement;
	import java.sql.ResultSet;
	import javax.naming.Context;
	import javax.naming.InitialContext;
	import javax.sql.DataSource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.model.Member;
	import com.repository.MemberDao;
import com.service.MemberService;
import com.util.HibernateUtil;
	
	
	@WebServlet("/GetMember")
	public class GetMember extends HttpServlet {
		private static final long serialVersionUID = 1L;
	       
	    public GetMember() {
	        super();
	    }
	
	    
	//Connection conn;
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			Integer member_id = Integer.parseInt(request.getParameter("member_id"));
	//		System.out.println(member_id);
			
			SessionFactory factory = HibernateUtil.getSessionFactory();
			Session session = factory.getCurrentSession();
			
			MemberService member = new MemberService(session);
			Member member_ans = member.getOne(member_id);
			request.setAttribute("member", member_ans);
			
			request.getRequestDispatcher("/admin/GetMember.jsp").forward(request, response);
		}
	
	
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			doGet(request, response);
		}
	
	}
