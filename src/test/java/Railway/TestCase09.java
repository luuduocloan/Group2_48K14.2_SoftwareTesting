package Railway;

import common.Constant.Constant;
import org.testng.Assert;
import org.testng.annotations.Test;
import PageObjects.Railway.ChangePassword;
import PageObjects.Railway.HomePage;
import PageObjects.Railway.LoginPage;

public class TestCase09 extends Preparation {

    @Test
    public void TC09() {
        System.out.println("User can change password");
        HomePage homePage = new HomePage().open();

        LoginPage loginPage = homePage.gotoLoginPage();
        loginPage.login(Constant.USERNAME,Constant.PASSWORD);

        ChangePassword changePassword  = loginPage.goToChangePassWord();
        String actualMsg = changePassword.changePassword("0987654321","0987654321","0987654321").getChangePasswordMsg();
        String expectedMsg =  "Your password has been updated!";
        Assert.assertEquals(actualMsg, expectedMsg, "Error message is not displayed as expected.");
    }
}