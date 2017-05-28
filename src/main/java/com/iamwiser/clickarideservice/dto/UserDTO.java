package com.iamwiser.clickarideservice.dto;

import lombok.Data;

/**
 * Created by aiam on 5/25/2017.
 */
public @Data class UserDTO {
    private Long id;

    private String userName;
    private String password;
    private String firstName;
    private String lastName;
}
