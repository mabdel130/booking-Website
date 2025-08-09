package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class P02_ReservationPage extends BasePage {
    public P02_ReservationPage(WebDriver driver) {
        super(driver);
    }

    private final By hotelNameElement = By.xpath("//h1[normalize-space()='Tolip Hotel Alexandria']");
    private final By checkInDate = By.xpath("(//div[@class=\"e7addce19e b59b83e0da\"])[1]");
    private final By checkoutDate = By.xpath("(//div[@class=\"e7addce19e b59b83e0da\"])[2]");
    public static String expected_HotelName = "Tolip Hotel Alexandria";
    public static String expected_CheckInDate = "Wed, Oct 1, 2025";
    public static String expected_CheckoutDate = "Tue, Oct 14, 2025";
    public static String actual_CheckOutDate;
    public static String actual_CheckInDate;
    public static String actual_HotelName;

    public P02_ReservationPage verifyHotelName() {
        actual_HotelName = longWait(driver).until(ExpectedConditions.visibilityOfElementLocated((hotelNameElement))).getText();
        return new P02_ReservationPage(driver);
    }

    public P02_ReservationPage checkInDate() {
        actual_CheckInDate = longWait(driver).until(ExpectedConditions.visibilityOfElementLocated((checkInDate))).getText();
        return new P02_ReservationPage(driver);

    }

    public P02_ReservationPage checkOutDate() {
        actual_CheckOutDate = longWait(driver).until(ExpectedConditions.visibilityOfElementLocated((checkoutDate))).getText();
        return new P02_ReservationPage(driver);
    }
}
