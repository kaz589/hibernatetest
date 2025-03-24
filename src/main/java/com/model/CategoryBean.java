package com.model;

import java.util.LinkedList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Category")
public class CategoryBean {
	@Id
	@Column(name = "category_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer category_id;

	@Column(name = "category_name")
	private String category_name;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "category", cascade = CascadeType.ALL)
	private List<ProductsBean> Products = new LinkedList<ProductsBean>();

	

	public CategoryBean() {
	}
	
	

	public CategoryBean( String category_name) {
	
		this.category_name = category_name;
	}



	public Integer getCategory_id() {
		return category_id;
	}

	public void setCategory_id(Integer category_id) {
		this.category_id = category_id;
	}

	public String getCategory_name() {
		return category_name;
	}

	public void setCategory_name(String category_name) {
		this.category_name = category_name;
	}

	public List<ProductsBean> getProducts() {
		return Products;
	}

	public void setProducts(List<ProductsBean> products) {
		Products = products;
	}
	
	
	
	
	
	
//	@OneToMany
//	private ProductsBean productsBean;
}
