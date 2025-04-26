package Railway;

import common.Constant.Constant;
import org.openqa.selenium.Dimension;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import PageObjects.Railway.ChangePassword;
import PageObjects.Railway.HomePage;
import PageObjects.Railway.LoginPage;
import PageObjects.Railway.MyTicket;

//Thêm bỏ qua test
public class TestCase06 extends Preparation {
    @Test
    public void TC06() {
        System.out.println("Additional pages display once user logged in");

        SoftAssert softAssert = new SoftAssert();
        HomePage homePage = new HomePage().open();

        LoginPage loginPage = homePage.gotoLoginPage();
        loginPage.login(Constant.USERNAME, Constant.PASSWORD);

        softAssert.assertEquals(loginPage.getTicketPriceTabText(), "Ticket price", "Ticket tab price not display");
        softAssert.assertEquals(loginPage.getMyTicketTabText(), "My ticket", "Book ticket tab not display");
        softAssert.assertEquals(loginPage.getLogoutTabText(), "Logout", "logout tab not display");
        MyTicket myTicket = loginPage.goToMyTicket();
        softAssert.assertEquals(myTicket.getPageTitleText(), "Manage Tickets", "Message is not displayed as expected.");
        ChangePassword changePassword = loginPage.goToChangePassWord();
        softAssert.assertEquals(changePassword.getPageTitleText(), "Change password", "Message is not displayed as expected.");
        softAssert.assertAll();
    }
}