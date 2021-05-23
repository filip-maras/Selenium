package Utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.TestException;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.io.Console;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static DataAndProcedures.Procedures.Report;
import static Utils.IntiateDriver.*;

public abstract class CoreMethods extends IntiateDriver {

    public static Integer miliSecondsWait = 200;

    public static void elementClick(By selector, int waitFor){
        Report("Clicking on element with selector: " + selector.toString());
        threadSleepMiliSec(miliSecondsWait);
        getElement(selector, waitFor).click();
    }

    public static void elementClick(By selector){
        elementClick(selector, defaultWait);
    }

    public static void elementLocate(By selector, int waitFor){
        Report("Locating element with selector: " + selector.toString());
        threadSleepMiliSec(miliSecondsWait);
        getElement(selector, waitFor);
    }

    public static void elementLocate(By selector){
        elementLocate(selector, defaultWait);
    }

    public static void sendKeys(By selector, String keys){
        Report("Sending keys: " + keys + " to element with selector: " + selector.toString());
        threadSleepMiliSec(miliSecondsWait);
        getElement(selector, defaultWait).sendKeys(keys);
    }

    public static Boolean elementPresent(By selector, int waitFor){
        Report("Checking if element present with selector: " + selector.toString());
        threadSleepMiliSec(miliSecondsWait);
        List<WebElement> elements = getChromeDriver().findElements(selector);
        if(elements.size() == 0){
            return false;
        }
        return true;
    }

    public static void verifyText(By selector, String text){
        String elementTxt = getElement(selector).getText();
        if(!elementTxt.equals(text)){
            failTest("Expected text " + text + " is not the same as " + elementTxt);
        }

    }

    public static void containsText(By selector, String text){
        String elementTxt = getElement(selector).getText();
        if(!elementTxt.contains(text)){
            failTest("Expected text " + text + " does not contain " + elementTxt);
        }
    }

    public static void clearElement(By selector){
        threadSleepMiliSec(miliSecondsWait);
        getElement(selector).clear();
    }

    public static WebElement getElement(By selector, int waitFor){
        new WebDriverWait(getChromeDriver(), waitFor).until(ExpectedConditions.visibilityOfElementLocated(selector));
        return getChromeDriver().findElement(selector);
    }

    public static WebElement getElement(By selector){
        return getElement(selector, defaultWait);
    }

    public static void threadSleepSec(Integer time){
        time = time * 1000;
        try{
            Thread.sleep(time);
        }
        catch (Exception e){
            System.out.println("Sleeping for %d seconds" + time);
        }
    }

    public static void threadSleepMiliSec(Integer time){
        try{
            Thread.sleep(time);
        }
        catch (Exception e){
            System.out.println("Sleeping for %d miliseconds" + time);
        }
    }

    @AfterSuite(alwaysRun = true)
    public void killDriver(){
        if(chromeDriver != null){
            chromeDriver.quit();
        }
    }

    public static void failTest(String message){
        throw new TestException(message);
    }

}
