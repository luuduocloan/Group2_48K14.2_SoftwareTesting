package PageObjects.Railway;

import common.Constant.Constant;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MyTicket extends GeneralPage {

    //locators
    private final By _btnMyTicket = By.xpath("//div[@id='menu']//a[@href='/Page/ManageTicket.cshtml']");
    private final By cancelButtonElements = By.xpath("//input[@value='Cancel']");

    //elements
    public WebElement getBtnMyTicket() {
        return Constant.WEBDRIVER.findElement(_btnMyTicket);
    }

    public List<WebElement> getCancelButtons() {
        return Constant.WEBDRIVER.findElements(cancelButtonElements);
    }

    //methods:
    // Open "My Ticket" page
    public MyTicket myTicket() {
        this.getBtnMyTicket().click();

        WebDriverWait wait = new WebDriverWait(Constant.WEBDRIVER, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@value='Cancel']")));

        return new MyTicket();
    }

    // Get list of IDs from Cancel buttons
    public List<String> getIds() {
        List<WebElement> cancelButtons = getCancelButtons();
        List<String> ids = new ArrayList<>();
        for (WebElement button : cancelButtons) {
            String onClickValue = button.getAttribute("onclick");
            if (onClickValue != null) {
                String id = onClickValue.replaceAll("\\D+", "");
                ids.add(id);
            }
        }
        return ids;
    }

    // Get a random ticket ID from the list
    public String getAnRandomId() {
        Random random = new Random();
        List<String> ids = getIds();
        // Lấy một chỉ số ngẫu nhiên trong phạm vi kích thước của danh sách
        int randomIndex = random.nextInt(ids.size());
        return ids.get(randomIndex);
    }

    // Cancel a ticket by ID
    public MyTicket cancelTicketWithId(String id) {
        WebElement cancelButton = Constant.WEBDRIVER.findElement(By.xpath("//input[@value='Cancel' and contains(@onclick, 'DeleteTicket(" + id + ")')]"));
        JavascriptExecutor js = (JavascriptExecutor) Constant.WEBDRIVER;
        js.executeScript("arguments[0].scrollIntoView(true);", cancelButton);
        cancelButton.click();
        Alert alert = Constant.WEBDRIVER.switchTo().alert();
        alert.accept();
        return new MyTicket();
    }
}