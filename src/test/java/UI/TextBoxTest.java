package UI;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TextBoxTest {

    public WebDriver driver;

    @BeforeClass // метод setup() должен быть выполнен один раз перед запуском всех тестов в классе
    public void setup() {
        WebDriverManager.chromedriver().setup(); //подключаем библиотеку, которая автоматически будет управлять драйверами
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setCapability(CapabilityType.PAGE_LOAD_STRATEGY,"eager"); // создается объект ChromeOptions, который позволяет задавать различные параметры для запуска браузера Chrome
        driver = new ChromeDriver(chromeOptions); // создается новый экземпляр ChromeDriver, который управляет браузером Chrome
        driver.manage().window().maximize(); //управляет окном браузера и максимизирует его
    }
    @AfterClass // метод закрывающий браузер после
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void checkTextBox(){
        driver.get("https://demoqa.com/text-box"); // откроется нужная страница
        WebElement userNameInput = driver.findElement(By.xpath("//input[@id='userName']")); // нашли нужный элемент на странице
        userNameInput.sendKeys("Svetlana"); // ввели в поле необходимое значение

        WebElement userEmailInput = driver.findElement(By.xpath("//input[@id='userEmail']"));
        userEmailInput.sendKeys("sveta51151378@yandex.ru");

        WebElement currentAddressTextArea = driver.findElement(By.xpath("//textarea[@id='currentAddress']"));
        currentAddressTextArea.sendKeys("Kursk");

        WebElement permanentAddressTextArea = driver.findElement(By.xpath("//textarea[@id='permanentAddress']"));
        permanentAddressTextArea.sendKeys("Moskva");

        WebElement button = driver.findElement(By.xpath("//button[@id='submit']"));
        JavascriptExecutor js = (JavascriptExecutor) driver; // исполнение кода на JS
        js.executeScript("arguments[0].scrollIntoView();", button); // какой скрипт нужно использовать и к кому его применить
        button.click();

        try { // задержка открытия окна браузера
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        // Ищем данные (которыми заполнены поля)
        WebElement userNameOutput = driver.findElement(By.xpath("//p[@id='name']"));
        WebElement userEmailOutput = driver.findElement(By.xpath("//p[@id='email']"));
        WebElement currentAddressOutput = driver.findElement(By.xpath("//p[@id='currentAddress']"));
        WebElement permanentAddressOutput = driver.findElement(By.xpath("//p[@id='permanentAddress']"));

        String name = userNameOutput.getText();
        String email = userEmailOutput.getText();
        String currentAddress = currentAddressOutput.getText();
        String permanentAddress = permanentAddressOutput.getText();

        // выводим в консоль все элементы
        System.out.println("Name: " + name + ", email: "
                        + email + ", current Address: " + currentAddress + ", permanent addres: " + permanentAddress);

        // Проверка теста
        // Assert.assertTrue(name.contains("Svetlana"), "message");
        Assert.assertEquals(email, "Email:sveta51151378@yandex.ru");

    }
    @Test // обновить страницу
    public void checkTitleTextBox() {
        String pageTitle = driver.getTitle(); //
        System.out.println("Title : " + pageTitle);
    }

}

