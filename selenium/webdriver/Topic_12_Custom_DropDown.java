package webdriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_12_Custom_DropDown {
    WebDriver driver;;

    @BeforeClass
    public void initialBrowser() {

        driver = new FirefoxDriver();
    }

    @Test
    public void TC_01_() {
        driver = new FirefoxDriver();
        driver.get("https://www.facebook.com/");

        //hành vi để thao tác lên dropdown
        //1. chờ cho dropdown có thể thao tác lên được
        //2. click vào element để xổ ra dropdown
        //3. chờ tất cả các item được load ra
        //4. tìm item nào đúng mong đợi rồi click lên item đó


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