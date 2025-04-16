package UI;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class RadioButtonTest {
    public WebDriver driver;

    @BeforeClass
    public void setup() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setCapability(CapabilityType.PAGE_LOAD_STRATEGY,"eager");
        driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
    }
    @AfterClass
    public void tearDown() {
        driver.quit();
    }

   @Test
   public void step_01() {
       driver.get("https://demoqa.com/radio-button");

       WebElement yesRadioButton = driver.findElement(By.xpath("//input[@type='radio']/following-sibling::label[contains(.,'Yes')]"));
       JavascriptExecutor js = (JavascriptExecutor) driver; // исполнение кода на JS
       js.executeScript("arguments[0].scrollIntoView();",yesRadioButton );
       yesRadioButton.click();

       WebElement successElement = driver.findElement(By.xpath("//span[@class='text-success']"));
       String succusessElementText = successElement.getText();
       Assert.assertEquals(succusessElementText, "Yes");

       try { // задержка открытия окна браузера
           Thread.sleep(4000);
       } catch (InterruptedException e) {
           throw new RuntimeException(e);
       }
//       WebElement successElement = driver.findElement(By.xpath("//span[@class='text-success']"));
//       String successElementText = successElement.getText();

//       Assert.assertEquals();
   }
}
