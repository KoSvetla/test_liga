package UI;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.demoqa.TextBoxPage;

public class TextBoxTest extends BaseTest {
    private TextBoxPage textBoxPage;

    @BeforeClass
    public void beforeClass(){
        textBoxPage = new TextBoxPage(driver);
    }

    @Test
    public void setup_01(){
        textBoxPage.openTextBoxPage();
        Assert.assertEquals(textBoxPage.getPageName(), "Text Box");
    }
    @Test
    public void step_02(){
        textBoxPage.setInputFullName();
        textBoxPage.setInputEmail();
        textBoxPage.setCurrentAddress();
        textBoxPage.setPermanentAddress();
        textBoxPage.clickButton();
        String name = textBoxPage.getName();
        String email = textBoxPage.getEmail();
        String currentAddress = textBoxPage.getCurrentAddress();
        String permanentAddress = textBoxPage.getPermanentAddress();

        Assert.assertTrue(name.contains("Svetlana"), "message");
        Assert.assertEquals(email, "Email:sveta51151378@yandex.ru");
        Assert.assertEquals(currentAddress, "Current Address :Kursk");
        Assert.assertEquals(permanentAddress, "Permananet Address :Kursk");
    }
}
