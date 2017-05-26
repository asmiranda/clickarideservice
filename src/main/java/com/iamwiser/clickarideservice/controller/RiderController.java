package com.iamwiser.clickarideservice.controller;

import com.iamwiser.clickarideservice.dto.RequestRiderDTO;
import com.iamwiser.clickarideservice.dto.UserDTO;
import com.iamwiser.clickarideservice.service.ClickARideService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by aiam on 5/23/2017.
 */
@RestController
public class RiderController {
    @Autowired
    ClickARideService service;

    @RequestMapping(value = "/acceptRide",
            produces = { "application/json" },
            consumes = { "application/json" },
            method = RequestMethod.POST)
    public RequestRiderDTO acceptRide(@RequestBody RequestRiderDTO dto) {
        RequestRiderDTO retDTO = service.acceptRide(dto);
        return retDTO;
    }

    @RequestMapping(value = "/registerDriver",
            produces = { "application/json" },
            consumes = { "application/json" },
            method = RequestMethod.POST)
    public String registerDriver(@RequestBody UserDTO user) {
        String ret = service.registerDriver(user);
        return ret;
    }

    @RequestMapping(value = "/completeAcceptRide",
            produces = { "application/json" },
            consumes = { "application/json" },
            method = RequestMethod.POST)
    public ResponseEntity<String> cancelReqcompleteAcceptRideuestRider(@RequestBody RequestRiderDTO dto) {
        String ret = service.completeAcceptRide(dto);
        return new ResponseEntity<>(ret, HttpStatus.OK);
    }
}
