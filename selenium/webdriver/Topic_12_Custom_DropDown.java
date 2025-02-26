package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class Topic_12_Custom_DropDown {
    WebDriver driver;
    WebDriverWait explicitWait;

    @BeforeClass
    public void initialBrowser() {

        driver = new FirefoxDriver();
        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(15));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test
    public void TC_01_() throws InterruptedException {
        driver.get("http://jqueryui.com/resources/demos/selectmenu/default.html");

        selectItemInCustomDropdopdown("span#speed-button", "ul#speed-menu>li>div","Faster");
        selectItemInCustomDropdopdown("span#files-button", "ul#files-menu>li>div","jQuery.js");
        selectItemInCustomDropdopdown("span#salutation-button", "ul#salutation-menu>li>div","Mr.");

    }
    @Test
    public void TC_02_() throws InterruptedException {
        driver.get("https://react.semantic-ui.com/maximize/dropdown-example-selection/");

        selectItemInCustomDropdopdown("div#root", "div.visible>div>span","Elliot Fu");

    }


    private void selectItemInCustomDropdopdown(String ParentCSS, String ChildCSS,String Textitem) throws InterruptedException {
        //hành vi để thao tác lên dropdown
        //1. chờ cho dropdown có thể thao tác lên được (tich hop 1 va 2)
        //2. click vào element để xổ ra dropdown
        explicitWait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(ParentCSS))).click();

        //2. click vào element để xổ ra dropdown

        //driver.findElement(By.cssSelector(ParentCSS)).click();
        //Thread.sleep(2000);

        //3. chờ tất cả các item được load ra (tich hop 3 va 4)

        List<WebElement> allitems = explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector(ChildCSS)));

        //4. tìm item nào đúng mong đợi rồi click lên item đó

        //List<WebElement> allitems = driver.findElements(By.cssSelector(ChildCSS));

        for (WebElement item : allitems) {
            System.out.println(item.getText());
            if (item.getText().equals(Textitem)) {
                item.click();
                break;
            }
        }
    }


    @Test
    public void TC_03_() {

    }
    @AfterClass
    public void cleanBrowser() {
        //driver.quit();}
    }
}