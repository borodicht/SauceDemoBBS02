package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage extends BasePage {

    private static final By TITLE = By.xpath("//*[@data-test='title']");
    private static final By FIRST_NAME = By.xpath("//*[@id='first-name']");
    private static final By LAST_NAME = By.xpath("//*[@id='last-name']");
    private static final By ZIP_CODE = By.xpath("//*[@id='postal-code']");
    private static final By CONTINUE = By.xpath("//*[@id='continue']");
    private static final By ERROR_MESSAGE = By.xpath("//*[@data-test='error']");

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    public String getTitle() {
        return driver.findElement(TITLE).getText();
    }

    public void setInputValues(String first_name, String last_name, String zip_code) {
        driver.findElement(FIRST_NAME).sendKeys(first_name);
        driver.findElement(LAST_NAME).sendKeys(last_name);
        driver.findElement(ZIP_CODE).sendKeys(zip_code);
        clickJS(driver.findElement(CONTINUE));
    }

    public String getErrorMessage() {
        return driver.findElement(ERROR_MESSAGE).getText();
    }
}
