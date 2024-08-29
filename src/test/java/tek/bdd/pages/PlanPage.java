package tek.bdd.pages;

import org.openqa.selenium.By;
import tek.bdd.utilities.SeleniumUtility;

public class PlanPage extends SeleniumUtility {

    public static final By TABLE_ROW_LIST = By.xpath("//table/tbody/tr");
    public static final By DATE_CREATE_LIST = By.xpath("//table/tbody/tr/td[4]");
    public static final By DATE_EXPIRE_LIST = By.xpath("//table/tbody/tr/td[5]");
}
