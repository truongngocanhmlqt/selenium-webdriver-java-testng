package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.Color;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_13_Button {
    WebDriver driver;;

    @BeforeClass
    public void initialBrowser() {

        driver = new FirefoxDriver();
    }

    @Test
    public void TC_01_() {
        driver.get("https://www.fahasa.com/customer/account/create");
        driver.findElement(By.cssSelector("li.popup-login-tab-login")).click();
        By ButtonLogin = By.cssSelector("button.fhs-btn-login");
        Assert.assertFalse(driver.findElement(ButtonLogin).isEnabled());
        String loginBackgroundColor = driver.findElement(ButtonLogin).getCssValue("background-color");
        Color LoginColor = Color.fromString(loginBackgroundColor);
        Assert.assertEquals(LoginColor.asHex().toUpperCase(), "#000000");

        driver.findElement(By.cssSelector("input#login_username")).sendKeys("anhtruong@gmail.com");
        driver.findElement(By.cssSelector("input#login_password")).sendKeys("Anh@123456");

        Assert.assertTrue(driver.findElement(ButtonLogin).isEnabled());
        Assert.assertEquals(Color.fromString(driver.findElement(ButtonLogin).getCssValue("background-color")).asHex().toUpperCase(), "#C92127");






    }

    @Test
    public void TC_02_() {

    }

    @Test
    public void TC_03_() {

    }
    @AfterClass
    public void cleanBrowser() {
        //driver.quit();}
    }
}