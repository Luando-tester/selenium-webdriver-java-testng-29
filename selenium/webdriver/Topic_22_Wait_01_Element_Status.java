package selenium.webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.time.Duration;
import java.util.List;

public class Topic_22_Wait_01_Element_Status {
    WebDriver driver;

    WebDriverWait explicitWait;
    By reconfirmEmailText = By.cssSelector("input[name='reg_email_confirmation__']");




    @BeforeClass
    public void beforeClass(){
        driver = new FirefoxDriver();
        explicitWait = new WebDriverWait(driver,Duration.ofSeconds(10));
        driver.get("https://www.facebook.com");

    }
    @Test
    public void TC_01_Visible(){
        driver.findElement(By.cssSelector("a[data-testid='open-registration-form-button']")).click();
        sleepInSecond(2);

        driver.findElement(By.cssSelector("input[name='reg_email__']")).sendKeys("dam@gmail.com");
        sleepInSecond(2);
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(reconfirmEmailText));

        Assert.assertTrue(driver.findElement(reconfirmEmailText).isDisplayed());
        driver.findElement(By.xpath("//div[text()='Sign Up']/parent::div/preceding-sibling::img")).click();
        sleepInSecond(3);




    }
    @Test
    public void TC_02_Invisible_In_Dom(){
        driver.findElement(By.cssSelector("a[data-testid='open-registration-form-button']")).click();
        sleepInSecond(2);
        driver.findElement(By.cssSelector("input[name='reg_email__']")).clear();
        sleepInSecond(3);

        explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(reconfirmEmailText));
        Assert.assertFalse(driver.findElement(reconfirmEmailText).isDisplayed());

        driver.findElement(By.xpath("//div[text()='Sign Up']/parent::div/preceding-sibling::img")).click();
        sleepInSecond(3);
    }

    @Test
    public void TC_02_Invisible_Not_In_Dom(){
        driver.findElement(By.cssSelector("a[data-testid='open-registration-form-button']")).click();
        sleepInSecond(2);
        driver.findElement(By.xpath("//div[text()='Sign Up']/parent::div/preceding-sibling::img")).click();
        sleepInSecond(3);

        explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(reconfirmEmailText));

    }

    @Test
    public void TC_03_Presence(){
        driver.findElement(By.cssSelector("a[data-testid='open-registration-form-button']")).click();
        sleepInSecond(2);

        driver.findElement(By.cssSelector("input[name='reg_email__']")).sendKeys("dam@gmail.com");

        explicitWait.until(ExpectedConditions.presenceOfElementLocated(reconfirmEmailText));

        driver.findElement(By.cssSelector("input[name='reg_email__']")).clear();
        sleepInSecond(3);

        explicitWait.until(ExpectedConditions.presenceOfElementLocated(reconfirmEmailText));

        driver.findElement(By.xpath("//div[text()='Sign Up']/parent::div/preceding-sibling::img")).click();
        sleepInSecond(3);
    }

    @Test
    public void TC_04_Staleness(){
        driver.findElement(By.cssSelector("a[data-testid='open-registration-form-button']")).click();
        sleepInSecond(3);

        WebElement reconfirmEmail = driver.findElement(reconfirmEmailText);
        driver.findElement(By.xpath("//div[text()='Sign Up']/parent::div/preceding-sibling::img")).click();
        sleepInSecond( 3);

        explicitWait.until(ExpectedConditions.stalenessOf(reconfirmEmail));

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
