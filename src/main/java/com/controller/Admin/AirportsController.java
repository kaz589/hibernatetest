package com.controller.Admin;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.model.Airports;
import com.model.House;
import com.repository.AirportsDao;
import com.service.AirportsService;
import com.util.HibernateUtil;


@WebServlet("/airports")
public class AirportsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	Map<String, Object> jsonResponse = new HashMap<>();
	boolean status = true;
   
    public AirportsController() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		processAction(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		processAction(request, response);
	}
	
	
	private void processAction(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		
		
		
		jsonResponse.clear();
		// 使用自定義函式解析 JSON 數據
		Map<String, String> params = parseJsonRequest(request);

		
		
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.getCurrentSession();
		// 獲取操作類型
		String action = params.get("action");
		
		AirportsService aService=new AirportsService(session);
		ArrayList<Airports> AirportsList = null;
		
		try {
			//取的所有機場
			if (action.equalsIgnoreCase("getall")) {
				AirportsList = (ArrayList<Airports>) aService.getAllAirports();
				jsonResponse.put("result", AirportsList);

			} else if (action.equalsIgnoreCase("search")) {

				String city=params.get("city");
				String country=params.get("country");
				String keyword=params.get("keyword");
				
				AirportsList=aService.searchAirports(keyword,city,country);
				jsonResponse.put("result", AirportsList);
			
			  //更新機場資料
			} else if (action.equalsIgnoreCase("update")) {
			
			Airports newAirport = new Airports();
	        ArrayList<Airports> updateAirports = new ArrayList<>();
	        newAirport.setAirportsId(Integer.parseInt(params.get("AirportsId")));
	        newAirport.setIataCode(params.get("IataCode"));
	        newAirport.setAirportName(params.get("AirportName"));
	        newAirport.setCity(params.get("City"));
	        newAirport.setCountryRegion(params.get("CountryRegion"));
	        updateAirports.add(newAirport);
	        aService.updateAirports(updateAirports);
			 //新增機場資料
		} else if (action.equalsIgnoreCase("insert")) {
			
			Airports newAirport = new Airports();
	      
	      
	        newAirport.setIataCode(params.get("IataCode"));
	        newAirport.setAirportName(params.get("AirportName"));
	        newAirport.setCity(params.get("City"));
	        newAirport.setCountryRegion(params.get("CountryRegion"));
	        
	        aService.addAirport(newAirport);
		  //刪除機場資料
		} else if (action.equalsIgnoreCase("delete")) {

			int delectid = Integer.parseInt(params.get("airportsId"));
			aService.removeAirport(delectid);

		}
		
		} catch (Exception e) {
			e.printStackTrace();
			response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR); // 設置 HTTP 錯誤狀態碼

			return;
		}
		
		jsonResponse.put("status", status);
		// 使用 Gson 將列表轉換為 JSON
		Gson gson = new Gson();
		String json = gson.toJson(jsonResponse);

		// 設置回應類型為 JSON
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write(json); // 寫入 JSON 到回應
		
	}
	
	//從 HttpServletRequest 中讀取 JSON 數據並解析為 Map
		public static Map<String, String> parseJsonRequest(HttpServletRequest request) throws IOException {

			// 讀取請求體中的 JSON 數據
			StringBuilder jsonBuilder = new StringBuilder();
			String line;
			BufferedReader reader = request.getReader();
			while ((line = reader.readLine()) != null) {
				jsonBuilder.append(line);
			}

			String jsonString = jsonBuilder.toString();

			// 使用 Gson 解析 JSON 數據
			Gson gson = new Gson();
			return gson.fromJson(jsonString, new TypeToken<Map<String, String>>() {
			}.getType());
		}

}
