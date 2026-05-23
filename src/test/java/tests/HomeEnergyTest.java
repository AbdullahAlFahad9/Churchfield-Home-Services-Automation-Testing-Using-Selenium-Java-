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
        SchedulePage schedule = new SchedulePage(driver);
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
        assess.clickNext();

        // Step 5
        // popup.closePopupIfPresent();
        booking.fillForm("Abdullah", "Al Fahad", "test@mail.com", "01700000000");
        booking.selectAddress();
        booking.clickNext();

        // Step 6 (Date & Time logic)
        schedule.selectAvailableDate();
        schedule.selectTimeSlot();
        schedule.clickNext();
        schedule.clickLater();
        // Step 7
        // popup.closePopupIfPresent();

        // Step 8

        String actualEmail = popup.getEmailFromPopup();

        Assert.assertTrue(actualEmail.contains("test@mail.com"));

        popup.closePopup();
        tearDown();
    }
}