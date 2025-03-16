package com.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Airports")
public class Airports {
	
	@Id@Column(name = "AirportsId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int AirportsId; // 機場 ID
	@Column(name = "IataCode")
	private String IataCode; // 機場代碼
	@Column(name = "AirportName")
    private String AirportName; // 機場名稱
	@Column(name = "CountryRegion")
    private String CountryRegion; // 機場位置
	@Column(name = "City")
    private String City; // 機場位置
	
	public Airports() {
		super();
	}
	    
	public int getAirportsId() {
		return AirportsId;
	}



	public void setAirportsId(int airportsId) {
		AirportsId = airportsId;
	}



	public String getIataCode() {
		return IataCode;
	}



	public void setIataCode(String iataCode) {
		IataCode = iataCode;
	}



	public String getAirportName() {
		return AirportName;
	}



	public void setAirportName(String airportName) {
		AirportName = airportName;
	}



	public String getCountryRegion() {
		return CountryRegion;
	}



	public void setCountryRegion(String countryRegion) {
		CountryRegion = countryRegion;
	}
	public String getCity() {
		return City;
	}



	public void setCity(String city) {
		this.City = city;
	}
}
