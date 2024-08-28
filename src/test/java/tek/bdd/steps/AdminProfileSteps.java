package tek.bdd.steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.testng.asserts.SoftAssert;
import tek.bdd.pages.HomePage;
import tek.bdd.pages.ProfilePage;
import tek.bdd.utilities.SeleniumUtility;

import java.util.Map;

public class AdminProfileSteps extends SeleniumUtility {

    @Then("user click on profile button")
    public void userClickOnProfileButton() {
        clickOnElement(ProfilePage.PROFILE_BUTTON);
    }

    @Then("validate information in Profile Side Drawer is correct")
    public void validateProfileSideDrawer(DataTable dataTable) {

        Map<String, String> data = dataTable.asMap();
        String expectedUserType = data.get("User Type");
        String expectedFullName = data.get("Full Name");
        String expectedUserName = data.get("UserName");
        String expectedAuthorities = data.get("Authorities");
        SoftAssert softAssert = new SoftAssert();
        String actualUserType = getElementText(ProfilePage.USER_TYPE);
        String actualFullName = getElementText(ProfilePage.FULL_NAME);
        String actualUserName = getElementText(ProfilePage.USER_NAME);
        String actualAuthorities = getElementText(ProfilePage.USER_AUTHORITIES);

        //Assertion here is done with Testng to check all the assertion
        softAssert.assertEquals(actualUserType, expectedUserType, "Both should be the same");
        softAssert.assertEquals(actualFullName, expectedFullName, "Both should be the same");
        softAssert.assertEquals(actualUserName, expectedUserName, "Both should be the same");
        softAssert.assertEquals(actualAuthorities, expectedAuthorities, "Both should be the same");
        softAssert.assertAll();
    }

    @Then("validate user navigated to home page")
    public void validateUserNavigatedToHomePage() {
       boolean isDisplayed = elementIsDisplayed(HomePage.START_PAGE_TITLE);

       Assert.assertTrue(isDisplayed);
    }
}
