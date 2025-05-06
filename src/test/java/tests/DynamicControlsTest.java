package tests;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.swing.*;
import java.io.File;
import java.time.Duration;
import java.util.List;

public class DynamicControlsTest {

    @Test
    public void test() {
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        driver.findElement(By.xpath("//*[text()='Remove']")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("message")));


        List<WebElement> nameProducts = driver.findElements(By.xpath("//*[@class='inventory_item_name']"));
        Assert.assertEquals(nameProducts.size(), 3);
        Assert.assertEquals(nameProducts.get(0).getText(), "Sauce Labs Backpack");




        driver.switchTo().frame(driver.findElement(By.cssSelector("[.ag-popup__frame__layout__iframe]")));

        driver.switchTo().defaultContent();

        WebElement element = driver.findElement(By.id("id"));
        WebElement element1 = driver.findElement(By.id("id"));


        Actions actions = new Actions(driver);
        actions.moveToElement(element).clickAndHold().contextClick().build();


        File file = new File("src/test/resources/1.txt");
        driver.findElement(By.id("file-upload")).sendKeys(file.getAbsolutePath());




        driver.quit();
    }
}
