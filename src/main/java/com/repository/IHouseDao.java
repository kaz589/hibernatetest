package com.repository;

import java.util.List;

import com.model.House;

public interface IHouseDao {

	public House insert(House insertBean);
	public House selectById(Integer id);
	public List<House> selectAll();
	public House update(Integer id, String housename);
	public boolean deleteById(Integer id);
}
