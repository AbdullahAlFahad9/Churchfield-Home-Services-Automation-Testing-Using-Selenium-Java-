package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ServicePage {
    WebDriver driver;

    public ServicePage(WebDriver driver) {
        this.driver = driver;
    }

    By homeEnergy = By.xpath("//*[@id=\"__next\"]/header/div[2]/div[2]/div/div/div[2]/div/div/a[2]/div[1]/img");
    By bookNow = By.linkText("Book your Home Energy Assessment");

    public void openFlow() {
        driver.findElement(homeEnergy).click();
        driver.findElement(bookNow).click();
    }
}