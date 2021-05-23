package DataAndProcedures;

import Utils.CoreMethods;
import org.testng.asserts.SoftAssert;


import java.util.Random;

import static DataAndProcedures.Data.*;
import static DataAndProcedures.StaticTxt.REGISTER_ACCOUNT;
import static DataAndProcedures.StaticTxt.YOUR_ACCOUNT_HAS_BEEN_CREATED;
import static Selectors.ClassNames.*;
import static Selectors.CssSelectors.*;
import static Selectors.Ids.*;

public class Procedures extends CoreMethods {

    public static String userEmail = "";

    public static String generateRandomEmail(){
        Random rand = new Random();
        userEmail = userFirstName + userLastName + Integer.toString(rand.nextInt(10000)) + "@example.com";
        return userEmail;
    }

    public static void Report(String message){
        System.out.println(message);
    }

    public static void Register(){
        elementPresent(landingPageLogo, defaultWait);
        elementClick(accountDropDown);
        elementClick(registerButton);
        elementPresent(registerAccountTitle, defaultWait);
        verifyText(registerAccountTitle, REGISTER_ACCOUNT);
        sendKeys(firstNameInput, userFirstName);
        sendKeys(lastNameInput, userLastName);
        String email = generateRandomEmail();
        sendKeys(emailInput, email);
        sendKeys(phoneInput, userPhoneNumber);
        sendKeys(passwordInput, password);
        sendKeys(passwordConfirmInput, password);
        elementClick(privacyPolicyCheckbox);
        elementClick(registrationContinueButton);
        elementLocate(yourAccountHasBeenCreatedTitle);
        verifyText(yourAccountHasBeenCreatedTitle, YOUR_ACCOUNT_HAS_BEEN_CREATED);
        elementClick(accountCreatedContinueButton);
        elementLocate(myAccountTitle);
        userEmail = email;
    }

    public static void LogOut(){
        if(IsUserLoggedIn()){
            Report("Logging out!");
            elementClick(accountDropDown);
            elementLocate(loginButton);
            elementClick(logoutButton);
        }else{
            Report("User is already logged out");
        }
    }

    public static Boolean IsUserLoggedIn(){
        elementClick(accountDropDown);
        if(elementPresent(logoutButton, 5)){
            elementClick(accountDropDown);
            return true;
        }else{
            elementClick(accountDropDown);
            return false;
        }
    }

    public static void Login(String email, String password){
        elementClick(accountDropDown);
        elementClick(loginButton);
        sendKeys(emailInput, userEmail);
        sendKeys(passwordInput, password);
        elementClick(loginConfirmButton);
    }
}
