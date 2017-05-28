package com.iamwiser.clickarideservice.controller;

import com.iamwiser.clickarideservice.domain.Passenger;
import com.iamwiser.clickarideservice.dto.RequestRiderDTO;
import com.iamwiser.clickarideservice.dto.UserDTO;
import com.iamwiser.clickarideservice.service.ClickARideService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
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
public class PassengerController {
    @Autowired
    ClickARideService service;

    @RequestMapping(value = "/requestRider",
            produces = { "application/json" },
            consumes = { "application/json" },
            method = RequestMethod.POST)
    public ResponseEntity<RequestRiderDTO> requestRider(@RequestBody RequestRiderDTO dto) {
        RequestRiderDTO retDTO = service.requestRider(dto);
        return new ResponseEntity<>(retDTO, HttpStatus.OK);
    }

    @RequestMapping(value = "/registerPassenger",
            produces = { "application/json" },
            consumes = { "application/json" },
            method = RequestMethod.POST)
    public ResponseEntity<UserDTO> registerPassenger(@RequestBody UserDTO user) {
        user = service.registerPassenger(user);
        return new ResponseEntity<>(user, null, HttpStatus.OK);
    }

    @RequestMapping(value = "/cancelRequestRider",
            produces = { "application/json" },
            consumes = { "application/json" },
            method = RequestMethod.POST)
    public ResponseEntity<String> cancelRequestRider(@RequestBody RequestRiderDTO dto) {
        String ret = service.cancelRequestRider(dto);
        return new ResponseEntity<>(ret, HttpStatus.OK);
    }
}
