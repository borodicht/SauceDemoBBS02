package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class Locators {

    WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
    }

    @Test
    public void test() {
        driver.get("https://www.saucedemo.com/");
        //id
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        //name
        driver.findElement(By.name("password")).sendKeys("secret_sauce");
        //classname
        driver.findElement(By.className("submit-button")).click();
        //tagname
        driver.findElement(By.tagName("button"));
        //я добавила айди, чтобы открыть бургер меню
        driver.findElement(By.id("react-burger-menu-btn")).click();
        //linktext
        driver.findElement(By.linkText("All Items"));
        //partiallinktext
        driver.findElement(By.partialLinkText("Reset"));

        //xpath
        //поиск по атрибуту
        driver.findElement(By.xpath("//button[@id='react-burger-cross-btn']")).click();
        //поиск по тексту
        driver.findElement(By.xpath("//button[text()='Add to cart']"));
        //поиск по частичному совпадению атрибута
        driver.findElement(By.xpath("//div[contains(@class,'inventory_item')]"));
        //поиск по частичному совпадению текста,=
        driver.findElement(By.xpath("//div[contains(text(),'carry.allTheThings() with the sleek')]"));
        //ancestor
        driver.findElement(By.xpath("//*[text()='Swag Labs']//ancestor::div"));
        //descendant
        driver.findElement(By.xpath("//a[@id='item_4_img_link']//descendant::img"));
        //following
        driver.findElement(By.xpath("//a[@id='item_0_img_link']/following::img"));
        //parent
        driver.findElement(By.xpath("//div[@class='inventory_item']/parent::node()"));
        //preceding
        driver.findElement(By.xpath("//div[@class='inventory_item_desc']/preceding::div"));

        //css
        //.class
        driver.findElement(By.cssSelector(".shopping_cart_container")).click();
        // .class1 .class2
        driver.findElement(By.cssSelector(".header_label .app_logo"));
        // #id
        driver.findElement(By.cssSelector("#cart_contents_container"));
        //tagname
        driver.findElement(By.cssSelector("a"));
        //tagname.class
        driver.findElement(By.cssSelector("button.btn_secondary"));
        //[attribute=value]
        driver.findElement(By.cssSelector("[class=cart_list]"));
        //[attribute~=value]
        driver.findElement(By.cssSelector("[class~=cart]"));
        //[attribute|=value]
        driver.findElement(By.cssSelector("[class|=list]"));
        //[attribute^=value]
        driver.findElement(By.cssSelector("[href^=https]"));
        //[attribute$=value]
        driver.findElement(By.cssSelector("[class$=copy]"));
        //[attribute*=value]
        driver.findElement(By.cssSelector("[[class*=social]]"));
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        driver.quit();
    }
}
