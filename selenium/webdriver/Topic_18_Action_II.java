package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class Topic_18_Action_II {
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
    public void TC_01_Hover() throws InterruptedException {
        driver.get("https://www.fahasa.com/");

        // Hover to the main menu
        action.moveToElement(driver.findElement(By.cssSelector("span.icon_menu"))).perform();
        Thread.sleep(4000);

        // Wait until the submenu is visible
        //explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@class='nav navbar-nav verticalmenu']//span[text()='Hành Trang Đến Trường']")));
        action.moveToElement(driver.findElement(By.xpath("//ul[@class='nav navbar-nav verticalmenu']//span[text()='Hành Trang Đến Trường']"))).perform();

        // Wait until the link is clickable
        explicitWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='dropdown-menu']//a[text()= 'Luyện Thi Môn Toán']"))).click();

        // Assert that the element is displayed
        Assert.assertTrue(driver.findElement(By.xpath("//ol[@class='breadcrumb']//strong[text()='Toán']")).isDisplayed());
    }

    @Test
    public void TC_02_Click_Anh_Hold() throws InterruptedException {
        // Code for this test case
        driver.get("https://automationfc.github.io/jquery-selectable/");
        List<WebElement> selectList = driver.findElements(By.cssSelector("ol#selectable>li"));
        Assert.assertEquals(selectList.size(), 20);

        action.clickAndHold(selectList.get(0)) //click vào số 1 và giữ chuỗi
                .moveToElement(selectList.get(3)) //click vào số 1 và giữ chuỗi
                .release()  //nhã chuột trái ra, kết thúc sự kiện click and hold
                .perform(); //thực thi các câu lệnh trên (nếu k có thì k thực thi)
        Thread.sleep(3000);

        List<WebElement> selected = driver.findElements(By.cssSelector("ol#selectable>li.ui-selected"));
        Assert.assertEquals(selected.size(), 4);


    }

    @Test
    public void TC_03_() {
        driver.get("http://swisnl.github.io/jQuery-contextMenu/demo.html");
        //click chuột phải vào element
        action.contextClick(driver.findElement(By.xpath("//span[text()='right click me']"))).perform();

        //kiểm tra quit menu hiển thị:
        By Quitelement = By.cssSelector("li.context-menu-icon-quit");
        Assert.assertTrue(driver.findElement(Quitelement).isDisplayed());

        //Hover chuột và click vào element quit:
        action.moveToElement(driver.findElement(Quitelement)).perform();

        //kiểm tra quit xuất hiện
        Assert.assertTrue(driver.findElement(By.cssSelector("li.context-menu-icon-quit.context-menu-visible.context-menu-hover")).isDisplayed());

        //click chọn quit:
        driver.findElement(Quitelement).click();
        driver.switchTo().alert().accept();

        Assert.assertFalse(driver.findElement(Quitelement).isDisplayed());





    }

    @AfterClass
    public void cleanBrowser() {
        //driver.quit();
    }
}