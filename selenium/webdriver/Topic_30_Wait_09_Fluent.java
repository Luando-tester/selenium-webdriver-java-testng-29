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
import java.util.NoSuchElementException;
import java.util.function.Function;

public class Topic_30_Wait_09_Fluent {
    WebDriver driver;

    FluentWait<WebDriver> fluentDriver;
    FluentWait<WebElement> fluentElement;

    private long fullTimeoutInSecond = 30;
    private long pollingTimeoutInMilisecond = 300;

    @BeforeClass
    public void beforeClass(){
        driver = new FirefoxDriver();

        fluentDriver = new FluentWait<WebDriver>(driver);

    }
    @Test
    public void TC_01_() {
        driver.get("https://automationfc.github.io/dynamic-loading");

        driver.findElement(By.cssSelector("div#start>button")).click();
        fluentDriver.withTimeout(Duration.ofSeconds(10)).pollingEvery(Duration.ofMillis(100)).ignoring(NoSuchElementException.class);


        String helloText =  fluentDriver.until(new Function<WebDriver, String>() {
            public String apply(WebDriver driver){
                return driver.findElement(By.xpath("//div[@id='finish']/h4")).getText();
            }
        });

        Assert.assertEquals(helloText,"Hello World");

    }
    @Test
    public void TC_02_() {
        driver.get("https://automationfc.github.io/fluent-wait/");

        WebElement countDownTime = driver.findElement(By.cssSelector("div#javascript_countdown_time"));

        fluentElement = new FluentWait<WebElement>(countDownTime);

        fluentElement.withTimeout(Duration.ofSeconds(15)).pollingEvery(Duration.ofMillis(100)).ignoring(NoSuchElementException.class);

        fluentElement.until(new Function<WebElement, Boolean>() {
            @Override
            public Boolean apply(WebElement webElement) {
                String text = webElement.getText();
                System.out.println(text);
                return text.endsWith("00");
            }
        });
    }
    public WebElement waitAndFindElement(By locator){
        FluentWait<WebDriver> fluentDriver = new FluentWait<WebDriver>(driver);
        fluentDriver.withTimeout(Duration.ofSeconds(fullTimeoutInSecond)).pollingEvery(Duration.ofMillis(pollingTimeoutInMilisecond)).ignoring(NoSuchElementException.class);
        return  fluentDriver.until(new Function<WebDriver, WebElement>() {

            @Override
            public WebElement apply(WebDriver webDriver) {
                return webDriver.findElement(locator);
            }
        });
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
