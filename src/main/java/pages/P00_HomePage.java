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
        List<WebElement> hotelTitles = driver.findElements(By.xpath("//div[@data-testid='title']"));
        for (WebElement title : hotelTitles) {
            if (title.getText().trim().equalsIgnoreCase("Tolip Hotel Alexandria")) {
                longWait(driver).until(ExpectedConditions.elementToBeClickable(title)).click();
                break;
            }
        }
        return new P01_DetailsPage(driver);
    }
}