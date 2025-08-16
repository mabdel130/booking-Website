package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class P00_HomePage extends BasePage {

    public P00_HomePage(WebDriver driver) {
        super(driver);
    }

    private final By locationField = By.xpath("//input[@name='ss']");
    private final By datePickerButton = By.cssSelector("button[data-testid='searchbox-dates-container']");
    private final By monthHeader = By.cssSelector("h3[aria-live='polite']");
    private final By nextMonthArrow = By.cssSelector("button[aria-label='Next month']");
    private final By searchButton = By.xpath("//span[normalize-space()='Search']");
    private final By availabilityButton=By.xpath("(//span[@class='ca2ca5203b'][normalize-space()='See availability'])[1]");
    public P00_HomePage addLocation(String location) {
        longWait(driver).until(ExpectedConditions.visibilityOfElementLocated(locationField)).sendKeys(location);
        return this;
    }

    public P00_HomePage clickOnDatePickerButton() {
        longWait(driver).until(ExpectedConditions.elementToBeClickable(datePickerButton)).click();
        return this;
    }

    public P00_HomePage selectDate(String targetMonth, String dataDate) {

        while (true) {
            WebElement header = longWait(driver).until(ExpectedConditions.visibilityOfElementLocated(monthHeader));
            if (header.getText().equals(targetMonth)) {
                break;
            }
            longWait(driver).until(ExpectedConditions.elementToBeClickable(nextMonthArrow)).click();
        }
        By dateCell = By.cssSelector("span[data-date='" + dataDate + "']");
        longWait(driver).until(ExpectedConditions.elementToBeClickable(dateCell)).click();
        return this;
    }

    public P00_HomePage clickOnSearchButton() {
        longWait(driver).until(ExpectedConditions.elementToBeClickable(searchButton)).click();
        return this;
    }

    public P01_DetailsPage clickOnAvailabilityButton() {
        longWait(driver).until(ExpectedConditions.elementToBeClickable(availabilityButton)).click();
        driver.get("https://www.booking.com/hotel/eg/royal-tulip-alexandria.html?label=gen173nr-10CAEoggI46AdIM1gEaEOIAQGYATO4ARfIAQzYAQPoAQH4AQGIAgGoAgG4AoHGgcUGwAIB0gIkZjg4NjUxYjItOTFiYi00ZGI0LWI5MWMtZDAzOTIzNGM5Y2M12AIB4AIB&aid=304142&ucfs=1&arphpl=1&checkin=2025-10-01&checkout=2025-10-14&dest_id=788831&dest_type=hotel&group_adults=2&req_adults=2&no_rooms=1&group_children=0&req_children=0&hpos=1&hapos=1&sr_order=popularity&srpvid=f9b94c8416e60059&srepoch=1755341582&all_sr_blocks=78883120_386871369_0_33_0_131741&highlighted_blocks=78883120_386871369_0_33_0_131741&matching_block_id=78883120_386871369_0_33_0_131741&sr_pri_blocks=78883120_386871369_0_33_0_131741_146458&from=searchresults");

        return new P01_DetailsPage(driver);

    }
}