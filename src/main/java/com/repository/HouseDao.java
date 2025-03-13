package com.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.model.House;



public class HouseDao implements IHouseDao{
	
	private	Session session;
	public HouseDao(Session session) {
		this.session=session;
	}
	@Override
	public House insert(House inseHouse )
	{
		if(inseHouse !=null) {
			session.persist(inseHouse);
			return inseHouse;
		}
		return null;
	}
	@Override
	public House selectById( Integer id) {
		return session.get(House.class, id);
		
	}
	@Override
	public List<House> selectAll( ) {
		Query<House> query=session.createQuery("from House",House.class);
		
		
		return query.list();
		
	}
	@Override
	public House update(Integer id,String housename) {
		House resultBean=session.get(House.class, id);
		
		if(resultBean!=null) {
			resultBean.setHousename(housename);
			
		}
		
		return resultBean;
		
	}
	@Override
	public boolean deleteById(Integer id) {
		House deleteBean =session.get(House.class, id);
		
		if(deleteBean!=null) {
			session.remove(deleteBean);
			return true;
		}
		
		return false;
	}
	
	
}
