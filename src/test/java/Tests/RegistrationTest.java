package Tests;

import Utils.CoreMethods;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static DataAndProcedures.Data.*;
import static DataAndProcedures.Data.password;
import static DataAndProcedures.Procedures.*;
import static DataAndProcedures.StaticTxt.*;
import static Selectors.ClassNames.*;
import static Selectors.CssSelectors.*;
import static Selectors.CssSelectors.myAccountTitle;
import static Selectors.Ids.*;

public class RegistrationTest extends CoreMethods {

    public static SoftAssert softAssert = new SoftAssert();

    @Test
    public void RegistrationFlowTest(){
        Register();
        LogOut();
        softAssert.assertAll();
    }

    @Test
    public void RegistrationUserEntersNotMatchingPasswordTest(){
        elementPresent(landingPageLogo, defaultWait);
        elementClick(accountDropDown);
        elementClick(registerButton);
        elementPresent(registerAccountTitle, defaultWait);
        verifyText(registerAccountTitle, REGISTER_ACCOUNT);
        sendKeys(firstNameInput, userFirstName);
        sendKeys(lastNameInput, userLastName);
        sendKeys(emailInput, generateRandomEmail());
        sendKeys(phoneInput, userPhoneNumber);
        sendKeys(passwordInput, password);
        sendKeys(passwordConfirmInput, password + "1");
        threadSleepSec(1);
        elementClick(privacyPolicyCheckbox);
        elementClick(registrationContinueButton);
        threadSleepSec(2);
        elementLocate(passwordError, 10);
        verifyText(passwordWarning, PASSWORD_CONFIRMATION_DOES_NOT_MATCH);
        clearElement(passwordConfirmInput);
        sendKeys(passwordConfirmInput, password);
        elementClick(registrationContinueButton);
        elementLocate(yourAccountHasBeenCreatedTitle);
        verifyText(yourAccountHasBeenCreatedTitle, YOUR_ACCOUNT_HAS_BEEN_CREATED);
        elementClick(accountCreatedContinueButton);
        elementLocate(myAccountTitle);
        softAssert.assertAll();
    }
    /*TODO - User can create an account
    Additional test cases:
        User does not accept privacy policy
        User enters invalid password (too short, too weak, etc.)
        User does not provide all necessary data
        User tries to use email that for which account already exists
    */

    @Test
    public static void UserCanLogoutAndLoginWithCredentialsTest(){
        if(!IsUserLoggedIn()){
            Register();
        }
        LogOut();
        threadSleepSec(3);
        Login(userEmail, password);
        elementLocate(myAccountTitle);
        softAssert.assertAll();
    }
    /*TODO - User can logout and login with his created account
    Additional test cases:
        User enters wrong password
    */

    @Test
    public static void UserChangesPasswordTest(){
        if(!IsUserLoggedIn()){
            Register();
        }
        elementClick(accountDropDown);
        elementClick(myAccountDropDown);
        elementClick(changeYourPassword);
        elementLocate(passwordInput);
        sendKeys(passwordInput, passwordEdited);
        sendKeys(passwordConfirmInput, passwordEdited);
        elementClick(continueButton);
        elementLocate(passwordSuccessfullyUpdatedAlert);
        verifyText(passwordSuccessfullyUpdatedAlert, PASSWORD_SUCCESSFULLY_UPDATED);
        LogOut();
        threadSleepSec(3);
        Login(userEmail, passwordEdited);
        elementLocate(myAccountTitle);
        softAssert.assertAll();
    }
    /*TODO - User can change the password and use it to log in
    Additional test cases:
        User enters invalid password (too short, too weak, etc.)
        After password is changed, user attempts to login with old password
    */

}
