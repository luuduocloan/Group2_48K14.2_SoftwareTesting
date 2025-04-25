package common.Common;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class Untilities {
    // Chụp màn hình lưu vào thư mục "screenshots"
    public static void takeScreenshot(WebDriver driver, String fileName) {
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File destFile = new File("screenshots/" + fileName + ".png");
        try {
            Files.copy(screenshot.toPath(), destFile.toPath());
            System.out.println("Đã chụp màn hình: " + destFile.getAbsolutePath());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
//hộp công cụ chứa các hàm tiện ích dùng chung, chứa các hàm helper class
//Có thể chứa các hàm như:
//Chụp màn hình (screenshot)
//Chờ đợi phần tử (wait)
//Tạo dữ liệu giả (random email, số điện thoại…)
//Đọc/ghi file Excel
//Xử lý thời gian, chuyển đổi dữ liệu,...