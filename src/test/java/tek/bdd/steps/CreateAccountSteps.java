package tek.bdd.steps;

import io.cucumber.java.en.Then;
import org.junit.Assert;
import tek.bdd.pages.CreateAccountPage;
import tek.bdd.utilities.SeleniumUtility;

public class CreateAccountSteps extends SeleniumUtility {

    @Then("validate that {string} is visible as form title")
    public void validateTheTitleOfPage(String expectedResult) {
        String actualResult = getElementText(CreateAccountPage.TITLE_TEXT);

        Assert.assertEquals("both massage should be the same",expectedResult, actualResult);

    }


}
