package tek.bdd.steps;

import io.cucumber.java.en.Then;
import org.junit.Assert;
import tek.bdd.pages.CreateAccountPage;
import tek.bdd.utilities.SeleniumUtility;

public class CreateAccountSteps extends SeleniumUtility {

    @Then("validate that {string} is visible as form title")
    public void validateTheTitleOfPage(String expectedResult) {
        String actualResult = getElementText(CreateAccountPage.TITLE_TEXT);
        Assert.assertEquals("both massage should be the same", expectedResult, actualResult);
    }

    @Then("validate user can see the {string}")
    public void validateUserCanSeeThe(String expectedResult) {
        String actualResult = getElementText(CreateAccountPage.SIGN_UP_TITLE);
        Assert.assertEquals("both has to be the same",expectedResult, actualResult);
    }
    @Then("email address shows as expected")
    public void emailAddressShowsAsExpected() {
       String actualResult = getElementText(CreateAccountPage.SIGN_UP_EMAIL);
       Assert.assertEquals("Both email should be exactly the same Email: ",
               CommonSteps.randomEmail, actualResult);
    }
    public void fillTheFormAndClick(){

        sendText(CreateAccountPage.EMAIL_INPUT,"mathias@gmail.com");
        sendText(CreateAccountPage.FIRST_NAME_INPUT,"Mathias");

    }


}
