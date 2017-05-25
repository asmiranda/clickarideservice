package com.iamwiser.clickarideservice.dto;

import lombok.Data;

/**
 * Created by aiam on 5/23/2017.
 */
public @Data class RequestRiderDTO {
    private String requestor;
    private String requestTime;
    private String requestLocationOrigin;
    private String requestLocationDestination;

    private String status;

    private String acceptedBy;
    private String arrivalTime;
    private String arrivalLocationOrigin;
    private String arrivalLocationCurrent;
}
