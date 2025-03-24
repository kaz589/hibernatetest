package com.controller.Admin;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.model.ProductsBean;
import com.service.ProductsService;
import com.util.HibernateUtil;



@WebServlet("/GetAllProducts")
public class GetAllProducts extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public GetAllProducts() {
        super();
    }

    

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			SessionFactory factory = HibernateUtil.getSessionFactory();
			Session session = factory.getCurrentSession();

			ProductsService pService = new ProductsService(session);
			List<ProductsBean> products =pService.selectAll();
			request.setAttribute("products", products);

			request.getRequestDispatcher("/Products/GetAllProducts.jsp").forward(request, response);
			
			if (products != null) {
				//跳轉到成功頁面
					request.getRequestDispatcher("/Products/GetAllProducts.jsp").forward(request, response);

				} else {
					// 跳轉到失敗頁面
					request.getRequestDispatcher("/Products/Fail.jsp").forward(request, response);

				}
		} catch (HibernateException | ServletException | IOException e) {
			e.printStackTrace();
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
