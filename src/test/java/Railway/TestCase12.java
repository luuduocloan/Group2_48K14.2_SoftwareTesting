package Railway;

import org.testng.annotations.Test;
import PageObjects.Railway.ForgotPassword;
import PageObjects.Railway.HomePage;
import PageObjects.Railway.LoginPage;

public class TestCase12 extends Preparation {

    @Test
    public void TC12() {
        System.out.println("Errors display when password reset token is blank");
        HomePage homePage = new HomePage().open();
        LoginPage loginPage = homePage.gotoLoginPage();
        ForgotPassword forgotPassword = loginPage.goToForgotPasswordPage();
        forgotPassword.forgotPassword("nhom2@gmail.com");
    }
}