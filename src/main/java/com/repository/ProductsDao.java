package com.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.model.ProductsBean;

public class ProductsDao implements IProductsDao {

	private Session session;

	

	 public ProductsDao(Session session) {
	        if (session == null) {
	            throw new IllegalArgumentException("Session cannot be null");
	        }
	        this.session = session;
	    }

	@Override
	public ProductsBean insert(ProductsBean insertBean) {
		if (insertBean != null) {
			session.persist(insertBean);
			return insertBean;
		}

		return null;
	}

	@Override
	public ProductsBean selectById(Integer product_id) {
		return session.get(ProductsBean.class, product_id);

	}

	@Override
	public List<ProductsBean> selectAll() {
		Query<ProductsBean> query = session.createQuery("from ProductsBean", ProductsBean.class);
		return query.list();
	}

	@Override
	public ProductsBean update(Integer product_id, String product_name) {
		ProductsBean resultBean = session.get(ProductsBean.class, product_id);
		if (resultBean != null) {
			resultBean.setProduct_name(product_name);
		}
		return resultBean;
	}

	@Override
	public boolean deleteById(Integer product_id) {
		ProductsBean deleteBean = session.get(ProductsBean.class, product_id);
		if (deleteBean != null) {
			session.remove(deleteBean);
			return true;
		}
		return false;
	}

}
