package com.iamwiser.clickarideservice.steps;

import com.iamwiser.clickarideservice.dto.UserDTO;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static com.jayway.restassured.RestAssured.when;

/**
 * Created by aiam on 5/26/2017.
 */
public class RegisterSteps {
    UserDTO user = new UserDTO();

    @Given("^actor$")
    public void actor() throws Throwable {
    }

    @When("^actor is (.*) and typed (.*), (.*), (.*), (.*)$")
    public void actorRegister(String actorIs, String username, String password, String firtname, String lastname) throws Throwable {
        user.setUserName(username);
        user.setPassword(password);
        user.setFirstName(firtname);
        user.setLastName(lastname);
    }

    @Then("^the actor will be (.*)$")
    public void theActorTypeIs(String actorIs) throws Throwable {
//        if ("passenger".equalsIgnoreCase(user.getUsertype())) {
//            when()
//                    .get("/registerPasenger", user)
//                    .then().statusCode(200);
//        }
//        else {
//            when()
//                    .get("/registerDriver", user)
//                    .then().statusCode(200);
//        }
    }
}
