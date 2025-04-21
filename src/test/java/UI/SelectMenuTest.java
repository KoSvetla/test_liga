package UI;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.demoqa.CheckBoxPage;
import pages.demoqa.SelectMenuPage;

public class SelectMenuTest extends BaseTest {
    private SelectMenuPage selectMenuPage;

    @BeforeClass
    public void beforeClass(){
        selectMenuPage = new SelectMenuPage(driver);
    }
    @Test
    public void step_01(){
        selectMenuPage.openSelectMenuPage();
        Assert.assertEquals(selectMenuPage.getPageName(), "Select Menu");
    }
    @Test
    public void step_02(){
        selectMenuPage.openFirstDropdown();
        selectMenuPage.selectSecondValue();
        Assert.assertTrue(selectMenuPage.isResultSelectDisplayed());

    }
}


