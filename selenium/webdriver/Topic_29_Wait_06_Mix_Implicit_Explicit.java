package selenium.webdriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Date;

public class Topic_29_Wait_06_Mix_Implicit_Explicit {
    WebDriver driver;
    WebDriverWait explicitWait;

    @BeforeClass
    public void beforeClass(){
        driver = new FirefoxDriver();

    }
    @Test
    public void TC_01_Only_Implicit_Found() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.get("https://www.facebook.com/");
        driver.findElement(By.cssSelector("input#email"));

    }
    @Test
    public void TC_02_Only_Implicit_Not_Found() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.get("https://www.facebook.com/");
        driver.findElement(By.cssSelector("input#automation"));
    }

    @Test
    public void TC_03_Only_Explicit_Found() {
        driver.get("https://www.facebook.com/");
        explicitWait = new WebDriverWait(driver,Duration.ofSeconds(5));
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input#email")));
    }

    @Test
    public void TC_04_Only_Explicit_Not_Found() {
        driver.get("https://www.facebook.com/");
        explicitWait = new WebDriverWait(driver,Duration.ofSeconds(5));
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input#email")));
    }

    @Test
    public void TC_05_Mix_Implicit_Explicit() {
        driver.get("https://www.facebook.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        explicitWait = new WebDriverWait(driver,Duration.ofSeconds(5));
        driver.findElement(By.cssSelector("input#email"));

        System.out.println("Start time : "  + getDateTimeNow());
        try {
            explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input#automation")));
        }catch (Exception e) {
            System.out.println("End Time: " + getDateTimeNow());
            e.printStackTrace();
        }
    }






    @AfterClass
    public void afterClass() {
       // driver.quit();
    }

    public void sleepInSecond (long timeInSecond){
        try{
            Thread.sleep(timeInSecond * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public static String getDateTimeNow(){
        Date date = new Date();
        return date.toString();
    }




}
