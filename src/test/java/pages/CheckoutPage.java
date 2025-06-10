package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import tests.AllureUtils;

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

    @Step("Заполнение формы покупателя с именем: {firstName}, фамилией: {lastName} и индексом: {zipCode}")
    public void setInputValues(String firstName, String lastName, String zipCode) {
        driver.findElement(FIRST_NAME).click();
        driver.findElement(FIRST_NAME).sendKeys(firstName);
        driver.findElement(LAST_NAME).sendKeys(lastName);
        driver.findElement(ZIP_CODE).sendKeys(zipCode);
        clickJS(driver.findElement(CONTINUE));
    }

    public String getErrorMessage() {
        return driver.findElement(ERROR_MESSAGE).getText();
    }
}
