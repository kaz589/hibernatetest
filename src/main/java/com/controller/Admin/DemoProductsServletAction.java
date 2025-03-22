package com.controller.Admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.ClosedWatchServiceException;

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

@WebServlet("/DemoProductsAction")
public class DemoProductsServletAction extends HttpServlet{
private static final long  serialVersionUID = 1L;

public DemoProductsServletAction() {
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
	

	ProductsService pService = new ProductsService(session);
	pService.insert(new ProductsBean(1,"紅酒",9000,20));
	

	ProductsBean resultBean = pService.selectById(1); 
	if(resultBean!=null) {
		out.write(resultBean.getProduct_id() + " " + resultBean.getProduct_name() + "<br/>");
	}else {
		out.write("no result<br/>");
	}
	
	out.close();
}

}