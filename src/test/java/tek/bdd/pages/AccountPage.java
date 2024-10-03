package tek.bdd.pages;

import org.openqa.selenium.By;

public class AccountPage {
    public static final By RECORD_PER_PAGE_DROPDOWN =
            By.xpath("//div[starts-with(@class, 'chakra-select__wrapper')]//child::select");
}
