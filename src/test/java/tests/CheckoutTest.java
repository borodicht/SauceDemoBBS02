package tests;

import io.qameta.allure.*;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CheckoutTest extends BaseTest {

    @Test
    public void checkInputsWithPositiveCred() {
        loginPage.open();
        loginPage.login(user, password);
        productsPage.AddToCart();
        cartPage.checkout();
        assertEquals(checkoutPage.getTitle(),
                "Checkout: Your Information",
                "Страница не открылась");
        checkoutPage.setInputValues("Dina","Knyazeva","123456");
    }


    @Epic("Заполнение информации о покупателе")
    @Feature("Форма покупателя")
    @Story("Ввод пустого имени в форме")
    @Description("Проверка регистрации покупателя с пустым полем для имени")
    @Severity(SeverityLevel.MINOR)
    @Owner("Dina Knyazeva")
    @TmsLink("SD-01")
    @Issue("SD-BUG-01")
    @Link(name = "Документация", url = "https://github.com/borodicht/AllureReportingGoogle")
    @Flaky
    @Test (testName = "Негативный тест формы покупателя")
    public void checkInputsWithEmptyFirstName() {
        loginPage.open();
        loginPage.login(user, password);
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
        loginPage.login(user, password);
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
        loginPage.login(user, password);
        productsPage.AddToCart();
        cartPage.checkout();
        assertEquals(checkoutPage.getTitle(),
                "Checkout: Your Information",
                "Страница не открылась");
        checkoutPage.setInputValues("Dina","Knyazeva","");
        assertEquals(checkoutPage.getErrorMessage(),
                "Error: Postal Code is required",
                "Сообщение об ошибке не появилось");
    }
}
