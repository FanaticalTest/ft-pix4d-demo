package com.fanaticaltest.pix4d.steps.serenity;

import com.fanaticaltest.pix4d.pages.*;
import net.thucydides.core.steps.ScenarioSteps;


public class CustomerSteps extends ScenarioSteps {

    Pix4D pix4d;

    //Pix4d customer
    public void goes_to_pix4d_hp() {pix4d.open();}

    public void creates_new_flight_plan() {pix4d.newFlightPlan();}

    public void creates_a_journey() {pix4d.newRandomJourney();}

    public void add_flight_plan_description(String description) {pix4d.addDescription(description);}
}
