package com.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.model.House;
import com.model.Member;

public class MemberDao {
	
	private static final String SQL_getOne = "SELECT * FROM member WHERE member_id = ?";
	
	private static final String SQL_getFuzzy = "SELECT * FROM member WHERE full_name LIKE ?";
	

	private static final String SQL_update = "UPDATE member SET full_name = ?, username = ?, password = ?,email = ?,total_miles = ?,phone_number = ?,registration_date = ?,email_verified = ?,phone_verified = ?,membership_level = ?  WHERE member_id = ?";
	
	private	Session session;
	public MemberDao(Session session) {
		this.session = session;
	}
	
Connection conn;	
	public Member getOne(Integer member_id) {
		
		return session.get(Member.class, member_id);
	}
	
	
	public List<Member> getFuzzy(String fuzzyName){

		String hql = "FROM Member WHERE full_name LIKE :fuzzyName";
		Query<Member> query = session.createQuery(hql, Member.class);
		query.setParameter("fuzzyName", "%" + fuzzyName + "%");
		return query.list();
	}
	
	
	
	
	
	
	public List<Member> getAll() {
		
		Query<Member> query = session.createQuery("from Member", Member.class);
		return query.list();
				
	}
	
	
	public Member insert(Member insertMember) {
		session.persist(insertMember);
		return insertMember;
	}
	
	
	
	public boolean delete(Integer member_id) {
	   Member member = session.get(Member.class, member_id);
	    if (member != null) {
			session.remove(member);
			return true;
		}
	    return false;
	    
	}
	
	public Member update(int member_id,String full_name,String username,String password,String email,int total_miles,String phone_number,Date registration_date,Boolean email_verified,Boolean phone_verified,String membership_level) {
		
		
		Member member = new Member();
		Member resultBean = session.get(Member.class, member_id);
		
		if(resultBean!=null) {
			
			member.setMember_id(member_id);
			member.setFull_name(full_name);
			member.setUsername(username);
			member.setPassword(password);
			member.setEmail(email);
			member.setTotal_miles(total_miles);
			member.setPhone_number(phone_number);
			member.setRegistration_date(registration_date);
			member.setEmail_verified(email_verified);
			member.setPhone_verified(phone_verified);
			member.setMembership_level(membership_level);
			
			if (member != null) {
		        // 如果實體是脫離狀態的，使用 merge() 代替 update()
		        session.merge(member);
		    } else {
		        session.saveOrUpdate(member);
		    }
		}
			return member;
			
			
		
	}
	

	
	

}
