package tek.bdd.steps;

import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import tek.bdd.utilities.SeleniumUtility;

public class CommonSteps extends SeleniumUtility {


    @When("user click on a button {string}")
    public void clickOnButtonByLinkText(String text){
        clickOnElement(By.linkText(text));
    }
}
