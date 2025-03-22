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
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.model.Member;
import com.repository.MemberDao;
import com.service.MemberService;
import com.util.HibernateUtil;


@WebServlet("/InsertMember")
public class InsertMember extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public InsertMember() {
        super();
    }

    
Connection conn;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		int member_id = Integer.parseInt(request.getParameter("member_id")) ;
		String full_name = request.getParameter("full_name");
		String username = request.getParameter("username");
		
		
		String password = request.getParameter("password");
		
		String password_Hashing = PasswordHashing.hashPassword(password);
//		System.out.println(password_Hashing);
		
		
		String email = request.getParameter("email");
		int total_miles = Integer.parseInt(request.getParameter("total_miles"));
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
		
		
		boolean email_verified = request.getParameter("email_verified") != null;
		boolean phone_verified = request.getParameter("phone_verified")  != null;
		String membership_level = request.getParameter("membership_level");
		
		
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.getCurrentSession();
		
		
		//呼叫service
		MemberService member_service = new MemberService(session);
		
		Member member_ans = new Member(full_name,username,password_Hashing,email,total_miles,phone_number,registration_date,email_verified,phone_verified,membership_level);
		
		//給值
		member_service.insert(member_ans);
		
		
		request.setAttribute("member", member_ans);
		request.getRequestDispatcher("/admin/InsertMember.jsp").forward(request, response);
		}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
