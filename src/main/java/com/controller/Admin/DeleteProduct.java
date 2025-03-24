package com.controller.Admin;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.service.ProductsService;
import com.util.HibernateUtil;

@WebServlet("/DeleteProduct")
public class DeleteProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public DeleteProduct() {
		
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			SessionFactory factory = HibernateUtil.getSessionFactory();
			Session session = factory.getCurrentSession();

		
				// 從 HTML 獲取數據
				int product_id =Integer.parseInt(request.getParameter("product_id")) ;
				
				//調用delete方法
				ProductsService pService = new ProductsService(session);
				boolean isSuccess =	pService.deleteById(product_id);
				
				
				 if (isSuccess) {
						//刪除成功後，導向 查看全部商品的 Servlet
					  response.sendRedirect("GetAllProducts");
			        } else {
			        	// 跳轉到結果頁面
						request.getRequestDispatcher("/Products/Fail.jsp").forward(request, response);
						
			        }
			} catch (Exception e) {
				e.printStackTrace();
			
					
			}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
