package tek.bdd.pages;

import org.openqa.selenium.By;

public class CreateAccountPage {

    public static final By TITLE_TEXT = By.xpath("//h2[text()='Create Primary Account Holder']");
    public static final By EMAIL_INPUT = By.id("email");
    public static final By FIRST_NAME_INPUT = By.id("firstName");
    public static final By LAST_NAME_INPUT = By.id("lastName");
    public static final By EMPLOYMENT_STATUS_INPUT = By.id("employmentStatus");
    public static final By TITLE_MENU = By.id("title");
    public static final By GENDER_MENU = By.id("gender");
    public static final By MARITAL_STATUS_MENU = By.id("maritalStatus");
    public static final By DATE_OF_BIRTH = By.id("dateOfBirth");
    public static final By CREATE_ACCOUNT_BUTTON = By.xpath("//button[text()='Create Account']");
    public static final By CLEAR_FORM_BUTTON = By.xpath("//button[text()='Clear Form']");
    public static final By SIGN_UP_TITLE = By.xpath("//h2[text()='Sign up your account']");
    public static final By SIGN_UP_NAME = By.xpath("//h2[text()='Sign up your account']/following-sibling::h2[1]");
    public static final By SIGN_UP_EMAIL = By.xpath("//h2[text()='Sign up your account']/following-sibling::h2[2]");


}
