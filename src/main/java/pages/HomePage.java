package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    By ourServices = By.xpath("//a[contains(text(),'Our Services')]");

    public void clickOurServices() {
        driver.findElement(ourServices).click();
    }
}