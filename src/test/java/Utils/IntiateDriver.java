package Utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeSuite;

import java.util.concurrent.TimeUnit;

public abstract class IntiateDriver {

    public static WebDriver chromeDriver;
    public static final int defaultWait = 5;

    @BeforeSuite(alwaysRun = true)
    public void setUp(){
        ChromeOptions options = new ChromeOptions();
        //options.addArguments("headless");

        System.setProperty("webdriver.chrome.driver", "C:\\Coding\\SeleniumProject\\src\\test\\java\\Utils\\chromedriver.exe");
        chromeDriver = new ChromeDriver(options);
        chromeDriver.manage().window().maximize();
        chromeDriver.manage().timeouts().pageLoadTimeout(defaultWait, TimeUnit.SECONDS);
        chromeDriver.manage().timeouts().setScriptTimeout(defaultWait, TimeUnit.SECONDS);
        chromeDriver.manage().timeouts().implicitlyWait(defaultWait, TimeUnit.SECONDS);
        chromeDriver.get("https://demo.opencart.com/");
    }

    public static WebDriver getChromeDriver(){
        return chromeDriver;
    }
}
