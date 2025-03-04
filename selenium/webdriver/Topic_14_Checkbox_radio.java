package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class Topic_14_Checkbox_radio {
    WebDriver driver;
    JavascriptExecutor jsExecutor;

    @BeforeClass
    public void initialBrowser() {

        driver = new FirefoxDriver();
        jsExecutor = (JavascriptExecutor) driver;
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test
    public void TC_01_Telerik() {

        driver.get("https://demos.telerik.com/kendo-ui/checkbox/index");
        By DualZone = By.xpath("//label[text()='Dual-zone air conditioning']/preceding-sibling::span/input");

        //scroll xuoongs 1 doan:
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,300)");


        //Select Dual-Zone checkbox
        //Assert.assertTrue(driver.findElement(DualZone).isEnabled());
        if (!driver.findElement(DualZone).isSelected()) {
            driver.findElement(DualZone).click();

        }
        Assert.assertTrue(driver.findElement(DualZone).isSelected());

        //De-select Dual-zone checkbox

        if (driver.findElement(DualZone).isSelected()) {
            driver.findElement(DualZone).click();
        }
        Assert.assertFalse(driver.findElement(DualZone).isSelected());



    }

    @Test
    public void TC_02_SelectAll() {
        driver.get("https://automationfc.github.io/multiple-fields/");
        //By CheckBoxs = By.cssSelector("span.form-checkbox-item>input");

        List<WebElement> ListCheckbox = driver.findElements(By.cssSelector("span.form-checkbox-item>input"));

        //Selected

        for (WebElement item: ListCheckbox) {
            if (!item.isSelected()) {
                item.click();
            }
            Assert.assertTrue(item.isSelected());

        }
        //De-select
        for (WebElement item: ListCheckbox) {
            if(item.isSelected()) {
                item.click();
            }
            Assert.assertFalse(item.isSelected());

        }
        driver.findElement(By.xpath("//input[@value= 'Heart Attack']")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//input[@value= 'Heart Attack']")).isSelected());




    }

    @Test
    public void TC_03_Ubuntu() {
        driver.get("https://login.ubuntu.com/");
        //By newuserRadiolabel = By.cssSelector("label.new-user");
        By NewuserRadioInput = By.cssSelector("input#id_new_user");
        jsExecutor.executeScript("arguments[0].click();", driver.findElement(NewuserRadioInput));
        Assert.assertTrue(driver.findElement(NewuserRadioInput).isSelected());

    }

    public void TC_03_Ubuntu() {
        driver.get("https://docs.google.com/forms/d/e/1FAIpQLSfiypnd69zhuDkjKgqvpID9kwO29UCzeCVrGGtbNPZXQok0jA/viewform");






    }
    @AfterClass
    public void cleanBrowser() {
        //driver.quit();}
    }
}