package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

public class Topic_11_Default_Dropdown {
    WebDriver driver;
    Select select;

    @BeforeClass
    public void initialBrowser() {
        driver = new FirefoxDriver();
    }

    @Test
    public void TC_01_() {
        driver = new FirefoxDriver();
        driver.get("https://www.facebook.com/reg/");
        //dropdown xuat hien
        select = new Select(driver.findElement(By.id("day")));

        //chọn 1 item
        select.selectByVisibleText("20");

        //chọn xong verify đã chọn thành công hay chưa
        //select.getFirstSelectedOption().getText();
        Assert.assertEquals(select.getFirstSelectedOption().getText(), "20");

        //verify cái dropdown có phải là multiple select không
        // nếu là multiple --> true
        // nếu là single --> false
        Assert.assertFalse(select.isMultiple());

        //verify tổng số lượng item trong dropdown có bn item

        Assert.assertEquals(select.getOptions().size(), 31);


        select = new Select(driver.findElement(By.id("month")));
        select.selectByVisibleText("Jul");
        Assert.assertEquals(select.getFirstSelectedOption().getText(), "Jul");


    }

    @Test
    public void TC_02_() {
        driver = new FirefoxDriver();
        driver.get("https://demo.nopcommerce.com/register");
        driver.findElement(By.xpath("//a[@class=\"ico-register\"]")).click();
        new Select(driver.findElement(By.cssSelector("select[name='DateOfBirthDay']"))).selectByVisibleText("");
        new Select(driver.findElement(By.cssSelector("select[name='DateOfBirthMonth']"))).selectByVisibleText("");
        new Select(driver.findElement(By.cssSelector("select[name='DateOfBirthYear']"))).selectByVisibleText("");

        Assert.assertEquals(new Select(driver.findElement(By.cssSelector("select[name='DateOfBirthDay']"))).getFirstSelectedOption().getText(), "");



    }

    @Test
    public void TC_03_() {
        driver = new FirefoxDriver();
        driver.get("https://www.rode.com/wheretobuy");
        new Select(driver.findElement(By.id("country"))).selectByVisibleText("Vietnam");
        driver.findElement(By.id("map_search_query")).sendKeys("ho chi minh");
        driver.findElement(By.xpath("//button[@class='btn btn-default']")).click();
        //driver.findElement(By.xpath("//div[@class='d-flex flex-wrap']//following-sibling::div//h4"))
        List<WebElement> dealers = driver.findElements(By.xpath("//div[@class='d-flex flex-wrap']//following-sibling::div//h4"));
        Assert.assertEquals(dealers.size(), 15);

        for (WebElement element : dealers) {
            System.out.println(element.getText());
        }


    }
    @AfterClass
    public void cleanBrowser() {
        //driver.quit();}
    }
}