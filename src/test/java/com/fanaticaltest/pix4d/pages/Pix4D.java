package com.fanaticaltest.pix4d.pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

@DefaultUrl("https://stupendous-birth.surge.sh/")
public class Pix4D  extends PageObject {


    @FindBy(xpath="//button[@class='md-raised md-primary md-button md-ink-ripple']")
    WebElementFacade addFlightPlanButton;

    @FindBy(xpath="//dfp-editor[@class='layout-row flex']")
    WebElementFacade flightPanel;

    @FindBy(xpath="//input[@ng-model='editor.plan.description']")
    WebElementFacade inputFlightPlanDescription;

    private Long wait = new Long(5000L);

    public void newFlightPlan() {
        addFlightPlanButton.click();
    }

    public void newRandomJourney() {
        // TODO : A better solution could be to send a api call with the gps position instead of using the UI.
        Actions builder = new Actions(getDriver());
        waitABit(wait); //This is super bad
        builder.moveToElement(flightPanel, 300, 300).click().build().perform();
        waitABit(wait); //This is super bad
        builder.moveToElement(flightPanel, 400, 400).click().build().perform();
        waitABit(wait); //This is super bad
        builder.moveToElement(flightPanel, 300, 500).click().build().perform();
        waitABit(wait);
    }

    public void addDescription(String description) {
        inputFlightPlanDescription.clear();
        inputFlightPlanDescription.type(description);
        waitABit(15000L);
    }
}
