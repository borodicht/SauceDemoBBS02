package tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class ProductsTest extends BaseTest{

    @Test
    public void checkSort() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        assertEquals(productsPage.getTitle(),
                "Products",
                "Страница не открылась");
        productsPage.ProductSort();
    }

    @Test
    public void checkAddToCart() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        assertEquals(productsPage.getTitle(),
                "Products",
                "Страница не открылась");
        productsPage.AddToCart();
    }
}
