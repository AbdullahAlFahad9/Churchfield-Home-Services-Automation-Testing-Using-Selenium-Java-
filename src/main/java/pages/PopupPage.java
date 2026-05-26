package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;

public class PopupPage {

        WebDriver driver;
        WebDriverWait wait;

        public PopupPage(WebDriver driver) {

                this.driver = driver;
                this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        }

        // email text
        By emailText = By.xpath(
                        "//div[contains(@class,'app-modal-body')]//strong[contains(text(),'@')]");

        // close button
        By closeBtn = By.xpath(
                        "//button[contains(@class,'app-modal-close')]");

        // get popup email
        public String getEmailFromPopup() {

                // popup fully load wait
                wait.until(ExpectedConditions.presenceOfElementLocated(
                                By.xpath("//div[contains(@class,'app-modal-body')]")));

                // email visible wait
                WebElement email = wait.until(
                                ExpectedConditions.visibilityOfElementLocated(emailText));

                // scroll
                ((JavascriptExecutor) driver)
                                .executeScript("arguments[0].scrollIntoView(true);", email);

                String actualEmail = email.getText().trim();

                System.out.println("Popup Email: " + actualEmail);

                return actualEmail;
        }

        // close popup
        public void closePopup() {

                try {

                        // small wait
                        Thread.sleep(2000);

                        WebElement btn = driver.findElement(
                                        By.cssSelector("button.app-modal-close"));

                        // scroll
                        ((JavascriptExecutor) driver)
                                        .executeScript(
                                                        "arguments[0].scrollIntoView({block:'center'});",
                                                        btn);

                        // direct JS click
                        ((JavascriptExecutor) driver)
                                        .executeScript("arguments[0].click();", btn);

                        System.out.println("Popup Closed");

                } catch (Exception e) {

                        System.out.println("Popup close failed");
                }
        }
}