package com.iamwiser.clickarideservice.steps;

import com.iamwiser.clickarideservice.dto.UserDTO;
import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import gherkin.formatter.model.DataTableRow;

import java.util.List;

import static com.jayway.restassured.RestAssured.when;
/**
 * Created by aiam on 5/27/2017.
 */
public class RideRequestSteps {
    @Given("^drivers and passenger registered$")
    public void drivers_and_passenger_registered(DataTable data) throws Throwable {
        List<DataTableRow> lst = data.getGherkinRows();
//        note: the first data is the title
        for (int i=1; i<lst.size(); i++) {
            DataTableRow row = lst.get(i);
            List<String> cells = row.getCells();
//            register all data
            UserDTO user = new UserDTO();
            user.setUserName(cells.get(1));
            user.setPassword(cells.get(2));
            user.setFirstName(cells.get(3));
            user.setLastName(cells.get(4));
            if ("passenger".equalsIgnoreCase(cells.get(0))) {
//                when()
//                        .post("/registerPasenger").body(user)
//                        .then().statusCode(200);
            }
            else {
//                when()
//                        .post("/registerDriver", user)
//                        .then().statusCode(200);
            }
        }

    }

    @When("^passenger (.*)$")
    public void passenger_paction(String action) throws Throwable {
    }

    @When("^driver (.*)$")
    public void driver_daction(String action) throws Throwable {
    }

    @Then("^the ride will be (.*)$")
    public void the_ride_will_be_status(String status) throws Throwable {
    }
}
