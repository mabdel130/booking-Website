package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class P01_DetailsPage extends BasePage {
    public P01_DetailsPage(WebDriver driver) {
        super(driver);
    }

    private final By bedRadioButton = By.xpath("//div[@class='rt-bed-type-select']//input");
    private final By roomsAmountDropdown = By.xpath("(//select[@class='hprt-nos-select js-hprt-nos-select'])[1]");
    private final By reserveButton = By.xpath("//button[@type='submit']//span[contains(text(), 'reserve')]");

    public P01_DetailsPage selectBeds() {
        longWait(driver).until(ExpectedConditions.elementToBeClickable(bedRadioButton)).click();
        return new P01_DetailsPage(driver);
    }

    public P01_DetailsPage getRoomsAmountDropdown(String number) {
        longWait(driver).until(ExpectedConditions.elementToBeClickable(roomsAmountDropdown)).sendKeys(number);
        return new P01_DetailsPage(driver);
    }

    public P01_DetailsPage reserveOrder() {
        shortWait(driver).until(ExpectedConditions.visibilityOfElementLocated((reserveButton))).click();
        return new P01_DetailsPage(driver);
    }
}