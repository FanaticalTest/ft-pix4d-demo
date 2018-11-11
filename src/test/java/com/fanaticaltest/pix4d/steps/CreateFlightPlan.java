package com.fanaticaltest.pix4d.steps;

import com.fanaticaltest.pix4d.steps.serenity.CustomerSteps;
import cucumber.api.PendingException;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Given;
import net.thucydides.core.annotations.Steps;

public class CreateFlightPlan {

    @Steps
    CustomerSteps customer;

    @Given("^the user is on the home page$")
    public void the_user_is_on_the_home_page() throws Exception {
        customer.goes_to_pix4d_hp();
    }

    @When("^the user creates a new flight plan$")
    public void the_user_creates_a_new_flight_plan() throws Exception {
        customer.creates_new_flight_plan();
    }

    @When("^the user create a journey$")
    public void the_user_create_a_journey() throws Exception {
        customer.creates_a_journey();
    }

    @When("^the user add a flight plan description \"([^\"]*)\"$")
    public void the_user_add_a_flight_plan_description(String description) throws Exception {
        customer.add_flight_plan_description(description);
    }

    @Then("^the user sees the flight plan card with the correct \"([^\"]*)\"$")
    public void the_user_sees_the_flight_plan_card_with_the_correct(String arg1) throws Exception {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

}
