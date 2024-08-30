package tek.bdd.steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import tek.bdd.utilities.JavaUtilities;
import tek.bdd.utilities.SeleniumUtility;

public class CommonSteps extends SeleniumUtility {
    public static String randomEmail;

    @When("user click on a link text button {string}")
    public void clickOnButtonByLinkText(String text) {
        clickOnElement(By.linkText(text));
    }

    @When("user click on a visible text button {string}")
    public void clickOnButtonByVisibleText(String text) {
        clickOnElement(By.xpath("//button[text() = '"+text+"']"));
    }

    @When("the user types {string} into the {string} field")
    public void typeInFields(String text, String fieldName) {
      if (text.equalsIgnoreCase("random")){
          randomEmail = JavaUtilities.emailGenerator("Stephan");
          sendText(By.xpath("//label[text()='" + fieldName + "']/../input"), randomEmail);
      }else {
          sendText(By.xpath("//label[text()='" + fieldName + "']/../input"), text);
      }
    }

    @When("the user Choose {string} from the {string} list")
    public void chooseFromTheDropDownList(String value, String field) {

        selectFromDropDownByValue(By.xpath(
                "//label[text() = '" + field + "']//following-sibling::div/select"),value);
    }
    @Then("user wait for {int} second")
    public void userWaitForSecond(Integer sec) {
        try {
            Thread.sleep(sec * 1000);
        }catch (InterruptedException e){
            Thread.currentThread().interrupt();
        }
    }

}