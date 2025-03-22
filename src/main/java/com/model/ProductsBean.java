package com.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Products")
public class ProductsBean {

	// 物件屬性
	@Id
	@Column(name = "product_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer product_id;

	@Column(name = "category_id", insertable = false, updatable = false)
	private Integer category_id;

	@Column(name = "product_name")
	private String product_name;

	@Column(name = "product_desc")
	private String product_desc;

	@Column(name = "needmiles")
	private Integer needmiles;

	@Column(name = "quantity")
	private Integer quantity;

	@Column(name = "product_image")
	private String product_image;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "category_id", referencedColumnName = "category_id")
	private CategoryBean category;

	public CategoryBean getCategoryBean() {
		return category;
	}

	// 有參數建構子

	public ProductsBean(Integer category_id, String product_name, Integer needmiles, Integer quantity) {
		this.category_id = category_id;
		this.product_name = product_name;
		this.needmiles = needmiles;
		this.quantity = quantity;
	}

	// 無參數建構子
	public ProductsBean() {

	}

//getter setter
	public Integer getProduct_id() {
		return product_id;
	}

	public void setProduct_id(Integer product_id) {
		this.product_id = product_id;
	}

	public Integer getCategory_id() {
		return category_id;
	}

	public void setCategory_id(Integer category_id) {
		this.category_id = category_id;
	}

	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	public String getProduct_desc() {
		return product_desc;
	}

	public void setProduct_desc(String product_desc) {
		this.product_desc = product_desc;
	}

	public Integer getNeedmiles() {
		return needmiles;
	}

	public void setNeedmiles(Integer needmiles) {
		this.needmiles = needmiles;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public String getProduct_image() {
		return product_image;
	}

	public void setProduct_image(String product_image) {
		this.product_image = product_image;
	}

	public CategoryBean getCategory() {
		return category;
	}

	public void setCategory(CategoryBean category) {
		this.category = category;
	}

}
