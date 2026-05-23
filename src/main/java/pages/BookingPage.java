package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import java.util.List;
import org.openqa.selenium.support.ui.*;
import java.time.Duration;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class BookingPage {
    WebDriver driver;

    WebDriverWait wait;

    public BookingPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    By firstName = By.xpath(
            "//button[@id='chs_contact_next']/ancestor::div[contains(@class,'max-w-6xl')]//input[@name='firstName']");
    By lastName = By.xpath(
            "//button[@id='chs_contact_next']/ancestor::div[contains(@class,'max-w-6xl')]//input[@name='lastName']");
    By email = By.xpath(
            "//button[@id='chs_contact_next']/ancestor::div[contains(@class,'max-w-6xl')]//input[@name='email']");
    By mobile = By.xpath(
            "//button[@id='chs_contact_next']/ancestor::div[contains(@class,'max-w-6xl')]//input[@name='phone']");
    By address = By.xpath(
            "//button[@id='chs_contact_next']/ancestor::div[contains(@class,'max-w-6xl')]//input[@name='searchText']");
    By nextBtn = By.xpath("//button[text()='Next']");

    public void smartType(By locator, String text) {

        WebElement element = wait.until(
                ExpectedConditions.elementToBeClickable(locator));

        // scroll (footer avoid)
        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].scrollIntoView({block:'center'});", element);

        try {
            element.click(); // important (focus)
            element.clear();
            element.sendKeys(text);
        } catch (Exception e) {
            ((JavascriptExecutor) driver)
                    .executeScript("arguments[0].value='" + text + "';", element);
        }
    }

    public void fillForm(String fn, String ln, String em, String mob) {

        // scroll hole page down
        ((JavascriptExecutor) driver)
                .executeScript("window.scrollBy(0,500);");

        smartType(firstName, fn);
        smartType(lastName, ln);
        smartType(email, em);
        smartType(mobile, mob);
    }

    public void selectAddress() {

        smartType(address, "Dublin");

        By dropdownItem = By.xpath("//li//span[contains(text(),'Dublin')]");

        // wait until visible
        WebElement item = wait.until(
                ExpectedConditions.visibilityOfElementLocated(dropdownItem));

        // small wait (animation finish)
        wait.until(ExpectedConditions.elementToBeClickable(item));

        // scroll to element
        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].scrollIntoView({block:'center'});", item);

        try {
            item.click();
        } catch (Exception e) {

            // fallback 1 → JS click

            ((JavascriptExecutor) driver)
                    .executeScript("arguments[0].click();", item);
        }
    }

    public void smartClick(By locator) {

        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].scrollIntoView({block:'center'});", element);

        try {
            wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
        } catch (Exception e) {
            // fallback → JS click
            ((JavascriptExecutor) driver)
                    .executeScript("arguments[0].click();", element);
        }
    }

    public void clickNext() {

        // wait until address full fill
        wait.until(ExpectedConditions.attributeToBeNotEmpty(
                driver.findElement(address), "value"));

        // optional: small stability wait
        wait.until(ExpectedConditions.invisibilityOfElementLocated(
                By.cssSelector(".loading, .spinner")));

        smartClick(nextBtn);
    }

    // DATE LOGIC (IMPORTANT INTERVIEW PART)
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