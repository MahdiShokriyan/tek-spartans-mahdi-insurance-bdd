package tek.bdd.steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import tek.bdd.pages.CreateAccountPage;
import tek.bdd.pages.ProfilePage;
import tek.bdd.utilities.JavaUtilities;
import tek.bdd.utilities.SeleniumUtility;

import java.util.Map;


public class CreateAccountSteps extends SeleniumUtility {
    private static String emailToUse;
    private static String userNameToUse;
    private static String fullName;

    @Then("validate that {string} is visible as form title")
    public void validateTheTitleOfPage(String expectedResult) {
        String actualResult = getElementText(CreateAccountPage.TITLE_TEXT);
        Assert.assertEquals("both massage should be the same", expectedResult, actualResult);
    }

    @Then("validate user can see the {string}")
    public void validateUserCanSeeThe(String expectedResult) {
        String actualResult = getElementText(CreateAccountPage.SIGN_UP_TITLE);
        Assert.assertEquals("both has to be the same", expectedResult, actualResult);
    }

    @Then("email address shows as expected")
    public void emailAddressShowsAsExpected() {
        String actualResult = getElementText(CreateAccountPage.SIGN_UP_EMAIL);
        Assert.assertEquals("Both email should be exactly the same Email: ", emailToUse, actualResult);
    }

    @Then("validate the error message should be {string}")
    public void validateTheErrorMessageShouldBe(String expectedResult) {
        String actualResult = getElementText(CreateAccountPage.ERROR_MESSAGE);
        actualResult = actualResult.replace("ERROR", "").trim();
        Assert.assertEquals("Both message should be the same: ", expectedResult, actualResult);

    }

    @When("user fill the Create new account form")
    public void userFillTheCreateNewAccountForm(DataTable dataTable) {

        Map<String, String> data = dataTable.asMap();
        String email = data.get("Email Address");
        String firstName = data.get("First Name");
        String lastName = data.get("Last Name");
        String employmentStatus = data.get("Employment Status");
        String dateOfBirth = data.get("Date Of Birth");
        emailToUse = (email.equalsIgnoreCase("random")) ?
                JavaUtilities.emailGenerator("Mathias") : email;

        sendText(CreateAccountPage.EMAIL_INPUT, emailToUse);
        sendText(CreateAccountPage.FIRST_NAME_INPUT, firstName);
        sendText(CreateAccountPage.LAST_NAME_INPUT, lastName);
        sendText(CreateAccountPage.EMPLOYMENT_STATUS_INPUT, employmentStatus);
        sendText(CreateAccountPage.DATE_OF_BIRTH, dateOfBirth);

        fullName = firstName + " " + lastName;

    }

    @When("user fill the Sign up account")
    public void userFillTheSignUpAccount() {
        userNameToUse = emailToUse.substring(0, emailToUse.indexOf("@"));
        sendText(CreateAccountPage.USERNAME_INPUT, userNameToUse);
        sendText(CreateAccountPage.PASSWORD_INPUT, "Password@123");
        sendText(CreateAccountPage.CONFIRM_PASSWORD_INPUT, "Password@123");
    }

    @Then("user login with valid username and password")
    public void userLoginWithValidUsernameAndPassword() {
        sendText(CreateAccountPage.USERNAME_INPUT,userNameToUse);
        sendText(CreateAccountPage.PASSWORD_INPUT,"Password@123");
    }

    @Then("user click on profile button and validate the {string}")
    public void userClickOnProfileButtonAndValidateTheFULLName(String name) {
       if (name.equalsIgnoreCase("full Name")) {
           clickOnElement(ProfilePage.PROFILE_BUTTON);
           String actualResult = getElementText(ProfilePage.FULL_NAME);
           Assert.assertEquals("both name should be the same", fullName, actualResult);
       }else {
           clickOnElement(ProfilePage.PROFILE_BUTTON);
           String actualResult = getElementText(ProfilePage.FULL_NAME);
           Assert.assertEquals("both name should be the same", name, actualResult);
       }
    }

}
