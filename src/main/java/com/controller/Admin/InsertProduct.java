package com.controller.Admin;

import java.io.IOException;
import java.io.PrintWriter;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.model.ProductsBean;
import com.util.HibernateUtil;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import com.service.ProductsService;

@WebServlet("/InsertProduct")
public class InsertProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public InsertProduct() {
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();

		try {
			
			SessionFactory factory = HibernateUtil.getSessionFactory();
			Session session = factory.getCurrentSession();
			// 從 HTML 獲取數據
			int category_id = Integer.parseInt(request.getParameter("category_id"));
			String product_name = request.getParameter("product_name");
			String product_desc = request.getParameter("product_desc");
			int needmiles = Integer.parseInt(request.getParameter("needmiles"));
			int quantity = Integer.parseInt(request.getParameter("quantity"));
			String product_image = request.getParameter("product_image");

			// 存進Bean
			ProductsBean product = new ProductsBean();
			product.setCategory_id(category_id);
			product.setProduct_name(product_name);
			product.setProduct_desc(product_desc);
			product.setNeedmiles(needmiles);
			product.setQuantity(quantity);
			product.setProduct_image(product_image);

			ProductsService pService = new ProductsService(session);
			ProductsBean resultBean = pService.insert(new ProductsBean(1, "紅酒", 9000, 20));

			if (resultBean != null) {
				response.sendRedirect("GetAllProducts");
			} else {
				request.getRequestDispatcher("/Products/Fail.jsp").forward(request, response);
			}
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}

		out.close();
	}
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}