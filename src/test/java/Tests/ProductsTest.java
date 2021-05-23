package Tests;

import Utils.CoreMethods;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static DataAndProcedures.Procedures.IsUserLoggedIn;
import static DataAndProcedures.Procedures.Register;
import static Selectors.ClassNames.productContainer;
import static Selectors.CssSelectors.searchConfirmButton;
import static Selectors.Ids.productScreenAddToCartButton;
import static Selectors.Ids.productScreenContainer;
import static Selectors.Names.searchField;

public class ProductsTest extends CoreMethods {

    public static SoftAssert softAssert = new SoftAssert();
    public static String product = "Samsung";

    @Test
    public static void SearchProductTest(){
        if(!IsUserLoggedIn()){
            Register();
        }
        elementLocate(searchField);
        sendKeys(searchField, product);
        elementClick(searchConfirmButton);
        elementLocate(productContainer);
        containsText(productContainer, product);
        softAssert.assertAll();
    }
    /*TODO - User can search for products
    Additional test cases:
        User searches product which does not exist in db
    */

    @Test
    public static void SearchAndViewProductTest(){
        if(!elementPresent(productContainer, 3)){
            Register();
            elementLocate(searchField);
            sendKeys(searchField, product);
            elementClick(searchConfirmButton);
            elementLocate(productContainer);
        }
        elementClick(productContainer);
        elementLocate(productScreenContainer);
        elementLocate(productScreenAddToCartButton);
        softAssert.assertAll();
    }
}
