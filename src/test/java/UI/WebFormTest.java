package UI;

import base.BaseTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.demoqa.WebFormPage;

public class WebFormTest extends BaseTest {
    private WebFormPage webFormPage;

    @BeforeClass
    public void beforeClass(){
        webFormPage = new WebFormPage(driver);
    }

    @Test
    public void step_01(){
        webFormPage.openWebFormPage();
    }

    @Test
    public void step_02(){
        webFormPage.setInputName();
        webFormPage.setInputPassword();
        webFormPage.setInputNameOfCompany();
        webFormPage.isTextDisplayedInTextInput("Королева Светлана Игоревна");
        webFormPage.isTextDisplayedInPassword("Password");
        webFormPage.isTextDisplayedInTextArea("Без границ");
    }
    @Test
    public void step_03(){
        webFormPage.clickFirstDropDown();
        webFormPage.setThirdOptionInFirstDropdown();
        webFormPage.clickSecondDropDown();
        webFormPage.setThirdOptionInSecondDropdown();
        webFormPage.setCheckBox(true);
        webFormPage.setSecondRadioButton();
        webFormPage.clickButton();
    }
}

