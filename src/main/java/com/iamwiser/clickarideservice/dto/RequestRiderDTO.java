package com.iamwiser.clickarideservice.dto;

/**
 * Created by aiam on 5/23/2017.
 */
public class RequestRiderDTO {
    private String requestor;
    private String requestTime;
    private String requestLocationOrigin;
    private String requestLocationDestination;

    public String getRequestor() {
        return requestor;
    }

    public void setRequestor(String requestor) {
        this.requestor = requestor;
    }

    public String getRequestTime() {
        return requestTime;
    }

    public void setRequestTime(String requestTime) {
        this.requestTime = requestTime;
    }

    public String getRequestLocationOrigin() {
        return requestLocationOrigin;
    }

    public void setRequestLocationOrigin(String requestLocationOrigin) {
        this.requestLocationOrigin = requestLocationOrigin;
    }

    public String getRequestLocationDestination() {
        return requestLocationDestination;
    }

    public void setRequestLocationDestination(String requestLocationDestination) {
        this.requestLocationDestination = requestLocationDestination;
    }
}
