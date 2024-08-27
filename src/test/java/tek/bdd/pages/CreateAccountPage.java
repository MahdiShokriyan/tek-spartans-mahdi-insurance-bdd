package tek.bdd.pages;

import org.openqa.selenium.By;

public class CreateAccountPage {

    public static final By TITLE_TEXT = By.xpath("//h2[text()='Create Primary Account Holder']");
    public static final By EMAIL_INPUT = By.id("email");
    public static final By FIRST_NAME_INPUT = By.id("firstName");
    public static final By LAST_NAME_INPUT = By.id("lastName");
    public static final By EMPLOYMENT_STATUS_INPUT = By.id("employmentStatus");
    public static final By DATE_OF_BIRTH = By.id("dateOfBirth");
    public static final By SIGN_UP_TITLE = By.xpath("//h2[text()='Sign up your account']");
    public static final By SIGN_UP_NAME = By.xpath("//h2[text()='Sign up your account']/following-sibling::h2[1]");
    public static final By SIGN_UP_EMAIL = By.xpath("//h2[text()='Sign up your account']/following-sibling::h2[2]");

    public static final By ERROR_MESSAGE = By.className("chakra-alert");
    public static final By USERNAME_INPUT = By.id("username");
    public static final By PASSWORD_INPUT = By.id("password");
    public static final By CONFIRM_PASSWORD_INPUT = By.id("confirm");




}
