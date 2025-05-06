package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends BasePage {

    private static final By TITLE = By.xpath("//*[@data-test='title']");
    private static final By CHECKOUT = By.xpath("//*[@id='checkout']");

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public String getTitle() {
        return driver.findElement(TITLE).getText();
    }

    public void checkout() {
        driver.findElement(CHECKOUT).click();
    }
}
