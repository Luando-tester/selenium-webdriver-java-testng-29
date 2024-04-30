package selenium.testng;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Topic_04_AlwayRun {
    WebDriver driver;

    @BeforeClass(alwaysRun = true)
    public void beforeClass(){
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        System.out.println("Run Before Class");

        Assert.assertTrue(false);

    }
    @Test
    public void test01(){
        System.out.println("Run testcase 01");
    }

    @Test
    public void test02(){
        System.out.println("Run testcase 02");
    }

    @Test
    public void test03(){
        System.out.println("Run testcase 03");
    }

    @AfterClass
    public void afterClass(){
        driver.quit();
    }

    private boolean isElementDisplayed(By locator){
        return driver.findElement(locator).isDisplayed();

    }
}
