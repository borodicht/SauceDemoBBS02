package tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class LoginTest extends BaseTest {

    @Test(testName = "Негативный тест логина",
            description = "Проверка логина в систему с пустым полем пароль",
            priority = 2, dependsOnMethods = {"checkLoginWithWrongPassword"},
    retryAnalyzer = Retry.class)
    public void checkLoginWithEmptyPassword() {
        loginPage.open();
        loginPage.login("standard_user", "");
        assertEquals(loginPage.getErrorMessage(),
                "Epic sadface: Password is required",
                "Сообщение об ошибке не появилось");
    }

    @Test(priority = 1)
    public void checkLoginWithWrongPassword() {
        loginPage.open();
        loginPage.login("standard_user", "1234567");
        assertEquals(loginPage.getErrorMessage(),
                "Epic sadface: Username and password do not match any user in this service",
                "Сообщение об ошибке не появилось");
    }

    @Test(priority = 4)
    public void checkLoginWithEmptyUsername() {
        loginPage.open();
        loginPage.login("", "secret_sauce");
        assertEquals(loginPage.getErrorMessage(),
                "Epic sadface: Username is required",
                "Сообщение об ошибке не появилось");
    }

    @Test(priority = 3)
    public void checkLoginWithPositiveCred() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        assertEquals(productsPage.getTitle(),
                "Products",
                "Сообщение об ошибке не появилось");
    }

    @DataProvider (name = "Негативные тесты логина")
    public Object[][] negativeTest() {
        return new Object[][] {
                {"standard_user", "", "Epic sadface: Password is required"},
                {"standard_user", "1234567", "Epic sadface: Username and password do not match any user in this service"},
                {"", "secret_sauce", "Epic sadface: Username is required"}
        };
    }

    @Test (dataProvider = "Негативные тесты логина")
    public void test(String user, String pass, String message) {
        loginPage.open();
        loginPage.login(user, pass);
        assertEquals(loginPage.getErrorMessage(),
                message,
                "Сообщение об ошибке не появилось");
    }
}
