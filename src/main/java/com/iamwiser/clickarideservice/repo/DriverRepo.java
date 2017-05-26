package com.iamwiser.clickarideservice.repo;

import com.iamwiser.clickarideservice.domain.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * Created by aiam on 5/25/2017.
 */
public interface DriverRepo extends JpaRepository<Driver, Long> {

    @Query("select f from Driver f where f.username like %?1%")
    Driver findOneByUserName(String username);

}
