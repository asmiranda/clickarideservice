package com.iamwiser.clickarideservice.domain;

import lombok.Data;

import javax.persistence.*;

/**
 * Created by aiam on 5/24/2017.
 */
@Entity
@Table(name="person")
@Inheritance(strategy= InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "persontype")
public @Data abstract class Person {
    @Id
    @GeneratedValue
    private Long id;
    private String username;
    private String password;
    private String firstname;
    private String lastname;
}
