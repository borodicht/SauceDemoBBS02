package tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CartTest extends BaseTest {

    @Test
    public void checkCheckoutButton() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.ProductSort();
        productsPage.AddToCart();
        assertEquals(cartPage.getTitle(),
                "Your Cart",
                "Страница не открылась");
        cartPage.checkout();
    }
}
