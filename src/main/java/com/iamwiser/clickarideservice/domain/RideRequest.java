package com.iamwiser.clickarideservice.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import java.sql.Time;
import java.sql.Date;

/**
 * Created by aiam on 5/24/2017.
 */
@Entity
public @Data class RideRequest {
    @Id
    @GeneratedValue
    private Long id;

    private Date daterequest;
    private Time timerequest;

    private String locationfrom;
    private String locationto;

    private String status;
    private double distance;
    private double price;

    @OneToOne
    private Passenger passenger;

    @OneToOne
    private Driver driver;
}
