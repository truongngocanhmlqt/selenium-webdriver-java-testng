package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_16_Authentication_Alert {
    WebDriver driver;
    String username = "admin";
    String password = "admin";

    @BeforeClass
    public void initialBrowser() {

        driver = new FirefoxDriver();

    }

    @Test
    public void TC_01_Authen_URL() {
        // https/ http:// + username + : + password + @ + URL
        //http://the-internet.herokuapp.com/basic_auth

        driver.get("http://" + username + ":" + password + "@" + "the-internet.herokuapp.com/basic_auth");
        Assert.assertEquals(driver.findElement(By.cssSelector("div.example>p")).getText(), "Congratulations! You must have the proper credentials.");

    }

    @Test
    public void TC_02_Authen_Navigate() {


    }

    @Test
    public void TC_03_() {

    }
    @AfterClass
    public void cleanBrowser() {
        //driver.quit();}
    }
}