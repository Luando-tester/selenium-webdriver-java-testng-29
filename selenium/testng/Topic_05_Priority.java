package selenium.testng;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Topic_05_Priority {
    WebDriver driver;

    @BeforeClass(alwaysRun = true)
    public void beforeClass(){
        System.out.println("Pr-condition for below testcases");

    }
    @Test(priority = 1)
    public void test01(){
        System.out.println("Run testcase 01");
    }

    @Test(priority = 2)
    public void test02(){
        System.out.println("Run testcase 02");
    }

    @Test(priority = 3)
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
