package com.controller.Admin;

import java.io.IOException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.model.ProductsBean;
import com.service.ProductsService;
import com.util.HibernateUtil;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/GetUpdate")
public class GetUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		

		try {
			SessionFactory factory = HibernateUtil.getSessionFactory();
			Session session = factory.getCurrentSession();
			
			// 從 HTML 獲取數據
			int product_id =Integer.parseInt(request.getParameter("product_id")) ; 
			ProductsBean product  = new ProductsBean();
			
			ProductsService productsService = new ProductsService(session);
			product=productsService.selectById(product_id);
		        
			request.setAttribute("product", product);
			request.getRequestDispatcher("/Products/GetUpdate.jsp").forward(request, response);
				
		     
		} catch (Exception e) {
			e.printStackTrace();
		
				
				}
			}
		
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}