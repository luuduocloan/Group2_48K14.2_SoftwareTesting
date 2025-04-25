package Railway;

import common.Constant.Constant;
import org.testng.Assert;
import org.testng.annotations.Test;
import PageObjects.Railway.HomePage;
import PageObjects.Railway.LoginPage;

public class TestCase03 extends Preparation {

    @Test
    public void TC03() {
        System.out.println("TC03 - User can't login with invalid 'password'");
        HomePage homePage = new HomePage().open();

        LoginPage loginPage = homePage.gotoLoginPage();
        String actualMsg = loginPage.login(Constant.USERNAME, "123").getErrorMassage().trim();
        String expectedMsg =  "There was a problem with your login and/or errors exist in your form.";
        Assert.assertEquals(actualMsg, expectedMsg, "Error message is not displayed as expected.");
    }
}