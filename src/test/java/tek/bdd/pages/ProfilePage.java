package tek.bdd.pages;

import org.openqa.selenium.By;
import tek.bdd.utilities.SeleniumUtility;

public class ProfilePage extends SeleniumUtility {

    public static final By PROFILE_BUTTON = By.xpath("//button[@aria-label = 'profile']");
    public static final By FULL_NAME = By.xpath("//p[text() = 'FULL NAME']/following-sibling::p");
}
