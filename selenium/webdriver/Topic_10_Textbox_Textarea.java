package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Random;

public class Topic_10_Textbox_Textarea {
    WebDriver driver;
    String firstname, lastname, emailDress, fullname, Password;

    @BeforeClass
    public void initialBrowser() {

        driver = new FirefoxDriver();
        Random rand = new Random();
        firstname = "joe";
        lastname = "Biden";
        fullname = firstname + ' ' + lastname;
        emailDress = "joebiden" + rand.nextInt(9999) + "@gmail.com";
        Password = "123456789";



    }

    @Test
    public void TC_01_() throws InterruptedException {
        driver = new FirefoxDriver();
        driver.get("http://live.techpanda.org/");
        driver.findElement(By.xpath("//div[@class='footer-container']//a[@title='My Account']")).click();
        driver.findElement(By.xpath("//a[@title='Create an Account']")).click();
        driver.findElement(By.id("firstname")).sendKeys(firstname);
        driver.findElement(By.id("lastname")).sendKeys(lastname);
        driver.findElement(By.id("email_address")).sendKeys(emailDress);
        driver.findElement(By.id("password")).sendKeys(Password);
        driver.findElement(By.id("confirmation")).sendKeys(Password);

        driver.findElement(By.xpath("//button[@title='Register']")).click();
        //driver.findElement(By.xpath("//li[@class='success-msg']//span")).getText();

        Assert.assertEquals(driver.findElement(By.xpath("//li[@class='success-msg']//span")).getText(), "Thank you for registering with Main Website Store.");
        //driver.findElement(By.xpath("//h3[text()='Contact Information']/parent::div/following-sibling::div/p")).getText();

        String contactInformationText =  driver.findElement(By.xpath("//h3[text()='Contact Information']/parent::div/following-sibling::div/p")).getText();
        System.out.println(fullname);
        System.out.println(emailDress);
        System.out.println(contactInformationText);
        Assert.assertTrue(contactInformationText.contains("emailDress"));
        //&& contactInformationText.contains("emailDress")
        //contactInformationText.contains(fullname)&&


        driver.findElement(By.xpath("//h3[text()='Contact Information']/following-sibling::a")).click();
        Assert.assertEquals(driver.findElement(By.id("firstname")).getAttribute("value"), firstname);
        Assert.assertEquals(driver.findElement(By.id("lastname")).getAttribute("value"), lastname);
        Assert.assertEquals(driver.findElement(By.id("email")).getAttribute("value"), emailDress);

        //product review

        driver.findElement(By.xpath("//a[text()='Mobile']")).click();
        driver.findElement(By.xpath("//a[text()='Samsung Galaxy']")).click();
        driver.findElement(By.xpath("//a[text()='Add Your Review']")).click();

        driver.findElement(By.id("Quality 1_5")).click();
        driver.findElement(By.id("review_field")).sendKeys("good application\n" +
                "pretty easy to navigate");
        driver.findElement(By.id("summary_field")).sendKeys("best phone");
        driver.findElement(By.id("nickname_field")).clear();
        driver.findElement(By.id("nickname_field")).sendKeys("automationfc");
        driver.findElement(By.xpath("//button[@title='Submit Review']")).click();

        Assert.assertEquals(driver.findElement(By.xpath("//li[@class='success-msg']//span")).getText(), "Your review has been accepted for moderation.");

        //log out

        driver.findElement(By.xpath("//div[@class='account-cart-wrapper']//a")).click();
        driver.findElement(By.xpath("//a[@title='Log Out']")).click();
        Thread.sleep(6000);





















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