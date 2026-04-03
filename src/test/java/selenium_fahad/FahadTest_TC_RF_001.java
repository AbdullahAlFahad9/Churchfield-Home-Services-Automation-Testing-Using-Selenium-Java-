package selenium_fahad;

import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FahadTest_TC_RF_001 {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(java.time.Duration.ofSeconds(30));
        driver.manage().window().maximize();
    }

    @Test
    public void registerTest() {
        driver.get("https://tutorialsninja.com/demo/");
        driver.findElement(By.xpath("//span[text()='My Account']")).click();
        driver.findElement(By.linkText("Register")).click();

        driver.findElement(By.name("firstname")).sendKeys("Abdullah Al");
        driver.findElement(By.name("lastname")).sendKeys("Fahad");
        driver.findElement(By.name("email")).sendKeys(generateEmail());
        driver.findElement(By.name("telephone")).sendKeys("01700000000");
        driver.findElement(By.name("password")).sendKeys("12345678");
        driver.findElement(By.name("confirm")).sendKeys("12345678");

        driver.findElement(By.name("agree")).click();
        driver.findElement(By.xpath("//input[@value='Continue']")).click();

        Assert.assertTrue(driver.findElement(By.linkText("Logout")).isDisplayed());

        String expectedHeading = "Your Account Has Been Created!";
        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='content']//h1")).getText(), expectedHeading);

        String actualProperDetails1 = "Congratulations! Your new account has been successfully created!";
        String actualProperDetails2 = "You can now take advantage of member privileges to enhance your online shopping experience with us.";
        String actualProperDetails3 = "If you have ANY questions about the operation of this online shop, please e-mail the store owner.";
        String actualProperDetails4 = "A confirmation has been sent to the provided e-mail address. If you have not received it within the hour, please contact us.";

        String expectedProperDetails = driver.findElement(By.id("content")).getText();

        Assert.assertTrue(expectedProperDetails.contains(actualProperDetails1));
        Assert.assertTrue(expectedProperDetails.contains(actualProperDetails2));
        Assert.assertTrue(expectedProperDetails.contains(actualProperDetails3));
        Assert.assertTrue(expectedProperDetails.contains(actualProperDetails4));

        driver.findElement(By.xpath("//a[text()='Continue']")).click();
        Assert.assertTrue(driver.findElement(By.linkText("Edit your account information")).isDisplayed());
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    public String generateEmail() {
        return new Date().toString().replaceAll("\\s", "").replaceAll(":", "") + "@gmail.com";
    }
}