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

    // popup container (open state)
    By popup = By.xpath("//div[contains(@class,'app-modal') and contains(@class,'open')]");

    // correct close button
    By closeBtn = By.xpath(
            "//div[contains(@class,'app-modal') and contains(@class,'open')]//button[contains(@class,'app-modal-close')]");

    By laterBtn = By.xpath("//button[contains(text(),'Later')]");

    By modal = By.cssSelector(".app-modal-body");
    By emailText = By.xpath("//p[contains(text(),'quote to:')]//strong");
    By closeBtn1 = By.cssSelector(".app-modal-close");

    public void closePopupIfPresent() {

        try {
            // popup visible
            wait.until(ExpectedConditions.visibilityOfElementLocated(popup));

            // first try "Later" button
            try {
                driver.findElement(laterBtn).click();
            } catch (Exception ignored) {
            }

            // then close icon
            WebElement close = wait.until(ExpectedConditions.elementToBeClickable(closeBtn));
            close.click();

            // wait until popup gone
            wait.until(ExpectedConditions.invisibilityOfElementLocated(popup));

        } catch (Exception e) {
            System.out.println("No popup found");
        }
    }

    public String getEmailFromPopup() {

        WebElement modalElement = wait.until(
                ExpectedConditions.visibilityOfElementLocated(modal));

        WebElement email = wait.until(
                ExpectedConditions.visibilityOfElementLocated(emailText));

        return email.getText().trim();
    }

    public void closePopup() {

        try {
            WebElement btn = wait.until(
                    ExpectedConditions.elementToBeClickable(closeBtn1));
            btn.click();
        } catch (Exception e) {
            ((JavascriptExecutor) driver).executeScript(
                    "arguments[0].click();",
                    driver.findElement(closeBtn1));
        }
    }

}