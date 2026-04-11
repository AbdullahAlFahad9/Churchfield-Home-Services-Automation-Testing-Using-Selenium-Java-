package pages;

import org.openqa.selenium.*;
import java.io.File;

public class AssessmentPage {

    WebDriver driver;

    public AssessmentPage(WebDriver driver) {
        this.driver = driver;
    }

    // ✅ Stable locators (NOT deep XPath)
    By semiDetached = By
            .xpath("//*[@id=\"tab-header\"]/div[2]/div/div/form/div[1]/div[7]/label/span");
    By twoStoreys = By.xpath("/html/body/div[1]/div[5]/div[2]/div/div/form/div[3]/div[1]/div[1]/div/div[2]/label/span");
    By existingYes = By
            .xpath("//*[@id=\"tab-header\"]/div[2]/div/div/form/div[3]/div[1]/div[2]/div[1]/div[1]/label/span");
    By addExtNo = By
            .xpath("(//*[@id=\"tab-header\"]/div[2]/div/div/form/div[3]/div[1]/div[3]/div[1]/div[2]/label/span");

    By photoCheckbox = By.xpath("/html/body/div[1]/div[5]/div[2]/div/div/form/div[3]/div[2]/div/div[3]/label/span");
    By upload = By.xpath("//input[@type='file']");
    By nextBtn = By.xpath("//button[text()='Next']");
    By assertText = By.xpath("//*[contains(text(),'warm, comfortable, and healthy home')]");

    // 🔥 Scroll + Click method
    public void scrollAndClick(By locator) {
        WebElement element = driver.findElement(locator);

        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].scrollIntoView({block: 'center'});", element);

        element.click();
    }

    // 🔥 Fill Step 1
    public void fillStepOne() {

        scrollAndClick(semiDetached);
        scrollAndClick(twoStoreys);
        scrollAndClick(existingYes);
        scrollAndClick(addExtNo);

        // Checkbox logic (correct)
        WebElement checkbox = driver.findElement(photoCheckbox);
        if (checkbox.isSelected()) {
            checkbox.click();
        }

        // File upload (must use real path)
        File file = new File("C:\\Users\\user\\Downloads\\test.jpg");
        driver.findElement(upload).sendKeys(file.getAbsolutePath());
    }

    public void clickNext() {
        scrollAndClick(nextBtn);
    }

    public boolean verifyText() {
        return driver.findElement(assertText).isDisplayed();
    }
}