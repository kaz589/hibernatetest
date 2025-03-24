package com.controller.Admin;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.model.ProductsBean;
import com.service.ProductsService;
import com.util.HibernateUtil;


@WebServlet("/GetByName")
public class GetByName extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public GetByName() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			SessionFactory factory = HibernateUtil.getSessionFactory();
			Session session = factory.getCurrentSession();
			
			String product_name = request.getParameter("product_name");

			ProductsService productsService = new ProductsService(session);
			List<ProductsBean> products = productsService.getByname(product_name);
			request.setAttribute("products", products);
			request.getRequestDispatcher("/Products/GetAllProducts.jsp").forward(request, response);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
