package com.controller.Admin;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.model.Airport;
import com.repository.FlightDao;
import com.service.FlightService;

import java.io.IOException;
import java.util.List;


@WebServlet("/api/airport")
public class AirportController extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private FlightService flightService;

    @Override
    public void init() throws ServletException {
        super.init();
        FlightDao flightDao = new FlightDao();
        flightService = new FlightService(flightDao);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String query = request.getParameter("query");
        try {
            List<Airport> airports = flightService.searchAirports(query);
            response.setContentType("application/json");
            response.setStatus(HttpServletResponse.SC_OK);
            ObjectMapper objectMapper = new ObjectMapper();
            String jsonResponse = objectMapper.writeValueAsString(airports);
            response.getWriter().write(jsonResponse);
        } catch (Exception e) {
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Internal server error");
        }
    }
}