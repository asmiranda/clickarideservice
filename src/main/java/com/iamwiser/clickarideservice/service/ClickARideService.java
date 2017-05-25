package com.iamwiser.clickarideservice.service;

import com.iamwiser.clickarideservice.domain.Driver;
import com.iamwiser.clickarideservice.domain.Passenger;
import com.iamwiser.clickarideservice.domain.RideRequest;
import com.iamwiser.clickarideservice.dto.RequestRiderDTO;
import com.iamwiser.clickarideservice.dto.UserDTO;
import com.iamwiser.clickarideservice.repo.DriverRepo;
import com.iamwiser.clickarideservice.repo.PassengerRepo;
import com.iamwiser.clickarideservice.repo.RideRequestRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by aiam on 5/25/2017.
 */
@Service
public class ClickARideService {
    @Autowired
    PassengerRepo passengerRepo;

    @Autowired
    DriverRepo driverRepo;

    @Autowired
    RideRequestRepo rideRequestRepo;

    public RequestRiderDTO requestRider(RequestRiderDTO dto) {
        RequestRiderDTO requestRiderDTO = new RequestRiderDTO();
//        save a RideRequest record for a passenger
        Passenger pass = passengerRepo.findOneByUserName(dto.getRequestor());
        RideRequest rideRequest = rideRequestRepo.findOneByPassenger(pass);
        if (rideRequest == null) {
            rideRequest = new RideRequest();
            rideRequest.setPassenger(pass);
            rideRequestRepo.save(rideRequest);
        }
        return requestRiderDTO;
    }

    public String registerPassenger(UserDTO user) {
        String retString = "";
        Passenger pass = passengerRepo.findOneByUserName(user.getUserName());
        if (pass == null) {
            pass = new Passenger();
            pass.setUserName(user.getUserName());
            pass.setPassword(user.getPassword());
            pass.setFirstName(user.getFirstName());
            pass.setLastName(user.getLastName());
            passengerRepo.save(pass);
            retString = "OK";
        }
        else {
            retString = "User exists";
        }
        return  retString;
    }

    public RequestRiderDTO acceptRide(RequestRiderDTO dto) {
        RequestRiderDTO requestRiderDTO = new RequestRiderDTO();
//        update a RideRequest record for a passenger
        Passenger pass = passengerRepo.findOneByUserName(dto.getRequestor());
        RideRequest rideRequest = rideRequestRepo.findOneByPassenger(pass);
        if (rideRequest != null) {
            Driver driver = driverRepo.findOneByUserName(dto.getAcceptedBy());
            rideRequest.setDriver(driver);
            rideRequestRepo.save(rideRequest);
        }
        return requestRiderDTO;
    }

    public String registerDriver(UserDTO user) {
        String retString = "";
        Driver driver = driverRepo.findOneByUserName(user.getUserName());
        if (driver == null) {
            driver = new Driver();
            driver.setUserName(user.getUserName());
            driver.setPassword(user.getPassword());
            driver.setFirstName(user.getFirstName());
            driver.setLastName(user.getLastName());
            driverRepo.save(driver);
            retString = "OK";
        }
        else {
            retString = "User exists";
        }
        return  retString;
    }
}
