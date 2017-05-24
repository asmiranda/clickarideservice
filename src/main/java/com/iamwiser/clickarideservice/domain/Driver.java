package com.iamwiser.clickarideservice.domain;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * Created by aiam on 5/24/2017.
 */
@Entity
@DiscriminatorValue(value = "DRIVER")
public class Driver extends Person {
}
