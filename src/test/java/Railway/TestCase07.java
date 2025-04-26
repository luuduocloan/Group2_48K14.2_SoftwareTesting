package Railway;

import org.testng.Assert;
import org.testng.annotations.Test;
import PageObjects.Railway.HomePage;
import PageObjects.Railway.RegisterPage;

public class TestCase07 extends Preparation {
    @Test
    public void TC07() {
        System.out.println("User can create new account");

        HomePage homePage = new HomePage().open();

        RegisterPage registerPage = homePage.gotoRegisterPage();

        String actualMsg = registerPage.register("ktkhongdauthuong@gmail.com", "testingnothuong", "testingnothuong", "123456789").getWelcomeRegisterMsg();
        String expectedMsg = "Thank you for registering your account";
        Assert.assertEquals(actualMsg, expectedMsg, "Error message is not displayed as expected.");
    }
}