package tek.bdd.steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import tek.bdd.pages.AdminDashboardPage;
import tek.bdd.pages.CreateAccountPage;
import tek.bdd.utilities.SeleniumUtility;

public class LoginSteps extends SeleniumUtility {
    @When("user login with username {string} and {string} as password")
    public void userLoginWithUsernameAndAsPassword(String userName, String password) {
        sendText(CreateAccountPage.USERNAME_INPUT,userName);
        sendText(CreateAccountPage.PASSWORD_INPUT, password);
    }

    @Then("validate user is navigated to {string}")
    public void validateUserIsNavigatedTo(String expectedResult) {
     String actualResult = getElementText(AdminDashboardPage.TITLE_TEXT);
        Assert.assertEquals("both title should be the same:" , expectedResult,actualResult);
    }

    @Then("user should see error {string}")
    public void userShouldSeeError(String expectedResult) {
        String actualResult = getElementText(CreateAccountPage.ERROR_MESSAGE);
        actualResult = actualResult.replace("ERROR", "").trim();
        Assert.assertEquals("Both message should be the same: ", expectedResult, actualResult);
    }
}
