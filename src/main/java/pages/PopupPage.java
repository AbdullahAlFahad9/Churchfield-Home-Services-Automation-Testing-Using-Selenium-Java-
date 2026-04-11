package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PopupPage {
    WebDriver driver;

    public PopupPage(WebDriver driver) {
        this.driver = driver;
    }

    By laterBtn = By.xpath("//button[contains(text(),'Later')]");
    By emailText = By.xpath("//*[contains(text(),'@')]");

    public void closePopup() {
        try {
            driver.findElement(laterBtn).click();
        } catch (Exception e) {
            System.out.println("No popup found");
        }
    }

    public boolean verifyEmail(String email) {
        return driver.findElement(emailText).getText().contains(email);
    }
}