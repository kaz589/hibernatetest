package com.controller.Admin;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import com.model.House;
import com.service.HouseService;
import com.util.HibernateUtil;

import java.io.IOException;
import java.io.PrintWriter;

import org.hibernate.Session;
import org.hibernate.SessionFactory;


@WebServlet("/DemoHouseServletAction.do")
public class DemoHouseServletAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public DemoHouseServletAction() {
        
       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		processAction(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		processAction(request, response);
	}
	
	private void processAction(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.getCurrentSession();
		
		HouseService hService = new HouseService(session);
		hService.insert(new House("123"));
		
		House resultBean = hService.selectById(1000);
		
		if(resultBean!=null) {
			out.write(resultBean.getHouseid() + " " + resultBean.getHousename() + "<br/>");
		}else {
			out.write("no result<br/>");
		}
		
		out.close();
	}

}
