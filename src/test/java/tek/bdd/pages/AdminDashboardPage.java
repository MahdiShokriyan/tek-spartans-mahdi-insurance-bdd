package tek.bdd.pages;

import org.openqa.selenium.By;
import tek.bdd.utilities.SeleniumUtility;

public class AdminDashboardPage extends SeleniumUtility {

    public static final By TITLE_TEXT = By.xpath("//div[contains(@class,'header')]/a/following-sibling::h2");
}
