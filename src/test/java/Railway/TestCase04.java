package Railway;

import org.testng.Assert;
import org.testng.annotations.Test;
import PageObjects.Railway.HomePage;

public class TestCase04 extends Preparation {

    @Test
    public void TC04() {
        System.out.println("Login page displays when un-logged User clicks on 'Book ticket' tab");
        HomePage homePage = new HomePage().open();

        String actualMsg = homePage.goToBookTicket().isLoginPage();
        String expectedMsg = "Login Page";
        Assert.assertEquals(actualMsg, expectedMsg, "Error message is not displayed as expected.");
    }
}