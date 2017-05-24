package com.iamwiser.clickarideservice.domain;

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
public class RideRequest {
    @Id
    @GeneratedValue
    private int id;

    private Date dateRequest;
    private Time timeRequest;

    private String locationFrom;
    private String locationTo;

    private String status;

    @OneToOne
    private Passenger passenger;

    @OneToOne
    private Driver driver;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDateRequest() {
        return dateRequest;
    }

    public void setDateRequest(Date dateRequest) {
        this.dateRequest = dateRequest;
    }

    public Time getTimeRequest() {
        return timeRequest;
    }

    public void setTimeRequest(Time timeRequest) {
        this.timeRequest = timeRequest;
    }

    public String getLocationFrom() {
        return locationFrom;
    }

    public void setLocationFrom(String locationFrom) {
        this.locationFrom = locationFrom;
    }

    public String getLocationTo() {
        return locationTo;
    }

    public void setLocationTo(String locationTo) {
        this.locationTo = locationTo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }
}
