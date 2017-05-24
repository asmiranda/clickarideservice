package com.iamwiser.clickarideservice.controller;

import com.iamwiser.clickarideservice.dto.RequestRiderDTO;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by aiam on 5/23/2017.
 */
@RestController
public class PassengerController {

    @RequestMapping(value = "/requestRider", method = RequestMethod.POST)
    public RequestRiderDTO requestRider() {
        return new RequestRiderDTO();
    }

}
