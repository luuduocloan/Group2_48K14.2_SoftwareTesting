package Railway;

import org.testng.annotations.Test;
import PageObjects.Railway.ForgotPassword;
import PageObjects.Railway.HomePage;
import PageObjects.Railway.LoginPage;

public class TestCase13 extends Preparation{

    @Test
    public void TC13() {
        System.out.println("Errors display if password and confirm password don't match when resetting password");
        HomePage homePage = new HomePage().open();
        LoginPage loginPage = homePage.gotoLoginPage();
        ForgotPassword forgotPassword = loginPage.goToForgotPasswordPage();
        forgotPassword.forgotPassword("nhom2@gmail.com");
    }
}