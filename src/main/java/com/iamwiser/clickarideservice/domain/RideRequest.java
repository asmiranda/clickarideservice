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

    private Date dateRequest;
    private Time timeRequest;

    private String locationFrom;
    private String locationTo;

    private String status;

    @OneToOne
    private Passenger passenger;

    @OneToOne
    private Driver driver;
}
