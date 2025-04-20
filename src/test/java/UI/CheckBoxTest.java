package UI;

import browser.Browser;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.demoqa.CheckBoxPage;

public class CheckBoxTest {
    WebDriver driver;
    // импортируем экземпляр страницы
    private CheckBoxPage checkBoxPage;

    @BeforeClass
    // инициализируем драйвер
    public void setup(){
        driver = Browser.createDriver();
        checkBoxPage = new CheckBoxPage(driver);
    }
    @Test
    public void step_01(){
        checkBoxPage.openCheckBoxPage();
        Assert.assertEquals(checkBoxPage.getPageName(), "Check Box");
    }
    @Test
    public void step_02(){
        checkBoxPage.openListCheckBox("Home");
        checkBoxPage.setCheckBox("Desktop", true);
        Assert.assertTrue(checkBoxPage.getCheckBoxState("Desktop"));
    }

}
