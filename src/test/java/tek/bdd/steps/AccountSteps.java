package tek.bdd.steps;

import io.cucumber.java.en.When;
import tek.bdd.pages.AccountPage;
import tek.bdd.utilities.SeleniumUtility;

public class AccountSteps extends SeleniumUtility {

    @When("user change Show per page to {string}")
    public void userChangeShowPerPageTo(String value) {
        selectFromDropDownByValue(AccountPage.RECORD_PER_PAGE_DROPDOWN, value);
    }

}
