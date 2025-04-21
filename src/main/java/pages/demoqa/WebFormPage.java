package pages.demoqa;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import pages.base.BasePage;

public class WebFormPage extends BasePage {
    public WebFormPage(WebDriver driver) {
        super(driver);
    }
    public static final String URL_WEB_FORM_PAGE =
            "https://www.selenium.dev/selenium/web/web-form.html";
    public static final String TEXT_INPUT_XPATH = "//input[@name='my-text']";
    public static final String PASSWORD_XPATH = "//input[@name='my-password']";
    public static final String TEXTAREA_XPATH = "//textarea[@name='my-textarea']";

    private static final String DROPDOWN_FIRST = "//select[@class='form-select']";
    private static final String THIRD_OPTION_IN_FIRST_DROPDOWN =
            "//select[@class='form-select']/option[text()='Two']";
    private static final String DROPDOWN_SECOND = "//input[@name='my-datalist']";
    private static final String THIRD_OPTION_IN_SECOND_DROPDOWN =
            "//datalist[@id='my-options']/option[@value='Seattle']";

    public static final String CHECK_BOX_XPATH = "//input[@id='my-check-2']";
    public static final String RADIO_BUTTON = "//input[@id='my-radio-2']";
    public static final String BUTTON = "//button[@type='submit']";
    public static final String FORM_SUBMITTED = "//h1[@class='display-6']";

    public void openWebFormPage(){
        openUrl(URL_WEB_FORM_PAGE);
    }
    // ввели данные
    public void setInputName(){
        sendKeys(By.xpath(TEXT_INPUT_XPATH), "Королева Светлана Игоревна");
    }
    public void setInputPassword(){
        sendKeys(By.xpath(PASSWORD_XPATH), "Password");
    }
    public void setInputNameOfCompany(){
        sendKeys(By.xpath(TEXTAREA_XPATH), "Без границ");
    }
    // проверили отображение данных
    public boolean isTextDisplayedInTextInput(String textInput){
        return isElementDisplay(By.xpath(String.format(TEXT_INPUT_XPATH,textInput)));
    }
    public boolean isTextDisplayedInPassword(String textInput) {
        return isElementDisplay(By.xpath(PASSWORD_XPATH));
    }
    public boolean isTextDisplayedInTextArea(String textInput) {
        return isElementDisplay(By.xpath(TEXTAREA_XPATH));
    }

    // кликнули на первый дропдоун
    public void clickFirstDropDown(){
        click(By.xpath(DROPDOWN_FIRST));
    }
    // выбрали нужное значение в нем
    public void setThirdOptionInFirstDropdown(){
        click(By.xpath(THIRD_OPTION_IN_FIRST_DROPDOWN));
    }
    // кликнули на второй дропдоун
    public void clickSecondDropDown(){
        click(By.xpath(DROPDOWN_SECOND));
    }
    // выбрали нужное значение в нем
    public void setThirdOptionInSecondDropdown() {
        click(By.xpath(THIRD_OPTION_IN_SECOND_DROPDOWN));
    }
    public boolean getCheckBoxState() {
        return findElement(By.xpath(CHECK_BOX_XPATH)).isSelected();
    }

    public void setCheckBox(boolean state) {
        if (getCheckBoxState() != state) {
            click(By.xpath(CHECK_BOX_XPATH));
        }
    }
    public void setSecondRadioButton() {
        if (!isRadioButtonSelected()) {
            click(By.xpath(RADIO_BUTTON));
        }
    }
    public boolean isRadioButtonSelected(){
        return findElement(By.xpath(RADIO_BUTTON)).isSelected();
    }
    public void clickButton() {
        findElement(By.xpath(BUTTON)).click();
    }
    public boolean isTextDyspaly(String stringName){
        return isElementDisplay(By.xpath(FORM_SUBMITTED));
    }
}

