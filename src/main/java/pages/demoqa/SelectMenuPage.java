package pages.demoqa;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.base.BasePage;

public class SelectMenuPage extends BasePage {

    public SelectMenuPage(WebDriver driver) {
        super(driver);
    }
    private static final String URL_SELECT_MENU_PAGE = "https://demoqa.com/select-menu";
    public static final String DROPDOWN_FIRST_FIELD = "//div[@id='withOptGroup']/div";
    public static final String DROPDOWN_SECOND_OPTION_IN_FIRST_FIELD = "//div[contains(text(),'Group 1, option 2')]";

    private static final String DROPDOWN_FIRST_FIELD_VALUE = "//div[contains(@class,'singleValue')]";

    public void openSelectMenuPage(){
        openUrl(URL_SELECT_MENU_PAGE);
    }
    public void openFirstDropdown(){
        findElement(By.xpath(DROPDOWN_FIRST_FIELD)).click();
    }
    public void selectSecondValue(){
        findElement(By.xpath(DROPDOWN_SECOND_OPTION_IN_FIRST_FIELD)).click();
    }
    public boolean isResultSelectDisplayed(){
        return isElementDisplay(By.xpath(DROPDOWN_SECOND_OPTION_IN_FIRST_FIELD));
    }
}
