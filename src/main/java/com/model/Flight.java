package com.model;

import jakarta.persistence.*;
import lombok.ToString;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@ToString(exclude = "id")
@Entity
@Table(name="flight")
public class Flight implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="flightNumber")
    private String flightNumber;

    @Column(name="aircraftCode")
    private String aircraftCode;

    @Column(name="airlineName")
    private String airlineName;

    @Column(name="originName")
    private String originName;

    @Column(name="destinationName")
    private String destinationName;

    @Column(name="departureTime")
    private Long departureTime;

    @Column(name="arrivalTime")
    private Long arrivalTime;
}
