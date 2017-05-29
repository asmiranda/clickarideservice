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

    public String cancelRequestRider(RequestRiderDTO dto) {
        String cancel = "";
        RequestRiderDTO requestRiderDTO = new RequestRiderDTO();
        RideRequest rideRequest = rideRequestRepo.findOneByPassengerActiveRequest(dto.getRequestor());
        if (rideRequest != null) {
            rideRequest.setStatus("CANCEL");
            rideRequestRepo.save(rideRequest);
            cancel = "OK";
        }
        return cancel;
    }

    public String completeAcceptRide(RequestRiderDTO dto) {
        String complete = "";
        RequestRiderDTO requestRiderDTO = new RequestRiderDTO();
        RideRequest rideRequest = rideRequestRepo.findOneByPassengerActiveRequest(dto.getRequestor());
        if (rideRequest != null) {
            rideRequest.setStatus("COMPLETE");
            rideRequestRepo.save(rideRequest);
            complete = "OK";
        }
        return complete;
    }

    public RequestRiderDTO requestRider(RequestRiderDTO dto) {
        RequestRiderDTO requestRiderDTO = new RequestRiderDTO();
//        save a RideRequest record for a passenger
        Passenger pass = passengerRepo.findOneByUserName(dto.getRequestor());
        if (pass == null) {
//            create pass
            UserDTO user = new UserDTO();
            user.setUserName(dto.getRequestor());
            registerPassenger(user);
            pass = passengerRepo.findOneByUserName(dto.getRequestor());
        }
        RideRequest rideRequest = rideRequestRepo.findOneByPassengerActiveRequest(dto.getRequestor());
        if (rideRequest == null) {
            rideRequest = new RideRequest();
            rideRequest.setPassenger(pass);
            rideRequest.setStatus("NEW");
            rideRequestRepo.save(rideRequest);
        }
        return requestRiderDTO;
    }
    public RequestRiderDTO acceptRide(RequestRiderDTO dto) {
        RequestRiderDTO requestRiderDTO = new RequestRiderDTO();
//        update a RideRequest record for a passenger
        Passenger pass = passengerRepo.findOneByUserName(dto.getRequestor());
        RideRequest rideRequest = rideRequestRepo.findOneByPassengerActiveRequest(dto.getRequestor());
        if (rideRequest != null) {
            Driver driver = driverRepo.findOneByUserName(dto.getAcceptedBy());
            rideRequest.setDriver(driver);
            rideRequest.setStatus("ACCEPT");
            rideRequestRepo.save(rideRequest);
        }
        return requestRiderDTO;
    }

    public UserDTO registerPassenger(UserDTO user) {
        Passenger pass = passengerRepo.findOneByUserName(user.getUserName());
        if (pass == null) {
            pass = new Passenger();
            pass.setUsername(user.getUserName());
            pass.setPassword(user.getPassword());
            pass.setFirstname(user.getFirstName());
            pass.setLastname(user.getLastName());
            passengerRepo.save(pass);
            user.setId(pass.getId());
        }
        return user;
    }
    public String registerDriver(UserDTO user) {
        String retString = "";
        Driver driver = driverRepo.findOneByUserName(user.getUserName());
        if (driver == null) {
            driver = new Driver();
            driver.setUsername(user.getUserName());
            driver.setPassword(user.getPassword());
            driver.setFirstname(user.getFirstName());
            driver.setLastname(user.getLastName());
            driverRepo.save(driver);
            retString = "OK";
        }
        else {
            retString = "User exists";
        }
        return  retString;
    }
}
