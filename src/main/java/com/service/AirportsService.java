package com.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import com.model.Airports;
import com.repository.AirportsDao;
import com.repository.HouseDao;

public class AirportsService {
	private AirportsDao airportsDao;

    // 建構子初始化 DAO
    public AirportsService(Session session) {
        this.airportsDao = new AirportsDao(session);
    }

    // 新增機場
    public void addAirport(Airports airport) {
        // 不捕捉異常，讓異常向上傳遞
        airportsDao.insertAirport(airport);
        System.out.println("機場新增成功！");
    }

    // 刪除機場
    public void removeAirport(int airportsId) {
        airportsDao.deleteAirport(airportsId);
        System.out.println("機場刪除成功！");
    }

    // 修改機場
    public void updateAirports(List<Airports> airports) {
        airportsDao.updateAirports(airports);
        System.out.println("機場更新成功！");
    }

    // 搜尋機場
    public ArrayList<Airports> searchAirports(String keyword, String city, String countryRegion)  {
        ArrayList<Airports> airportsList = airportsDao.searchAirports(keyword, city, countryRegion);
        System.out.println("搜尋機場成功，共找到 " + airportsList.size() + " 筆結果！");
        return airportsList;
    }

    // 搜尋全部機場
    public List<Airports> getAllAirports() {
        List<Airports> airportsList = airportsDao.SELECTallinfo();
        System.out.println("成功取得所有機場，共 " + airportsList.size() + " 筆資料！");
        return airportsList;
    }
}
