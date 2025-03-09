package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_20_Frame_iFrame {
    WebDriver driver;
    Select select;

    @BeforeClass
    public void initialBrowser() {
        driver = new FirefoxDriver();
    }

    @Test
    public void TC_01_() throws InterruptedException {
        driver.get("https://www.formsite.com/templates/education/campus-safety-survey/");

        //click vào hình:
        driver.findElement(By.xpath("//img[@alt='Campus Safety Survey']")).click();

        //Switch qua Iframe:
        driver.switchTo().frame(driver.findElement(By.cssSelector("div#formTemplateContainer>iframe")));
        Thread.sleep(3000);

        // Element thuộc trang HTML B
        new Select(driver.findElement(By.cssSelector("select#RESULT_RadioButton-2"))).selectByVisibleText("Sophomore");
        Thread.sleep(3000);

        new Select(driver.findElement(By.cssSelector("select#RESULT_RadioButton-3"))).selectByVisibleText("South Dorm");

        driver.findElement(By.xpath("//label[@for='RESULT_RadioButton-4_0']")).click();
        Thread.sleep(3000);

        // từ B quay lại A

        driver.switchTo().defaultContent();

        //driver đã quay lại A rồi:

        driver.findElement(By.cssSelector("a.menu-item-login.fs-btn--transparent-kashmir")).click();
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("button#login")).click();
        Thread.sleep(3000);
        Assert.assertEquals(driver.findElement(By.cssSelector("div#message-error")).getText(), "Username and password are both required.");







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