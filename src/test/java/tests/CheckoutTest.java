package tests;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CheckoutTest extends BaseTest {

    @Test
    public void checkInputsWithPositiveCred() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.AddToCart();
        cartPage.checkout();
        assertEquals(checkoutPage.getTitle(),
                "Checkout: Your Information",
                "Страница не открылась");
        checkoutPage.setInputValues("Dina","Knyazeva","123456");
    }

    @Test
    public void checkInputsWithEmptyFirstName() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.AddToCart();
        cartPage.checkout();
        assertEquals(checkoutPage.getTitle(),
                "Checkout: Your Information",
                "Страница не открылась");
        checkoutPage.setInputValues("","Knyazeva","123456");
        assertEquals(checkoutPage.getErrorMessage(),
                "Error: First Name is required",
                "Сообщение об ошибке не появилось");
    }

    @Test
    public void checkInputsWithEmptyLastName() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.AddToCart();
        cartPage.checkout();
        assertEquals(checkoutPage.getTitle(),
                "Checkout: Your Information",
                "Страница не открылась");
        checkoutPage.setInputValues("Dina","","123456");
        assertEquals(checkoutPage.getErrorMessage(),
                "Error: Last Name is required",
                "Сообщение об ошибке не появилось");
    }

    @Test
    public void checkInputsWithEmptyZipCode() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.AddToCart();
        cartPage.checkout();
        assertEquals(checkoutPage.getTitle(),
                "Checkout: Your Information",
                "Страница не открылась");
        checkoutPage.setInputValues("Dina","Knyazeva","");
        assertEquals(checkoutPage.getErrorMessage(),
                "Error: Postal Code is required",
                "Сообщение об ошибке не появилось");


        JavascriptExecutor js = (JavascriptExecutor) driver;

//        WebElement element = driver.findElement(By.id("id"));
//        element.click();
//        Actions action = new Actions(driver);
//        action.click(element).perform();
//
//
//        js.executeScript("arguments[0].click();", element);
    }
}
