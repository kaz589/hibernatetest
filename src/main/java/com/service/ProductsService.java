package com.service;

import java.util.List;

import org.hibernate.Session;

import com.model.ProductsBean;
import com.repository.ProductsDao;

public class ProductsService  {
	
	private ProductsDao productsDao;

	public ProductsService(Session session) {
		productsDao = new ProductsDao(session);
	}

	public ProductsBean insert(ProductsBean insertBean) {
		return productsDao.insert(insertBean);
	}
		

	public ProductsBean selectById(Integer product_id) {
		return productsDao.selectById(product_id);
	}

	public List<ProductsBean> selectAll() {
		return productsDao.selectAll();
	}

	public ProductsBean update(Integer product_id, String product_name) {
		return productsDao.update(product_id, product_name);
	}

	public boolean deleteById(Integer product_id) {
		return productsDao.deleteById(product_id);
	}

}
