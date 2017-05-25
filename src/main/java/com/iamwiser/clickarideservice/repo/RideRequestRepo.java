package com.iamwiser.clickarideservice.repo;

import com.iamwiser.clickarideservice.domain.Passenger;
import com.iamwiser.clickarideservice.domain.RideRequest;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by aiam on 5/25/2017.
 */
public interface RideRequestRepo extends JpaRepository<RideRequest, Long> {

    RideRequest findOneByPassenger(Passenger pass);

}
