package Selectors;

import org.openqa.selenium.By;

public class CssSelectors {
    public static By registerButton = By.cssSelector("#top-links > ul > li.dropdown.open > ul > li:nth-child(1) > a");
    public static By loginButton = By.cssSelector("#top-links > ul > li.dropdown.open > ul > li:nth-child(2) > a");
    public static By registerAccountTitle = By.cssSelector("#content > h1");
    public static By privacyPolicyCheckbox = By.cssSelector("#content > form > div > div > input[type=checkbox]:nth-child(2)");
    public static By registrationContinueButton = By.cssSelector("#content > form > div > div > input.btn.btn-primary");
    public static By yourAccountHasBeenCreatedTitle = By.cssSelector("#content > h1");
    public static By accountCreatedContinueButton = By.cssSelector("#content > div > div > a");
    public static By myAccountTitle = By.cssSelector("#content > h2:nth-child(1)");
    public static By passwordError = By.cssSelector("#content > form > fieldset:nth-child(2) > div.form-group.required.has-error > div > div");
    public static By logoutButton = By.cssSelector("#top-links > ul > li.dropdown.open > ul > li:nth-child(5) > a");
    public static By loginConfirmButton = By.cssSelector("#content > div > div:nth-child(2) > div > form > input");
    public static By myAccountDropDown = By.cssSelector("#top-links > ul > li.dropdown.open > ul > li:nth-child(1) > a");
    public static By changeYourPassword = By.cssSelector("#content > ul:nth-child(2) > li:nth-child(2) > a");
    public static By passwordSuccessfullyUpdatedAlert = By.cssSelector("#account-account > div.alert.alert-success.alert-dismissible");
    public static By continueButton = By.cssSelector("#content > form > div > div.pull-right > input");
    public static By searchConfirmButton = By.cssSelector("#search > span > button");
}
