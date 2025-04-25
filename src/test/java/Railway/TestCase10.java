package Railway;

import org.testng.Assert;
import org.testng.annotations.Test;
import PageObjects.Railway.HomePage;
import PageObjects.Railway.RegisterPage;

public class TestCase10 extends Preparation{

    @Test
    public void TC10() {
        System.out.println("User can't create account with 'Confirm password' is not the same with 'Password'");
        HomePage homePage = new HomePage().open();
        RegisterPage registerPage = homePage.gotoRegisterPage();

        String actualMsg = registerPage.register("meomeo@gmail.com","12345678","87654321","12345678").getErrorConfirmPasswordMsg();
        String expectedMsg =  "There're errors in the form. Please correct the errors and try again.";
        Assert.assertEquals(actualMsg, expectedMsg, "Error message is not displayed as expected.");
    }
}