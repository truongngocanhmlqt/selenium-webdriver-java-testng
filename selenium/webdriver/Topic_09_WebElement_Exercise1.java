package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_09_WebElement_Exercise1 {
    WebDriver driver;
    ;

    @BeforeClass
    public void initialBrowser() {
        driver = new FirefoxDriver();
    }


    @Test
    public void TC_01_Display() {
        //isDisplayed: kiem tra bat ky mot element nao hien thi

        driver.get("https://automationfc.github.io/basic-form/index.html");
        WebElement emailTextbox = driver.findElement(By.cssSelector("input#mail"));
        if (emailTextbox.isDisplayed()) {
            System.out.println("Element is displayed");
            emailTextbox.sendKeys("Automation Testing");
        } else {
            System.out.println("Element is not displayed");
        }

        WebElement ageUnder18Radio = driver.findElement(By.cssSelector("input#under_18"));
        if (ageUnder18Radio.isDisplayed()) {
            System.out.println("Element is display");
            ageUnder18Radio.click();

        } else {
            System.out.println("Element is not displayed");

        }

        WebElement educationTextArea = driver.findElement(By.cssSelector("textarea#edu"));
        if (educationTextArea.isDisplayed()) {
            System.out.println("Element is display");
            educationTextArea.sendKeys("Automation Testing");

        } else {
            System.out.println("Element is not displayed");
        }

        WebElement user5Text = driver.findElement(By.xpath("//h5[text()='Name: User5']"));
        if (user5Text.isDisplayed()) {
            System.out.println("Element is display");

        } else {
            System.out.println("Element is not displayed");
        }

    }

    @Test
    public void TC_02_Enabled() {
        //isEnabled : kiem tra bat ky mot element co the tuong tac len duoc # nguoc lai voi read-only (disable)
        driver.get("https://automationfc.github.io/basic-form/index.html");
        WebElement emailTextbox = driver.findElement(By.cssSelector("input#mail"));
        if (emailTextbox.isEnabled()) {
            System.out.println("emailTextbox is enabled");
        } else {
            System.out.println("emailTextbox is not disabled");
        }

        WebElement ageUnder18Radio = driver.findElement(By.cssSelector("input#under_18"));
        if (ageUnder18Radio.isEnabled()) {
            System.out.println("ageUnder18Radio is enabled");
        } else {
            System.out.println("ageUnder18Radio is not disabled");
        }

        WebElement passwordTextbox = driver.findElement(By.cssSelector("input#disable_password"));
        if (passwordTextbox.isEnabled()) {
            System.out.println("passwordTextbox is enabled");
        } else {
            System.out.println("passwordTextbox is not disabled");
        }

        WebElement biographyTextarea = driver.findElement(By.cssSelector("textarea#bio"));
        if (biographyTextarea.isEnabled()) {
            System.out.println("biographyTextarea is enabled");
        } else {
            System.out.println("biographyTextarea is not disabled");
        }


    }

    @Test
    public void TC_03_Selected() throws InterruptedException {
        //kiem tra 1 element dduoc chon thanh cong (radio/checkbox/dropdown)
        driver.get("https://automationfc.github.io/basic-form/index.html");
        WebElement ageUnder18Radio = driver.findElement(By.cssSelector("input#under_18"));
        if (ageUnder18Radio.isSelected()) {
            System.out.println("Age under 18 is selected");
        } else {
            System.out.println("Age under 18 is de-selected");
        }

        driver.get("https://automationfc.github.io/basic-form/index.html");
        WebElement interestCheckbox = driver.findElement(By.cssSelector("input#development"));
        if (interestCheckbox.isSelected()) {
            System.out.println("Interest checkbox is selected");
        } else {
            System.out.println("Interest checkbox is de-selected");
        }

//        ageUnder18Radio.click();
//
//        interestCheckbox.click();
//
//        Thread.sleep(3000);
//
//        if (ageUnder18Radio.isSelected()) {
//            System.out.println("Age under 18 is selected");
//        } else {
//            System.out.println("Age under 18 is de-selected");
//        }
//        if (interestCheckbox.isSelected()) {
//            System.out.println("Interest checkbox is selected");
//        } else {
//            System.out.println("Interest checkbox is de-selected");
//        }

    }

    @Test
    public void TC_04_Mailchimp_Register_Validate() throws InterruptedException {
        driver.get("https://login.mailchimp.com/signup/");
        driver.findElement(By.cssSelector("input#email")).sendKeys("automationfc.vn@gmail.com");
        driver.findElement(By.cssSelector("input#email")).sendKeys(Keys.TAB);

        //only number
        driver.findElement(By.id("new_password")).sendKeys("12345");
        driver.findElement(By.id("new_password")).sendKeys(Keys.TAB);
        //Thread.sleep(3000);
        Assert.assertTrue(driver.findElement(By.cssSelector("li.lowercase-char.not-completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.uppercase-char.not-completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.number-char.completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.special-char.not-completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//li[@class='8-char not-completed']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.username-check.completed")).isDisplayed());

        //only lower text
        driver.findElement(By.id("new_password")).clear();
        driver.findElement(By.id("new_password")).sendKeys("testing");
        driver.findElement(By.id("new_password")).sendKeys(Keys.TAB);
        //Thread.sleep(3000);
        Assert.assertTrue(driver.findElement(By.cssSelector("li.lowercase-char.completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.uppercase-char.not-completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.number-char.not-completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.special-char.not-completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//li[@class='8-char not-completed']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.username-check.completed")).isDisplayed());

        //only upper text
        driver.findElement(By.id("new_password")).clear();
        driver.findElement(By.id("new_password")).sendKeys("TESTING");
        driver.findElement(By.id("new_password")).sendKeys(Keys.TAB);
        //Thread.sleep(3000);
        Assert.assertTrue(driver.findElement(By.cssSelector("li.lowercase-char.not-completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.uppercase-char.completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.number-char.not-completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.special-char.not-completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//li[@class='8-char not-completed']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.username-check.completed")).isDisplayed());

        //contain username
        driver.findElement(By.id("new_password")).clear();
        driver.findElement(By.id("new_password")).sendKeys("automation");
        driver.findElement(By.id("new_password")).sendKeys(Keys.TAB);
        //Thread.sleep(3000);
        Assert.assertTrue(driver.findElement(By.cssSelector("li.lowercase-char.completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.uppercase-char.not-completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.number-char.not-completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.special-char.not-completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//li[@class='8-char completed']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.username-check.not-completed")).isDisplayed());

        //only SPECIAL CHARS
        driver.findElement(By.id("new_password")).clear();
        driver.findElement(By.id("new_password")).sendKeys("@#$");
        driver.findElement(By.id("new_password")).sendKeys(Keys.TAB);
        //Thread.sleep(3000);
        Assert.assertTrue(driver.findElement(By.cssSelector("li.lowercase-char.not-completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.uppercase-char.not-completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.number-char.not-completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.special-char.completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//li[@class='8-char not-completed']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.username-check.completed")).isDisplayed());

        //FULL
        driver.findElement(By.id("new_password")).clear();
        driver.findElement(By.id("new_password")).sendKeys("Auto123@");
        driver.findElement(By.id("new_password")).sendKeys(Keys.TAB);
        //Thread.sleep(3000);
        Assert.assertFalse(driver.findElement(By.cssSelector("li.lowercase-char.completed")).isDisplayed());
        Assert.assertFalse(driver.findElement(By.cssSelector("li.uppercase-char.completed")).isDisplayed());
        Assert.assertFalse(driver.findElement(By.cssSelector("li.number-char.completed")).isDisplayed());
        Assert.assertFalse(driver.findElement(By.cssSelector("li.special-char.completed")).isDisplayed());
        Assert.assertFalse(driver.findElement(By.xpath("//li[@class='8-char completed']")).isDisplayed());
        Assert.assertFalse(driver.findElement(By.cssSelector("li.username-check.completed")).isDisplayed());


    }

    @AfterClass
    public void cleanBrowser() {
        //driver.quit();}
    }
}












