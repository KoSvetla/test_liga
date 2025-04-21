package base;

import browser.Browser;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest {

    protected WebDriver driver;

    @BeforeClass
    public void setupClass(){
        System.out.println("Setting up before class.");
        driver = Browser.createDriver();
    }

    @AfterClass
    public void tearDownClass(){
        System.out.println("Tearing down up before class.");
        if (driver != null) {
            driver.quit();
        }
    }
}