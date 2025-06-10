package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import tests.AllureUtils;

public class ProductsPage extends BasePage {

    private static final By TITLE = By.xpath("//*[@data-test='title']");
    private static final By PRODUCT_SORT = By.xpath("//*[@data-test='product-sort-container']");
    private static final By SORT_Z_TO_A = By.xpath("//*[@value='za']");
    private static final By ADD_TO_CART =
            By.xpath("//*[@id='add-to-cart-test.allthethings()-t-shirt-(red)']");
    private static final By SHOPPING_CART = By.xpath("//*[@class='shopping_cart_link']");

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    public String getTitle() {
        return driver.findElement(TITLE).getText();
    }

    @Step("Добавление товара в корзину")
    public void AddToCart() {
        driver.findElement(ADD_TO_CART).click();
        driver.findElement(SHOPPING_CART).click();
    }

    public void ProductSort() {
        driver.findElement(PRODUCT_SORT).click();
        driver.findElement(SORT_Z_TO_A).click();
    }
}
