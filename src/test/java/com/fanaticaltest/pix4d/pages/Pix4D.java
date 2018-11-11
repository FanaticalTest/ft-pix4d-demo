package com.fanaticaltest.pix4d.pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.Random;

@DefaultUrl("https://stupendous-birth.surge.sh/")
public class Pix4D  extends PageObject {


    @FindBy(xpath="//button[@class='md-raised md-primary md-button md-ink-ripple']")
    WebElementFacade addFlightPlanButton;

    @FindBy(xpath="//dfp-editor[@class='layout-row flex']")
    WebElementFacade flightPanel;

    @FindBy(xpath="//input[@ng-model='editor.plan.description']")
    WebElementFacade inputFlightPlanDescription;

    @FindBy(xpath="//h3[@class='dfp-item-description ng-binding']")
    WebElementFacade labelFlightPlanDescription;

    @FindBy(xpath="//h4[@class='dfp-item-takeoff ng-binding ng-scope']")
    WebElementFacade nbPoint;

    public void newFlightPlan() {
        addFlightPlanButton.click();
    }

    public void newRandomJourney()
    {
        Actions builder = new Actions(getDriver());
        int x = 300;
        int y = 300;

        for (int i = 1; i<=3 ; i++)
        {
            addPointAndCheck(x,y,i,builder);
            x += 100;
            y += 100;
        }
    }

    private void addPointAndCheck(int x, int y, int checkValue, Actions builder)
    {
        int nbOfTry = 0;

        do
        {
            builder.moveToElement(flightPanel, x, y).click().build().perform();
            nbOfTry++;
        } while (!nbPoint.getText().endsWith(Integer.toString(checkValue)) && nbOfTry < 10);

    }

    public void addDescription(String description) {
        inputFlightPlanDescription.clear();
        inputFlightPlanDescription.type(description);
    }

    public void checkDescription(String description) {
        assert (labelFlightPlanDescription.getText().contains(description));
        waitABit(5000L);// to be removed - just for demo validation - 4-eyes validation : machine + human
    }
}
