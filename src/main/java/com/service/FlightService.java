package com.service;


import java.sql.SQLException;
import java.util.List;

import com.model.Airport;
import com.model.Flight;
import com.repository.FlightDao;


public class FlightService {
    private final FlightDao flightDao;

    public FlightService(FlightDao flightDao) {
        this.flightDao = flightDao;
    }

    public boolean createFlight(Flight flight) {
        try {
            flightDao.createFlight(flight);
            return true;
        } catch (Exception e) {
            return false;
        }

    }

    public boolean deleteFlight(String flightNumber) {
        try {
            flightDao.deleteFlight(flightNumber);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean updateFlight(Flight flight) {
        try {
            flightDao.updateFlight(flight);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public List<Flight> searchFlights(String flightNumber, String originName, Long departureTime,
                                      String destinationName,
                                      Long arrivalTime) {
        return flightDao.searchFlights(flightNumber, originName, departureTime, destinationName,
                arrivalTime);
    }

    public List<Airport> searchAirports(String query) {
        return flightDao.searchAirports(query);
    }

}