package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import java.util.List;

public class BookingPage {
    WebDriver driver;

    public BookingPage(WebDriver driver) {
        this.driver = driver;
    }

    By firstName = By.name("firstName");
    By lastName = By.name("lastName");
    By email = By.name("email");
    By mobile = By.name("mobile");
    By address = By.xpath("//input[contains(@placeholder,'Property Address')]");
    By nextBtn = By.xpath("//button[text()='Next']");

    public void fillForm(String fn, String ln, String em, String mob) {
        driver.findElement(firstName).sendKeys(fn);
        driver.findElement(lastName).sendKeys(ln);
        driver.findElement(email).sendKeys(em);
        driver.findElement(mobile).sendKeys(mob);
    }

    public void selectAddress() {
        driver.findElement(address).sendKeys("Dublin");
        driver.findElement(address).sendKeys(Keys.ENTER);
    }

    public void clickNext() {
        driver.findElement(nextBtn).click();
    }

    // 🔥 DATE LOGIC (IMPORTANT INTERVIEW PART)
    public void selectDate() {

        List<org.openqa.selenium.WebElement> dates = driver.findElements(By.cssSelector(".available-date"));

        if (dates.size() > 0) {
            dates.get(0).click();
        } else {
            driver.findElement(By.xpath("//button[contains(@aria-label,'Next month')]")).click();

            List<org.openqa.selenium.WebElement> nextDates = driver.findElements(By.cssSelector(".available-date"));

            if (nextDates.size() > 0) {
                nextDates.get(0).click();
            }
        }
    }

    public void selectTimeSlot() {
        List<org.openqa.selenium.WebElement> slots = driver.findElements(By.cssSelector(".time-slot"));

        if (!slots.isEmpty()) {
            slots.get(0).click(); // morning or afternoon
        }
    }
}