package selenium.webdriver;

import org.openqa.selenium.Point;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.event.InputEvent;
import java.io.*;
import java.nio.charset.Charset;
import java.time.Duration;
import java.util.List;
import java.util.Random;

public class Topic_16_Popup_02 {
    WebDriver driver;

    Actions actions;

    JavascriptExecutor javascriptExecutor;
    String fullName;
    WebDriverWait explicitWait;
    String projectPath = System.getProperty("user.dir");

    public String getFullName(){
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName=fullName;
    }

    @BeforeClass
    public void beforeClass(){
        driver = new FirefoxDriver();
        actions = new Actions(driver);
        javascriptExecutor =  (JavascriptExecutor) driver;
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

    }
    @Test
    public void TC_01_Random_In_DOM(){
        driver.get("https://javacodegeeks.com/");

        By newletterPopup= By.cssSelector("div.lepopup-popup-container>div:not([style^='display:none'])");
        if(driver.findElements(newletterPopup).size() > 0 && driver.findElements(newletterPopup).get(0).isDisplayed()){
            System.out.println("Popup hiển thị");
            driver.findElement(By.cssSelector("div.lepopup-popup-container>div:not(style^='display:none']) div.lepopup-element-html-content>a")).click();
        }else {
            System.out.println("Popup ko hiển thị");
        }
        driver.findElement(By.cssSelector("input#search-input")).sendKeys("Agile Testing Explained");
        driver.findElement(By.cssSelector("button#search-submit")).click();
        sleepInSecond(3);

        Assert.assertTrue(driver.findElement(By.xpath("//a[text()='Agile Testing Explained']")).isDisplayed());
    }
    @Test
    public void TC_02_Random_In_DOM(){
        driver.get("https://vnk.edu.vn");

        By marketingPopup = By.cssSelector("div.tve-leads-conserversion-object");

        if(driver.findElement(marketingPopup).isDisplayed()){
            driver.findElement(By.cssSelector("div.tve_ea_thrive_leads_form_close")).click();
            sleepInSecond(3);
            System.out.println("Popup hiển thị");
        }else {
            System.out.println("Popup ko hiển thị");
        }

        driver.findElement(By.xpath("//button[text()='Danh sách khóa học']")).click();
        sleepInSecond(3);

        Assert.assertEquals(driver.findElement(By.cssSelector("div.title-content>h1")).getText(),"Lịch khai giảng");
    }

    @Test
    public void TC_03_Random_Not_In_DOM(){
        driver.get("https://dehieu.vn/");
        By marketingPopup = By.cssSelector("div.popup-content");


        if(driver.findElements(marketingPopup).size()>0 && driver.findElements(marketingPopup).get(0).isDisplayed()){
            System.out.println("Popup hiển thị");
            int heightBrowser = driver.manage().window().getSize().getHeight();
            if(heightBrowser < 1920){
                ((JavascriptExecutor) driver).executeScript("arguments[0].click();",driver.findElement(By.cssSelector("button#close-popup")));
            }else{
                driver.findElement(By.cssSelector("button#close-popup")).click();
            }
//            driver.findElement(By.cssSelector("div.lepopup-popup-container>div:not(style^='display:none']) div.lepopup-element-html-content>a")).click();
            sleepInSecond(3);
        }
    }

    @Test
    public void TC_04_Fixed_Popup_Not_In_DOM_02() {

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
    public WebElement findElement(By locator) {
        if(driver.findElement(By.cssSelector("div.tve-leads-conversion-object")).isDisplayed()) {
            driver.findElement(By.cssSelector("div.tve-leads-conversion-object")).click();
            sleepInSecond(3);
        }
        return driver.findElement(locator);
    }





}
