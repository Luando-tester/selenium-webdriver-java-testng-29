package selenium.webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Topic_06_WebDriver_Command_02 {
    WebDriver driver;
    String projectPath = System.getProperty("user.dir");

    @BeforeClass
    public void beforeClass(){
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }


    @Test
    public void TC_01_Page_Url() {
       driver.get("http://live.techpanda.org/index.php/");
       driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).click();
       sleepInSecond(3);
        Assert.assertEquals(driver.getTitle(),"Customer Login");
        driver.findElement(By.cssSelector("a[title='Create an Account']")).click();
        sleepInSecond(3);
        Assert.assertEquals(driver.getCurrentUrl(),"http://live.techpanda.org/index.php/customer/account/create/");

    }
    @Test
    public void TC_02_Page_Title() {
        driver.get("http://live.techpanda.org/index.php/");
        driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).click();
        sleepInSecond(3);
       Assert.assertEquals(driver.getTitle(),"Customer Login");
        driver.findElement(By.cssSelector("a[title='Create an Account']")).click();
        sleepInSecond(3);
        Assert.assertEquals(driver.getTitle(),"Create New Customer Account");
    }

    @Test

    public void TC_03_Page_Navigation() {
        driver.get("http://live.techpanda.org/index.php/");
        driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).click();
        sleepInSecond(3);
        driver.findElement(By.cssSelector("a[title='Create an Account']")).click();
        sleepInSecond(3);
        driver.navigate().back();
        Assert.assertEquals(driver.getCurrentUrl(), "http://live.techpanda.org/index.php/customer/account/login/");
        driver.navigate().forward();
        sleepInSecond(3);
        Assert.assertEquals(driver.getTitle(), "Create New Customer Account");
    }
        @Test

        public void TC_04_Page_Source() {
            driver.get("http://live.techpanda.org/index.php/");
            driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).click();
            sleepInSecond(3);
            Assert.assertTrue(driver.getPageSource().contains("Login or Create an Account"));
            driver.findElement(By.cssSelector("a[title='Create an Account']")).click();
            sleepInSecond(3);

            Assert.assertTrue(driver.getPageSource().contains("Create an Account"));

    }
    @AfterClass
    public void afterClass() {
        driver.quit();
    }

    public void sleepInSecond (long timeInSecond){
        try{
            Thread.sleep(timeInSecond * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}