package tek.bdd.utilities;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import tek.bdd.base.BaseSetup;

import java.time.Duration;
import java.util.List;

public class SeleniumUtility extends BaseSetup {
    private static final Logger LOGGER = LogManager.getLogger(SeleniumUtility.class);


    private WebElement waitForVisibilityOfElement(By locator) {
        return getWait().until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public WebDriverWait getWait() {
        return new WebDriverWait(getDriver(), Duration.ofSeconds(20));
    }

    public byte[] takeScreenShot() {
        TakesScreenshot screenshot = (TakesScreenshot) getDriver();
        return screenshot.getScreenshotAs(OutputType.BYTES);
    }

    public void clickOnElement(By locator) {
        LOGGER.info("Click on the element by {} ", getElementText(locator));
        getWait().until(ExpectedConditions.elementToBeClickable(locator))
                .click();
    }

    public boolean elementIsDisplayed(By locator) {
        LOGGER.debug("Checking if the Element is displayed by {} ", locator);
        return getWait().until(ExpectedConditions.presenceOfElementLocated(locator)).isDisplayed();
    }

    public boolean elementIsEnabled(By locator) {
        LOGGER.debug("Checking if the Element is Enable by {} ", locator);
        return waitForVisibilityOfElement(locator).isEnabled();
    }

    public void sendText(By locator, String text) {
        LOGGER.info("sending the {} to specific field at {}", text, locator);
        WebElement field = waitForVisibilityOfElement(locator);
        field.clear();
        field.sendKeys(text);
    }

    public String getTitleElement() {
        LOGGER.info("getting the tittle of the webPage: ");
        return getDriver().getTitle();

    }

    public String getElementText(By locator) {
        LOGGER.info("getting the text value of {}", locator);
        return waitForVisibilityOfElement(locator).getText();
    }

    public WebElement getElement(By locator) {
        LOGGER.info("getting the element by {}", locator);
        return waitForVisibilityOfElement(locator);
    }

    public List<WebElement> getAllElements(By locator) {
        LOGGER.info("Getting all element located by {}", locator);
        return getWait().until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
    }

    public void selectFromDropDownByValue(By locator, String value){
        LOGGER.info("finding element of a drop down menu by {} and value is {}", locator, value);
        WebElement element = getElement(locator);
        Select select = new Select(element);
        select.selectByValue(value);
    }
}