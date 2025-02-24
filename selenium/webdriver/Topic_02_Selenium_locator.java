package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_02_Selenium_locator {
    WebDriver driver;;

    @BeforeClass
    public void initialBrowser() {

        driver = new FirefoxDriver();
        driver.get("");
    }

    @Test
    public void TC_01_ID() {
        //có ID mới tìm bằng ID được
        driver.findElement(By.id("small-searchterms")).sendKeys("MACBOOK");

    }

    @Test
    public void TC_02_Class() {
        //nó không lấy hết toàn bộ giá trị(nêu có khoảng trắng)
        driver.findElement(By.className("register-next-step-button")).click();


    }

    @Test
    public void TC_03_Name() {
        driver.findElement(By.name("DateOfBirthDay"));
        driver.findElement(By.name("DateOfBirthMonth"));
        driver.findElement(By.name("DateOfBirthYear"));


    }

    @Test
    public void TC_04_Linktext() {
        //chỉ làm việc với element có link và có text
        //thẻ a và có thuộc tính href
        //lấy hết toàn bộ text không chừa cái nào hết(tuyệt đối)
        driver.findElement(By.linkText("Register"));
        driver.findElement(By.linkText("Log in"));
        driver.findElement(By.linkText("Wishlist"));


    }

    @Test
    public void TC_05_Partial_link_text() {
        //chỉ làm việc với element có link và có text
        //có thể lấy toàn bộ text hoặc một phần (hay dùng)
        driver.findElement(By.partialLinkText("Shipping & returns"));
        driver.findElement(By.partialLinkText("Shipping"));
        driver.findElement(By.partialLinkText("returns"));



    }

    @Test
    public void TC_06_Tagname() {
        //tên thẻ (HTML)
        //tìm tất cả các element giống nhau(thẻ của component giống nhau)
        //tất cả các textbox/checkbox/radio/link/button...
        driver.findElements(By.tagName("button"));
        driver.findElements(By.tagName("input"));
        driver.findElements(By.tagName("label"));

    }

    @AfterClass
    public void cleanBrowser() {
        //driver.quit();}
    }
}