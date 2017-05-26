package com.iamwiser.clickarideservice.repo;

import com.iamwiser.clickarideservice.domain.Passenger;
import com.iamwiser.clickarideservice.domain.RideRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * Created by aiam on 5/25/2017.
 */
public interface PassengerRepo extends JpaRepository<Passenger, Long> {

    @Query("select f from Passenger f where f.username like %?1%")
    Passenger findOneByUserName(String username);

}
