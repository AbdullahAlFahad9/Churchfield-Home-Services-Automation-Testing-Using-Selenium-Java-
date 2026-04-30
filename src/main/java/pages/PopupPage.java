package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;

public class PopupPage {

    WebDriver driver;
    WebDriverWait wait;

    public PopupPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // ✅ popup container (open state)
    By popup = By.xpath("//div[contains(@class,'app-modal') and contains(@class,'open')]");

    // ✅ correct close button
    By closeBtn = By.xpath(
            "//div[contains(@class,'app-modal') and contains(@class,'open')]//button[contains(@class,'app-modal-close')]");

    By laterBtn = By.xpath("//button[contains(text(),'Later')]");
    By emailText = By.xpath("//*[contains(text(),'@')]");

    public void closePopupIfPresent() {

        try {
            // popup visible হলে
            wait.until(ExpectedConditions.visibilityOfElementLocated(popup));

            // 🔥 first try "Later" button
            try {
                driver.findElement(laterBtn).click();
            } catch (Exception ignored) {
            }

            // 🔥 then close icon
            WebElement close = wait.until(ExpectedConditions.elementToBeClickable(closeBtn));
            close.click();

            // 🔥 wait until popup gone
            wait.until(ExpectedConditions.invisibilityOfElementLocated(popup));

        } catch (Exception e) {
            System.out.println("No popup found");
        }
    }

    public boolean verifyEmail(String email) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(emailText))
                .getText().contains(email);
    }
}