package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;
import java.io.File;
import java.time.Duration;

public class AssessmentPage {

    WebDriver driver;
    WebDriverWait wait;

    public AssessmentPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    //  Stable locators
    By semiDetached = By.xpath("//label[@for='houseType_5']");
    By twoStoreys = By.xpath("//input[@name='noOfStoreys' and @value='2']/parent::label");
    By existingYes = By.xpath("//input[@name='hasExistingExtension' and @value='true']/parent::label");
    By addExtNo = By.xpath("//input[@name='hasExtension' and @value='false']/parent::label");
    By photoCheckbox = By.xpath("//input[@name='noPhotoChecked']");
    By upload = By.id("image-upload");
    By nextBtn = By.xpath("//button[text()='Next']");
    By assertText = By.xpath("//*[contains(text(),'warm, comfortable, and healthy home')]");
    // By nextBtn2 = By.xpath("//*[@id=\"chs_question_next\"]");

    //  Smart Click (handles scroll + overlay + wait)
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

    //  Fill Step 1
    public void fillStepOne() {

        smartClick(semiDetached);
        smartClick(twoStoreys);
        smartClick(existingYes);
        smartClick(addExtNo);

        // Checkbox uncheck
        WebElement checkbox = wait.until(ExpectedConditions.presenceOfElementLocated(photoCheckbox));

        if (checkbox.isSelected()) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", checkbox);
        }

        // wait until enabled
        WebElement uploadInput = wait.until(driver -> {
            WebElement el = driver.findElement(upload);
            return el.isEnabled() ? el : null;
        });

        // remove hidden/disabled
        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].removeAttribute('disabled'); arguments[0].style.display='block';",
                uploadInput);

        // upload
        File file = new File("C:\\Users\\user\\Downloads\\test.jpg");
        uploadInput.sendKeys(file.getAbsolutePath());

        wait.until(ExpectedConditions.invisibilityOfElementLocated(
                By.cssSelector(".loading,.spinner")));
    }

    public void clickNext() {
        smartClick(nextBtn);
    }

    public boolean verifyText() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(assertText)).isDisplayed();
    }

}