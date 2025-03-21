package com.repository;

import java.util.List;
import java.util.ArrayList;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.model.Airport;
import com.model.Flight;
import com.util.HibernateUtil;



public class FlightDao {

    private final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    public void createFlight(Flight flight) {
        Session session =  sessionFactory.getCurrentSession();
        session.persist(flight);
    }

    public void deleteFlight(String flightNumber) {
        Session session =  sessionFactory.getCurrentSession();
        Flight flight = session.get(Flight.class, flightNumber);
        if (flight != null) {
            session.remove(flight);
        }
    }

    public void updateFlight(Flight flight) {
        Session session =  sessionFactory.getCurrentSession();
        session.merge(flight);
    }

    public List<Flight> searchFlights(String flightNumber, String originName, Long departureTime,
                                      String destinationName, Long arrivalTime) {
        Session session = sessionFactory.getCurrentSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<Flight> criteriaQuery = criteriaBuilder.createQuery(Flight.class);
        Root<Flight> root = criteriaQuery.from(Flight.class);
        List<Predicate> predicates = new ArrayList<>();
        if (flightNumber != null && !flightNumber.isEmpty()) {
            if (!flightNumber.matches("[A-Za-z]{2}.*")) {
                throw new IllegalArgumentException("Flight number must start with at least two letters.");
            }
            predicates.add(criteriaBuilder.like(root.get("flightNumber"), flightNumber + "%"));
        }

        if (originName != null && !originName.isEmpty()) {
            predicates.add(criteriaBuilder.like(root.get("originName"), "%" + originName + "%"));
        }
        if (departureTime != null) {
            predicates.add(criteriaBuilder.equal(root.get("departureTime"), departureTime));
        }
        if (destinationName != null && !destinationName.isEmpty()) {
            predicates.add(criteriaBuilder.like(root.get("destinationName"), "%" + destinationName + "%"));
        }
        if (arrivalTime != null) {
            predicates.add(criteriaBuilder.equal(root.get("arrivalTime"), arrivalTime));
        }

        criteriaQuery.where(predicates.toArray(new Predicate[0]));

        return session.createQuery(criteriaQuery).getResultList();
    }

    public List<Airport> searchAirports(String query) {
        Session session = sessionFactory.getCurrentSession();

        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<Airport> criteriaQuery = criteriaBuilder.createQuery(Airport.class);

        Root<Airport> root = criteriaQuery.from(Airport.class);

        Predicate namePredicate = criteriaBuilder.like(root.get("airportName"), "%" + query + "%");
        Predicate codePredicate = criteriaBuilder.like(root.get("iataCode"), "%" + query + "%");

        criteriaQuery.where(criteriaBuilder.or(namePredicate, codePredicate));

        return session.createQuery(criteriaQuery).getResultList();
    }
}
