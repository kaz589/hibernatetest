package com.repository;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.model.Airports;
import com.model.House;
import com.util.HibernateUtil;

import jakarta.transaction.Transaction;

public class AirportsDao {
	private	Session session;
	public AirportsDao(Session session) {
		this.session=session;
	}
	
	
	
	// 新增機場
    public void insertAirport(Airports airport) {
    	if(airport !=null) {
			session.persist(airport);
		}
		
    }
    //搜尋機場
  	public ArrayList<Airports> searchAirports(String keyword, String city, String countryRegion)  {
  		 
  		ArrayList<Airports> airportsList = new ArrayList<>();
  		 // 動態構建 HQL 查詢
        StringBuilder hql = new StringBuilder("FROM AirportsBean WHERE 1=1");
        List<Object> parameters = new ArrayList<>();

        if (keyword != null && !keyword.trim().isEmpty()) {
            hql.append(" AND (airportName LIKE :keyword OR iataCode LIKE :keyword)");
            parameters.add("%" + keyword + "%");
        }
        if (city != null && !city.trim().isEmpty() && !city.equals("全部")) {
            hql.append(" AND city = :city");
            parameters.add(city);
        }
        if (countryRegion != null && !countryRegion.trim().isEmpty()) {
            hql.append(" AND countryRegion LIKE :countryRegion");
            parameters.add("%" + countryRegion + "%");
        }

        // 創建 Query 並設置參數
        Query<Airports> query = session.createQuery(hql.toString(), Airports.class);

        int paramIndex = 0;
        if (keyword != null && !keyword.trim().isEmpty()) {
            query.setParameter("keyword", parameters.get(paramIndex++));
        }
        if (city != null && !city.trim().isEmpty() && !city.equals("全部")) {
            query.setParameter("city", parameters.get(paramIndex++));
        }
        if (countryRegion != null && !countryRegion.trim().isEmpty()) {
            query.setParameter("countryRegion", parameters.get(paramIndex++));
        }

        // 執行查詢並獲取結果
        airportsList = (ArrayList<Airports>) query.list();
        return airportsList;
  	}
	//搜尋全部
  	public List<Airports> SELECTallinfo( ) {
		Query<Airports> query=session.createQuery("from Airports",Airports.class);
		
		
		return query.list();
		
	}
  	// 更新機場
    public void updateAirports(List<Airports> airports) {
        if (airports != null && !airports.isEmpty()) {
            for (Airports airport : airports) {
                session.merge(airport); // 使用 merge 更新
            }
        }
    }
    // 刪除機場
    public void deleteAirport(int airportId) {
        Airports airport = session.get(Airports.class, airportId);
        if (airport != null) {
            session.remove(airport);
        }
    }
}
