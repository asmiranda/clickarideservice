package com.iamwiser.clickarideservice.repo;

import com.iamwiser.clickarideservice.domain.Passenger;
import com.iamwiser.clickarideservice.domain.RideRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * Created by aiam on 5/25/2017.
 */
public interface RideRequestRepo extends JpaRepository<RideRequest, Long> {

    RideRequest findOneByPassenger(Passenger pass);

    @Query("select f from RideRequest f where f.passenger.username like %?1% and f.status not in ('CANCEL', 'COMPLETE')")
    RideRequest findOneByPassengerActiveRequest(String passenger);

    @Query("select f from RideRequest f where f.passenger.username like %?1% order by f.id desc")
    RideRequest findLastOneByPassengerActiveRequest(String passenger);

    @Query("select f from RideRequest f where f.driver.username like %?1% order by f.id desc")
    RideRequest findLastOneByDriverActiveRequest(String passenger);
}
