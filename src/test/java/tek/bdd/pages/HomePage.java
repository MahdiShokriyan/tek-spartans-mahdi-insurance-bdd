package tek.bdd.pages;

import org.openqa.selenium.By;
import tek.bdd.utilities.SeleniumUtility;

public class HomePage extends SeleniumUtility {

    public static final By CREATE_PRIMARY_ACCOUNT = By.linkText("Create Primary Account");
    public static final By START_PAGE_TITLE = By.xpath("//h2[text() ='Lets get you started']");


}
