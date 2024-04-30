package selenium.webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Topic_23_Wait_02_Find_Element {
    WebDriver driver;

    WebDriverWait explicitWait;
    FluentWait<WebDriver> fluentWait;




    @BeforeClass
    public void beforeClass(){
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://www.facebook.com");

    }
    @Test
    public void TC_01_FindElement(){

        //Case1: Element duoc tim thay chi co 1.
        System.out.println("Start step: " +getDateTimeNow());
        driver.findElement(By.cssSelector("input#email"));
        System.out.println("End step: " + getDateTimeNow());

       //Case 2:Element duoc tim thay.
        System.out.println("Start step: " +getDateTimeNow());
      driver.findElement(By.cssSelector("input[type='text'],[type='password']")).sendKeys("dam@gmail.com");
      System.out.println("End step: " + getDateTimeNow());

      // Case 3: Element khong duoc tim thay
//        System.out.println("Start step: " +getDateTimeNow());
//        driver.findElement(By.cssSelector("input[name='reg_email__']"));
//        System.out.println("End step: " + getDateTimeNow());




    }
    @Test
    public void TC_02_Invisible_In_Dom(){
        List<WebElement> elementList;
        //Case1: Element duoc tim thay chi co 1.
        System.out.println("Start step: " +getDateTimeNow());
        elementList =  driver.findElements(By.cssSelector("input#email"));
        System.out.println("List have: " + elementList.size());
        System.out.println("End step: " + getDateTimeNow());

        //Case 2:Element duoc tim thay.
        System.out.println("Start step: " +getDateTimeNow());
        elementList = driver.findElements(By.cssSelector("input[type='text'],[type='password']"));
        System.out.println("List have: " + elementList.size());
        System.out.println("End step: " + getDateTimeNow());

//        // Case 3: Element khong duoc tim thay
//        System.out.println("Start step: " +getDateTimeNow());
//        driver.findElement(By.cssSelector("input[name='reg_email__']"));
//        System.out.println("List have: " + elementList.size());
//        System.out.println("End step: " + getDateTimeNow());
    }

    @Test
    public void TC_02_Invisible_Not_In_Dom(){


    }

    @Test
    public void TC_03_Presence(){

    }

    @Test
    public void TC_04_Staleness(){


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
    public static String getDateTimeNow(){
        Date date = new Date();
        return date.toString();
    }




}
