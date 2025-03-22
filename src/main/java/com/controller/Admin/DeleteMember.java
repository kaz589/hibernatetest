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


@WebServlet("/DeleteMember")
public class DeleteMember extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DeleteMember() {
        super();
    }

    

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer member_id = Integer.parseInt(request.getParameter("member_id")) ;
		
		
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.getCurrentSession();
		MemberService memberService = new MemberService(session);
		
		
		
		
		boolean delete_ans = memberService.delete(member_id);




		if (delete_ans == false) {
		    // 查無此會員
			request.getRequestDispatcher("/admin/deleteNone.jsp").forward(request, response);
		    
		} else {
		    // 成功刪除會員

		    request.getRequestDispatcher("/admin/delete.jsp").forward(request, response);
		    
		}
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
