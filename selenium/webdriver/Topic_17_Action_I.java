package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Topic_17_Action_I {
    WebDriver driver;
    WebDriverWait explicitWait;
    Actions action;

    @BeforeClass
    public void initialBrowser() {

        driver = new FirefoxDriver();
        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        action = new Actions(driver);
    }

    @Test
    public void TC_01_Jquery() {
        driver.get("https://automationfc.github.io/jquery-tooltip/");
        //hold chuột:
        action.moveToElement(driver.findElement(By.cssSelector("input#age"))).perform();
        Assert.assertTrue(driver.findElement(By.cssSelector("div.ui-tooltip-content")).isDisplayed());
        Assert.assertEquals(driver.findElement(By.cssSelector("div.ui-tooltip-content")).getText(), "We ask for your age only for statistical purposes.");
    }

    @Test
    public void TC_02_Myntra() {
        driver.get("http://www.myntra.com/");
        action.moveToElement(driver.findElement(By.xpath("//a[@class = 'desktop-main' and text() = 'Kids']"))).perform();
        //Assert.assertTrue(driver.findElement(By.cssSelector("//a[@class = 'desktop-categoryName' and text() = 'Home & Bath']")).isDisplayed());

        //action Click:
        action.click(driver.findElement(By.xpath("//a[@class = 'desktop-categoryName' and text() = 'Home & Bath']"))).perform();
        Assert.assertEquals(driver.findElement(By.cssSelector("span.breadcrumbs-crumb")).getText(), "Kids Home Bath");

    }

    @Test
    public void TC_03_() {

    }
    @AfterClass
    public void cleanBrowser() {
        //driver.quit();}
    }
}