package com.service;

import java.util.List;

import org.hibernate.Session;

import com.model.House;
import com.repository.*;

public class HouseService implements IHouseService {
	private HouseDao houseDao;

	
	
	public  HouseService(Session session) {
		houseDao = new HouseDao(session);
	}
	@Override
	public House insert(House insertBean) {
		return houseDao.insert(insertBean);
	}
	@Override
	public House selectById(Integer id) {
		return houseDao.selectById(id);
	}
	@Override
	public List<House> selectAll() {
		return houseDao.selectAll();
	}
	@Override
	public House update(Integer id, String housename) {
		return houseDao.update(id, housename);
	}
	@Override
	public boolean deleteById(Integer id) {
		return houseDao.deleteById(id);
	}
	
	


}
