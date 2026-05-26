package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;
import java.util.List;

public class SchedulePage {

        WebDriver driver;
        WebDriverWait wait;

        public SchedulePage(WebDriver driver) {
                this.driver = driver;
                this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        }

        // Available dates
        By availableDates = By.xpath(
                        "//div[contains(@class,'day') and " +
                                        "contains(@class,'cursor-pointer') and " +
                                        "not(contains(@class,'disabled')) and " +
                                        "not(contains(@class,'full'))]");

        // Next month button
        By nextMonthBtn = By.xpath(
                        "(//div[contains(@class,'booking-calender')]//button[not(@disabled)])[2]");

        // Morning / Afternoon
        By timeSlots = By.xpath("//input[@name='selectTime']/parent::label");

        By morningSlot = By.xpath("//label[.//h5[text()='Morning']]");
        By afternoonSlot = By.xpath("//label[.//h5[text()='Afternoon']]");

        // Next button
        By nextBtn = By.id("chs_booking_next");

        // Later button
        By laterBtn = By.id("chs_pay_leter");

        // 12 & 13 → Select available date
        public void selectAvailableDate() {

                // Wait for calendar load
                wait.until(ExpectedConditions.visibilityOfElementLocated(
                                By.className("booking-calender")));

                // Small hard wait (UI render issue fix)
                try {
                        Thread.sleep(2000);
                } catch (InterruptedException e) {
                        e.printStackTrace();
                }

                // Scroll down to calendar
                ((JavascriptExecutor) driver)
                                .executeScript("window.scrollBy(0,600);");

                List<WebElement> dates = driver.findElements(availableDates);

                // Current month available
                if (!dates.isEmpty()) {

                        WebElement date = dates.get(0);

                        ((JavascriptExecutor) driver)
                                        .executeScript("arguments[0].scrollIntoView({block:'center'});", date);

                        wait.until(ExpectedConditions.elementToBeClickable(date))
                                        .click();

                } else {

                        // Go next month
                        WebElement nextBtn = wait.until(
                                        ExpectedConditions.elementToBeClickable(nextMonthBtn));

                        nextBtn.click();

                        // Wait next month load
                        try {
                                Thread.sleep(1500);
                        } catch (InterruptedException e) {
                                e.printStackTrace();
                        }

                        List<WebElement> nextMonthDates = wait.until(
                                        ExpectedConditions.numberOfElementsToBeMoreThan(
                                                        availableDates, 0));

                        WebElement date = dates.get(0);

                        ((JavascriptExecutor) driver)
                                        .executeScript("arguments[0].scrollIntoView({block:'center'});", date);

                        ((JavascriptExecutor) driver)
                                        .executeScript("arguments[0].click();", date);
                }
        }

        // 14 → Select morning/afternoon
        public void selectTimeSlot() {

                WebElement slot = wait.until(
                                ExpectedConditions.elementToBeClickable(
                                                By.xpath("//input[@name='selectTime']/parent::label")));

                ((JavascriptExecutor) driver)
                                .executeScript("arguments[0].scrollIntoView({block:'center'});", slot);

                try {
                        slot.click();
                } catch (Exception e) {
                        ((JavascriptExecutor) driver)
                                        .executeScript("arguments[0].click();", slot);
                }

        }

        public void clickNext() {

                WebElement btn = wait.until(ExpectedConditions.elementToBeClickable(nextBtn));

                btn.click();
        }

        // 15 → Click Later
        public void clickLater() {

                WebElement later = wait.until(ExpectedConditions.visibilityOfElementLocated(laterBtn));

                // scroll into view
                ((JavascriptExecutor) driver)
                                .executeScript("arguments[0].scrollIntoView({block:'center'});", later);

                // wait until clickable (VERY IMPORTANT)
                wait.until(ExpectedConditions.elementToBeClickable(laterBtn));

                try {
                        later.click();
                } catch (Exception e) {
                        ((JavascriptExecutor) driver)
                                        .executeScript("arguments[0].click();", later);
                }
        }
}