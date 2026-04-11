package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

public class HomeEnergyTest extends BaseTest {

    @Test
    public void fullFlowTest() {

        setup();

        HomePage home = new HomePage(driver);
        ServicePage service = new ServicePage(driver);
        AssessmentPage assess = new AssessmentPage(driver);
        BookingPage booking = new BookingPage(driver);
        PopupPage popup = new PopupPage(driver);

        // Step 1
        home.clickOurServices();

        // Step 2
        service.openFlow();

        // Step 3

        assess.fillStepOne();
        assess.clickNext();

        Assert.assertTrue(assess.verifyText());

        // Step 4
        popup.closePopup();
        assess.clickNext();

        // Step 5
        booking.fillForm("Abdullah", "Al Ahad", "test@mail.com", "01700000000");
        booking.selectAddress();
        booking.clickNext();

        // Step 6 (Date & Time logic)
        booking.selectDate();
        booking.selectTimeSlot();

        // Step 7
        popup.closePopup();

        // Step 8
        Assert.assertTrue(popup.verifyEmail("test@mail.com"));

        tearDown();
    }
}