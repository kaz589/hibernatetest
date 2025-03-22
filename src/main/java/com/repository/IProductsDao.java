package com.repository;

import java.util.List;

import com.model.ProductsBean;

//把想做的方法都寫在這裡，再用java class實作此介面
public interface IProductsDao {
	public ProductsBean insert(ProductsBean insertBean);
	public ProductsBean selectById(Integer product_id);
	public List<ProductsBean> selectAll();
	public ProductsBean update(Integer product_id, String product_name);
	public boolean deleteById(Integer product_id);
}