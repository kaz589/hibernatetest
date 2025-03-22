package com.controller.Admin;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.model.Flight;
import com.repository.FlightDao;
import com.service.FlightService;


@WebServlet("/api/flights/*")
public class FlightController extends HttpServlet {

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
        String flightNumber = request.getParameter("flightNumber");
        String originName = request.getParameter("originName");
        String destinationName = request.getParameter("destinationName");
        Long departureTime = null;
        Long arrivalTime = null;

        try {
            if (request.getParameter("departureTime") != null) {
                departureTime = Long.parseLong(request.getParameter("departureTime"));
            }
            if (request.getParameter("arrivalTime") != null) {
                arrivalTime = Long.parseLong(request.getParameter("arrivalTime"));
            }
        } catch (NumberFormatException e) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid time format");
            return;
        }

        try {
            List<Flight> flights = flightService.searchFlights(flightNumber, originName, departureTime, destinationName,
                    arrivalTime);
            response.setContentType("application/json");
            response.setStatus(HttpServletResponse.SC_OK);
            ObjectMapper objectMapper = new ObjectMapper();
            String jsonResponse = objectMapper.writeValueAsString(flights);
            response.getWriter().write(jsonResponse);
        } catch (Exception e) {
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Internal server error");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Flight flight = new Flight();
        flight.setFlightNumber(request.getParameter("flightNumber"));
        flight.setAirlineName(request.getParameter("airlineName"));
        flight.setAircraftCode(request.getParameter("aircraftCode"));
        flight.setOriginName(request.getParameter("originName"));
        flight.setDestinationName(request.getParameter("destinationName"));
        flight.setDepartureTime(Long.parseLong(request.getParameter("departureTime")));
        try {
            Boolean isCreated = flightService.createFlight(flight);
            if (isCreated) {
                response.setContentType("application/json");
                response.setStatus(HttpServletResponse.SC_CREATED);
            } else {
                response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Internal server error");
            }
        } catch (Exception e) {
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Internal server error");
        }
    }

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String flightNumber = request.getParameter("flightNumber");
        try {
            Boolean isDeleted = flightService.deleteFlight(flightNumber);
            if (isDeleted) {
                response.setContentType("application/json");
                response.setStatus(HttpServletResponse.SC_OK);
            } else {
                response.sendError(HttpServletResponse.SC_NOT_FOUND, "Flight not found");
            }
        } catch (Exception e) {
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Internal server error");
        }
    }

    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try (BufferedReader reader = request.getReader()) {
            StringBuilder jsonInput = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                jsonInput.append(line);
            }
            ObjectMapper objectMapper = new ObjectMapper();
            Flight flight = objectMapper.readValue(jsonInput.toString(), Flight.class);
            Boolean isUpdated = flightService.updateFlight(flight);
            response.setContentType("application/json");
            if (isUpdated) {
                response.setStatus(HttpServletResponse.SC_OK);
            } else {
                response.sendError(HttpServletResponse.SC_NOT_FOUND, "Flight not found");
            }
        } catch (Exception e) {
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Internal server error");
        }
    }
}
