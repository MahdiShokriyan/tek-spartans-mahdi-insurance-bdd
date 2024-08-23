package tek.bdd.steps;

import io.cucumber.java.en.Then;
import org.junit.Assert;
import tek.bdd.pages.HomePage;
import tek.bdd.utilities.SeleniumUtility;

public class HomePageSteps extends SeleniumUtility {

    @Then("validate the title is {string}")
    public void validateTheTitleIs(String expectedresult) {
        String actualResult = getTitleElement();
        Assert.assertEquals("Both name should match", expectedresult, actualResult);
    }

    @Then("Create Primary Account Button is exist")
    public void buttonIsExist() {
        boolean isEnable = elementIsEnabled(HomePage.CREATE_PRIMARY_ACCOUNT);
        Assert.assertTrue(isEnable);
    }
}
