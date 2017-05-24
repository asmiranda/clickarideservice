package com.iamwiser.clickarideservice.domain;

import javax.persistence.*;

/**
 * Created by aiam on 5/24/2017.
 */
@Entity
@Table(name="person")
@Inheritance(strategy= InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "PERSON_TYPE")
public abstract class Person {
    @Id
    @GeneratedValue
    private int id;
    private String userName;
    private String password;
    private String firstName;
    private String lastName;

//    @Column(name="PERSON_TYPE")
//    private String personType;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

//    public String getPersonType() {
//        return personType;
//    }
//
//    public void setPersonType(String personType) {
//        this.personType = personType;
//    }
}
