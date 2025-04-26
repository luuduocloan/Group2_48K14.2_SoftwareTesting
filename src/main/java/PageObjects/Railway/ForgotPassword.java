package PageObjects.Railway;

import common.Constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ForgotPassword {

    //locators
    private final By _txtEmailAddress = By.xpath("//input[@id='email']");
    private final By _btnSendInstruction = By.xpath("//input[@value='Send Instructions']");

    //elements
    public WebElement getTxtEmailAddress() {
        return Constant.WEBDRIVER.findElement(_txtEmailAddress);
    }

    public WebElement getSendInstruction() {
        return Constant.WEBDRIVER.findElement(_btnSendInstruction);
    }

    //methods
    public ForgotPassword forgotPassword(String email) {
        this.getTxtEmailAddress().sendKeys(email);
        this.getSendInstruction().click();
        return new ForgotPassword();
    }
}