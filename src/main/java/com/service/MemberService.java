package com.service;

import java.sql.Date;
import java.util.List;

import org.hibernate.Session;

import com.model.House;
import com.model.Member;
import com.repository.MemberDao;

public class MemberService {
	
	private MemberDao memberDao;
	
	public  MemberService(Session session) {
		this.memberDao = new MemberDao(session);
	}
	
	
	public Member getOne(Integer id) {
		return memberDao.getOne(id);
	}
	
	
	public List<Member> getAll() {
		List<Member> a = memberDao.getAll();
		System.out.println(a);
		return a;
	}
	
	public Member insert(Member member) {
		 return memberDao.insert(member);
	}
	
	public boolean delete(Integer member_id) {
		return memberDao.delete(member_id);
	}
	
	public Member update(int member_id,String full_name,String username,String password,String email,int total_miles,String phone_number,Date registration_date,Boolean email_verified,Boolean phone_verified,String membership_level) {
		return memberDao.update(member_id, full_name, username, password, email, total_miles, phone_number, registration_date, email_verified, phone_verified, membership_level);
	}
	
	public List<Member> getFuzzy(String fuzzyName) {
		return memberDao.getFuzzy(fuzzyName);
	}
	

}
