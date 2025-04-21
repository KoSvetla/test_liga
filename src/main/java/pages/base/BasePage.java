package pages.base;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class BasePage {
    public WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }
// по ТК нам надо найти конкретную формочку, мы убеждаемся,
// что мы ее правильно нашли тем, что получаем название соответствующей страницы
    private static final By NAME_PAGE = By.xpath("//h1[@class='text-center']");
// создаем метод, который будет открывать страницы,
// будем сразу вызывать переменную и не обращаться к драйверу каждый раз
    /** *Перейти по URL
     * @param url*/
    public void openUrl (String url) {
        driver.get(url);
    }
// добавляем сюда историю с поиском элемента и прокруткой окна браузера
    /**
     * Найти элемент на странице
     * @param locator путь до элемента, тип - By
     * @return element найденный элемент*/
    public WebElement findElement(By locator){
        WebElement element = driver.findElement(locator);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", element);
        return element;
    }
    public List<WebElement> findElements(String locator){
        return driver.findElements(By.xpath(locator));
    }
// получаем строку текста
    public String getText(By locator){
        return findElement(locator).getText();
    }
    public String getPageName(){
        return getText(NAME_PAGE);
    }
// проверка доступности элемента
    public boolean isElementEnabled(By locator){
        return findElement(locator).isEnabled();
    }
 // очистить поле
    public void clear(By locator){
        findElement(locator).clear();
    }
 // внесение значений
    public void sendkeys(By locator, String text){
        findElement(locator).sendKeys(text);
    }
 // нажать на кнопку
    public void click(By locator){
        findElement(locator).click();
    }

    /**
     * Метод вызывающий AssertionError
     */
    public void failure() {
        throw new AssertionError();
    }
// проверка отображения элемента на странице
    public boolean isElementDisplay(By locator){
        try{
            return findElement(locator).isDisplayed();
        } catch (Exception ex){
            return false;
        }
    }
    public void waitElementIsDidplay(By locator, int seconds){
        new WebDriverWait(driver, Duration.ofSeconds(seconds)).until(driver1 -> isElementDisplay(locator));
    }
}
