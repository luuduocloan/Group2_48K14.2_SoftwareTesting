package Railway;

import common.Constant.Constant;
import org.testng.Assert;
import org.testng.annotations.Test;
import PageObjects.Railway.HomePage;
import PageObjects.Railway.LoginPage;

public class TestCase05 extends Preparation {
    @Test
    public void TC05() {
        System.out.println("System shows message when user enters wrong password several times");
        HomePage homePage = new HomePage().open();

        LoginPage loginPage = homePage.gotoLoginPage();

        for (int i = 1; i <=3; i++) {
            loginPage.login(Constant.USERNAME,"123");
            loginPage.clearForm();
        }
        String actualMsg = loginPage.login(Constant.USERNAME,"12345").getErrorPassMsg();
        String expectedMsg = "You have used 4 out of 5 login attempts. After all 5 have been used, you will be unable to login for 15 minutes.";
        Assert.assertEquals(actualMsg,expectedMsg,"Error message is not displayed as expected.");

    }
}