package tek.bdd.steps;

import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import tek.bdd.pages.PlanPage;
import tek.bdd.utilities.SeleniumUtility;

import java.util.List;

public class PlanSteps extends SeleniumUtility {

    @Then("validate {int} rows is available")
    public void validateRowsIsAvailable(int expectedNumberOfRows) {

        List<WebElement> elements = getAllElements(PlanPage.TABLE_ROW_LIST);
        Assert.assertEquals(expectedNumberOfRows, elements.size());
    }
}
