package PageObjects.Railway;

import common.Constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ChangePassword extends GeneralPage {

    //    locators
    private final By _currentPasswordInput = By.xpath("//input[@id='currentPassword']");
    private final By _newPasswordInput = By.xpath("//input[@id='newPassword']");
    private final By _confirmPasswordInput = By.xpath("//input[@id='confirmPassword']");
    private final By _btnChangePassword = By.xpath("//input[@value='Change Password']");

    //elements
    public WebElement getCurrentPassword() {
        return Constant.WEBDRIVER.findElement(_currentPasswordInput);
    }
    public WebElement getNewPassword() {
        return Constant.WEBDRIVER.findElement(_newPasswordInput);
    }
    public WebElement getConfirmPassword() {
        return Constant.WEBDRIVER.findElement(_confirmPasswordInput);
    }
    public WebElement getBtnChangePassword() {
        return Constant.WEBDRIVER.findElement(_btnChangePassword);
    }

    //methods
    public ChangePassword changePassword (String currentPassword,String newPassword, String confirmPassword) {
        WebDriverWait wait = new WebDriverWait(Constant.WEBDRIVER, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOfElementLocated(_currentPasswordInput));
        this.getCurrentPassword().sendKeys(currentPassword);
        this.getNewPassword().sendKeys(newPassword);
        this.getConfirmPassword().sendKeys(confirmPassword);
        this.getBtnChangePassword().click();
        return new ChangePassword();
    }
}