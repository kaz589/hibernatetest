package com.service;

import java.util.List;

import org.hibernate.Session;

import com.model.House;

public interface IHouseService {
	
	public House insert(House insertBean) ;
	public House selectById(Integer id);
	public List<House> selectAll();
	public House update(Integer id, String housename);
	public boolean deleteById(Integer id);
}
