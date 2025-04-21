package pages.demoqa;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.base.BasePage;

public class TextBoxPage extends BasePage {
    public TextBoxPage(WebDriver driver) {
        super(driver);
    }
    public static final String URL_TEXT_BOX_PAGE = "https://demoqa.com/text-box";
    public  static final String INPUT_FULL_NAME_XPATH = "//input[@id='userName']";
    public static final String INPUT_EMAIL_XPATH ="//input[@id='userEmail']";
    public static final String CURRENT_ADDRESS_TEXT_AREA = "//textarea[@id='currentAddress']";
    public static final String PERMANENT_ADDRESS_TEXT_AREA = "//textarea[@id='permanentAddress']";
    public static final String BUTTON = "//button[@id='submit']";

    public static final String USER_NAME_OUTPUT = "//p[@id='name']";
    public static final String USER_EMAIL_OUTPUT = "//p[@id='email']";
    public static final String CURRENT_ADDRESS_OUTPUT = "//p[@id='currentAddress']";
    public static final String PERMANENT_ADDRESS_OUTPUT = "//p[@id='permanentAddress']";


    public void openTextBoxPage(){
        openUrl(URL_TEXT_BOX_PAGE);
    }
    public void setInputFullName(){
        sendKeys(By.xpath(INPUT_FULL_NAME_XPATH), "Svetlana");
    }
    public void setInputEmail(){
        sendKeys(By.xpath(INPUT_EMAIL_XPATH), "sveta51151378@yandex.ru");
    }
    public void setCurrentAddress(){
        sendKeys(By.xpath(CURRENT_ADDRESS_TEXT_AREA), "Kursk");
    }
    public void setPermanentAddress(){
        sendKeys(By.xpath(PERMANENT_ADDRESS_TEXT_AREA), "Kursk");
    }
    public void clickButton(){
        findElement(By.xpath(BUTTON)).click();
    }

    public String getName(){
       return getText(By.xpath(USER_NAME_OUTPUT));
    }
    public String getEmail(){
         return getText(By.xpath(USER_EMAIL_OUTPUT));
    }
    public String getCurrentAddress(){
        return getText(By.xpath(CURRENT_ADDRESS_OUTPUT));
    }
    public String  getPermanentAddress(){
         return getText(By.xpath(PERMANENT_ADDRESS_OUTPUT));
    }

}





