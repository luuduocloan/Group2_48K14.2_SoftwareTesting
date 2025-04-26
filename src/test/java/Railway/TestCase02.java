package Railway;

import common.Constant.Constant;
import org.openqa.selenium.Dimension;
import org.testng.Assert;
import org.testng.annotations.Test;
import PageObjects.Railway.HomePage;
import PageObjects.Railway.LoginPage;

public class TestCase02 extends Preparation {
    @Test
    public void TC02() {

        System.out.println("TC02 - User can't login with blank 'Username' textbox");
        HomePage homePage = new HomePage().open();
        LoginPage loginPage = homePage.gotoLoginPage();
        Constant.WEBDRIVER.manage().window().setSize(new Dimension(1024, 768));


        String actualMsg = loginPage.login("", Constant.PASSWORD).getErrorMassage();
        String expectedMsg = "There was a problem with your login and/or errors exist in your form.";
        Assert.assertEquals(actualMsg, expectedMsg, "Error message is not displayed as expected.");
    }
}