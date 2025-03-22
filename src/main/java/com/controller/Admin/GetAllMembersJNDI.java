package com.controller.Admin;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.model.Member;

import com.repository.MemberDao;
import com.service.MemberService;
import com.util.HibernateUtil;



@WebServlet("/GetAllMembersJNDI")
public class GetAllMembersJNDI extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public GetAllMembersJNDI() {
        super();
    }

    
Connection conn;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.getCurrentSession();
		
		MemberService memberService = new MemberService(session);
		List<Member> member_ans = memberService.getAll();
		
						
		request.setAttribute("members", member_ans);

		request.getRequestDispatcher("/admin/GetAllMembers.jsp").forward(request, response);
		}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
