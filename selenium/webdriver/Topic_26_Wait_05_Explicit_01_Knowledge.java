package selenium.webdriver;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Topic_26_Wait_05_Explicit_01_Knowledge {
    WebDriver driver;
    WebDriverWait explicitWait;

    WebDriverWait webDriverWait = new WebDriverWait(driver,Duration.ofSeconds(10));

    @BeforeClass
    public void beforeClass(){
        driver = new FirefoxDriver();
        explicitWait = new WebDriverWait(driver,Duration.ofSeconds(10));

        explicitWait = new WebDriverWait(driver,Duration.ofSeconds(10),Duration.ofMillis(300));

    }
    @Test
    public void TC_01_() {
        Alert alert = explicitWait.until(ExpectedConditions.alertIsPresent());
        explicitWait.until(ExpectedConditions.stalenessOf(driver.findElement(By.cssSelector(""))));
        explicitWait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("form#search-form input#live-search-bar")));
        explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector("")));
        explicitWait.until(ExpectedConditions.presenceOfNestedElementLocatedBy(By.cssSelector("form#search-form"),By.cssSelector("input#live-search-bar")));

        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("")));
        explicitWait.until(ExpectedConditions.visibilityOfAllElements(driver.findElement(By.cssSelector(""))));
        explicitWait.until(ExpectedConditions.visibilityOfAllElements(driver.findElement(By.cssSelector("")),driver.findElement(By.cssSelector(""))));
        explicitWait.until(ExpectedConditions.visibilityOfAllElements(driver.findElement(By.cssSelector("")),driver.findElement(By.cssSelector("")),driver.findElement(By.cssSelector(""))));
        explicitWait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("")));
        explicitWait.until(ExpectedConditions.titleIs("Create New Customer Account"));
        driver.getTitle();

        explicitWait.until(ExpectedConditions.and(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector("")),ExpectedConditions.visibilityOfElementLocated(By.cssSelector(""))));

        explicitWait.until(ExpectedConditions.attributeContains(By.cssSelector("input#search"),"placeholder","Search entire"));
        explicitWait.until(ExpectedConditions.attributeContains(By.cssSelector("input#search"),"placeholder","Store here..."));
        explicitWait.until(ExpectedConditions.attributeContains(By.cssSelector("input#search"),"placeholder","Search entire store here..."));

        explicitWait.until(ExpectedConditions.attributeToBe(By.cssSelector("input#search"),"placeholder","Search entire store here..."));

        explicitWait.until(ExpectedConditions.attributeToBeNotEmpty(driver.findElement(By.cssSelector("input#search")),"placeholder"));

        explicitWait.until(ExpectedConditions.domAttributeToBe(driver.findElement(By.cssSelector("input#search")),"namespaceURI","http://www.w3.org/1999/xhtml"));
        explicitWait.until(ExpectedConditions.domPropertyToBe(driver.findElement(By.cssSelector("input#search")),"namespaceURI","http://www.w3.org/1999/xhtml"));

        explicitWait.until(ExpectedConditions.elementToBeSelected(By.cssSelector("")));
        explicitWait.until(ExpectedConditions.elementSelectionStateToBe(By.cssSelector(""),true));
        explicitWait.until(ExpectedConditions.elementSelectionStateToBe(By.cssSelector(""),false));

        explicitWait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(""));
        explicitWait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(1));

        explicitWait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.cssSelector("")));
        explicitWait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(driver.findElement(By.cssSelector(""))));

        explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("")));
        explicitWait.until(ExpectedConditions.jsReturnsValue("document.documentElement.innerText;"));
        Assert.assertTrue(explicitWait.until(ExpectedConditions.javaScriptThrowsNoExceptions("document.documentElement.innerText;")));

        explicitWait.until(ExpectedConditions.numberOfElementsToBe(By.cssSelector("select[title='Sort By']>option"),6));
        explicitWait.until(ExpectedConditions.numberOfElementsToBeLessThan(By.cssSelector("select[title='Sort By']>option"),6));
        explicitWait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.cssSelector("select[title='Sort By']>opti00on"),6));

        explicitWait.until(ExpectedConditions.numberOfWindowsToBe(3));
        explicitWait.until(ExpectedConditions.textToBe(By.cssSelector("div.category-title>h1"),"Mobile"));

        Pattern pattern = Pattern.compile("w3schools",Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher("Visit W3Schools!");

        explicitWait.until(ExpectedConditions.textMatches(By.cssSelector("div.category-description"),pattern));
        explicitWait.until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector("div.category-title>h1"),"This is root of mobile"));

        explicitWait.until(ExpectedConditions.urlToBe("http://live.techpnada.org/index.php/mobile.html"));
        explicitWait.until(ExpectedConditions.urlContains("/index.php/mobile.html"));
        explicitWait.until(ExpectedConditions.urlMatches("[^abc]"));

        explicitWait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(By.cssSelector(""))));
    }

    @Test
    public void TC_02_Less_Than_5_Second(){
        driver.get("https://automationfc.github.io/dynamic-loading/");

        driver.findElement(By.cssSelector("div#start>button")).click();

        sleepInSecond(3);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

        Assert.assertEquals(driver.findElement(By.cssSelector("div#finish>h4")).getText(),"Hello World!");

    }

    @Test
    public void TC_03_Greater_Than_5_Second(){
        driver.get("https://automationfc.github.io/dynamic-loading/");

        driver.findElement(By.cssSelector("div#start>button")).click();

        sleepInSecond(10);

        Assert.assertEquals(driver.findElement(By.cssSelector("div#finish>h4")).getText(),"Hello World!");

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
