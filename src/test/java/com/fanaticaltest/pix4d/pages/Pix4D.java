package com.fanaticaltest.pix4d.pages;

import com.paulhammant.ngwebdriver.ByAngularBinding;
import com.paulhammant.ngwebdriver.NgWebDriver;
import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

@DefaultUrl("https://stupendous-birth.surge.sh/")
public class Pix4D  extends PageObject {

    private static String XPATH_ADDFLIGHT_BUTTON = "//button[@class='md-raised md-primary md-button md-ink-ripple']";
    private static String XPATH_FLIGHTPANEL = "//dfp-editor[@class='layout-row flex']";
    private static String XPATH_FLIGHTDESC_INPUT = "//input[@ng-model='editor.plan.description']";
    private static String XPATH_FLIGHTDESC_LABEL = "//h3[@class='dfp-item-description ng-binding']";
    private static String XPATH_NBPOINT = "//h4[@class='dfp-item-takeoff ng-binding ng-scope']";

    public void newFlightPlan() {
        find(ByAngularBinding.xpath(XPATH_ADDFLIGHT_BUTTON)).click();
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
        waitAngular(getDriver());
        int nbOfTry = 0;

        do
        {
            builder.moveToElement(find(ByAngularBinding.xpath(XPATH_FLIGHTPANEL)), x, y).click().build().perform();
            nbOfTry++;
        } while (!find(ByAngularBinding.xpath(XPATH_NBPOINT)).getText().endsWith(Integer.toString(checkValue)) && nbOfTry < 10);

    }

    public void addDescription(String description) {
        find(ByAngularBinding.xpath(XPATH_FLIGHTDESC_INPUT)).clear();
        find(ByAngularBinding.xpath(XPATH_FLIGHTDESC_INPUT)).type(description);
    }

    public void checkDescription(String description) {
        assert (find(ByAngularBinding.xpath(XPATH_FLIGHTDESC_LABEL)).getText().contains(description));
        waitABit(5000L);// to be removed - just for demo validation - 4-eyes validation : machine + human
    }

    private void waitAngular(WebDriver driver)
    {
        NgWebDriver ngWebDriver = new NgWebDriver((JavascriptExecutor) driver);
        ngWebDriver.waitForAngularRequestsToFinish();
    }
}
