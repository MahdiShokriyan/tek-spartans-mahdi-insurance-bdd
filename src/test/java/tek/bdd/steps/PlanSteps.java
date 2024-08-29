package tek.bdd.steps;

import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;
import tek.bdd.pages.PlanPage;
import tek.bdd.utilities.SeleniumUtility;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class PlanSteps extends SeleniumUtility {

    @Then("validate {int} rows is available")
    public void validateRowsIsAvailable(int expectedNumberOfRows) {

        List<WebElement> elements = getAllElements(PlanPage.TABLE_ROW_LIST);
        Assert.assertEquals(expectedNumberOfRows, elements.size());
    }

    @Then("validate create date is today date and expire date is one day after")
    public void validateCreateDateIsTodayDateAndExpireDateIsOneDayAfter() {
        SoftAssert softAssert = new SoftAssert();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("MMMM d, yyyy");
        List<WebElement> createDateElements = getAllElements(PlanPage.DATE_CREATE_LIST);
        for (WebElement element : createDateElements) {
            String retrievedDateStr = element.getText();
            LocalDate retrievedDate = LocalDate.parse(retrievedDateStr, dateTimeFormatter);
            LocalDate todayDate = LocalDate.now(ZoneId.of("-05:00"));
            softAssert.assertEquals(retrievedDate, todayDate, "both date should match");
        }

        List<WebElement> expireDateElements = getAllElements(PlanPage.DATE_EXPIRE_LIST);
        for (WebElement expireElement : expireDateElements) {
            String retrievedExpiredDateStr = expireElement.getText();
            LocalDate retrievedExpiredDate = LocalDate.parse(retrievedExpiredDateStr, dateTimeFormatter);
            LocalDate expectedExpireDate = LocalDate.now(ZoneId.of("-05:00")).plusDays(1);
            softAssert.assertEquals(retrievedExpiredDate,expectedExpireDate, "Both date should match");
        }
        softAssert.assertAll();
    }
}
