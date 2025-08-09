package testcases;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.P00_HomePage;
import pages.P01_DetailsPage;
import pages.P02_ReservationPage;
import static drivers.DriverHolder.getDriver;
import static pages.BasePage.captureScreenshot;
import static pages.P02_ReservationPage.*;
import static util.Utlity.getExcelData;
public class TC_CompleteReservation extends BaseTest {

    @Test(priority = 1, description = "Configure search options and navigate to hotel details")
    public void configureSearchAndSelectHotel() {
        String location = getExcelData(0, 0, "data");
        String targetMonthCheckIndate = getExcelData(1, 0, "data");
        String dataDateCheckIndate = getExcelData(2, 0, "data");
        String targetMonthCheckOutdate = getExcelData(3, 0, "data");
        String dataDateCheckOutdate = getExcelData(4, 0, "data");

        new P00_HomePage(getDriver())
                .addLocation(location)
                .clickOnDatePickerButton()
                .selectDate(targetMonthCheckIndate, dataDateCheckIndate)
                .selectDate(targetMonthCheckOutdate, dataDateCheckOutdate)
                .clickOnSearchButton()
                .clickOnAvailabilityButton();
    }
    @Test(priority = 2, description = "Select room options and complete reservation",
            dependsOnMethods = "configureSearchAndSelectHotel")
    public void selectRoomAndReserve() {
        new P01_DetailsPage(getDriver())
                .selectBeds()
                .getRoomsAmountDropdown("1   (EGP 77,277)")
                .reserveOrder();
    }
    @Test(priority = 3, description = "details page",
            dependsOnMethods = "selectRoomAndReserve")
    public void validateDetails() {
        new P02_ReservationPage(getDriver())
                .verifyHotelName().checkInDate().checkOutDate();
        captureScreenshot(getDriver(), "Reservation Details");
        Assert.assertEquals(actual_HotelName, expected_HotelName, "Text does not match!");
        Assert.assertEquals(actual_CheckInDate, expected_CheckInDate, "Text does not match!");
        Assert.assertEquals(actual_CheckOutDate, expected_CheckoutDate, "Text does not match!");
    }
}