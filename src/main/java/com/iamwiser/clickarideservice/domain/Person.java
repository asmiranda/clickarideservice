package com.iamwiser.clickarideservice.domain;

import lombok.Data;

import javax.persistence.*;

/**
 * Created by aiam on 5/24/2017.
 */
@Entity
@Table(name="person")
@Inheritance(strategy= InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "PERSON_TYPE")
public @Data abstract class Person {
    @Id
    @GeneratedValue
    private Long id;
    private String userName;
    private String password;
    private String firstName;
    private String lastName;
}
