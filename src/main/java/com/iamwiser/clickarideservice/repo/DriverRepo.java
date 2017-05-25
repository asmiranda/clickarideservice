package com.iamwiser.clickarideservice.repo;

import com.iamwiser.clickarideservice.domain.Driver;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by aiam on 5/25/2017.
 */
public interface DriverRepo extends JpaRepository<Driver, Long> {

    Driver findOneByUserName(String username);

}
