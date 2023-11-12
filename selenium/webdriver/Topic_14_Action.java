package selenium.webdriver;

import org.openqa.selenium.*;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.HasDevTools;
import org.openqa.selenium.devtools.v114.network.Network;
import org.openqa.selenium.devtools.v114.network.model.Headers;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import javax.swing.*;
import java.time.Duration;
import java.util.*;

public class Topic_14_Action {
    WebDriver driver;

    Actions actions;

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
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

    }


    @Test
    public void TC_01_JQuery() {
//        actions.click(driver.findElement(By.xpath(""))).perform();
//        actions.clickAndHold(driver.findElement(By.xpath("nguồn"))).moveToElement(driver.findElement(By.xpath("đích"))).release().perform();
          driver.get("https://automationfc.github.io/jquery-tooltip/");

          actions.moveToElement(driver.findElement(By.cssSelector("input#age"))).perform();
          sleepInSecond(3);

          Assert.assertEquals(driver.findElement(By.cssSelector("div.ui-tooltip-content")).getText(),"We ask for your age only for statistical purposes.");
    }

    @Test
    public void TC_02_Login() {
        driver.get("https://www.fahasa.com/");
        actions.moveToElement(driver.findElement(By.cssSelector("span.icon_menu"))).perform();
        sleepInSecond(2);
        actions.moveToElement(driver.findElement(By.xpath("//a[@title='Bách Hóa Online - Lưu Niệm']"))).perform();
        sleepInSecond(2);

        driver.findElement(By.xpath("//div[contains(@class,'fhs_menu_content')]//a[text()='Thiết Bị Số - Phụ Kiện Số']")).click();
        sleepInSecond(2);

        Assert.assertEquals(driver.findElement(By.cssSelector("ol.breadcrumb strong")).getText(),"THIẾT BỊ SỐ - PHỤ KIỆN SỐ");

        Assert.assertTrue(driver.findElement(By.xpath("//ol[@class='breadcrumb']//strong[text()='Thiết Bị Số - Phụ Kiện Số']")).isDisplayed());
    }
    @Test
    public void TC_03_Login() {
        driver.get("https://automationfc.github.io/jquery-selectable/");

        List<WebElement> allNumbers = driver.findElements(By.cssSelector("li.ui-state-default"));

        Assert.assertEquals(allNumbers.size(),20);

        actions.clickAndHold(allNumbers.get(0)).pause(2000).moveToElement(allNumbers.get(14)).pause(2000).release().perform();

        sleepInSecond(3);

        List<String>  allNumbersTextExpected = new ArrayList<String>();
        allNumbersTextExpected.add("1");
        allNumbersTextExpected.add("2");
        allNumbersTextExpected.add("3");
        allNumbersTextExpected.add("5");
        allNumbersTextExpected.add("6");
        allNumbersTextExpected.add("7");
        allNumbersTextExpected.add("9");
        allNumbersTextExpected.add("10");
        allNumbersTextExpected.add("11");
        allNumbersTextExpected.add("13");
        allNumbersTextExpected.add("14");
        allNumbersTextExpected.add("15");


        List<WebElement> allNumbersSelected = driver.findElements(By.cssSelector("li.ui-state-default.ui-selected"));

        Assert.assertEquals(allNumbersSelected.size(),12);
        List<String> allNumbersTextActual = new ArrayList<String>();

        for(WebElement element : allNumbersSelected){
            allNumbersTextActual.add(element.getText());
        }

        Assert.assertEquals(allNumbersTextExpected,allNumbersTextActual);
    }
    @Test
    public void TC_04_Login() {
        driver.get("https://automationfc.github.io/jquery-selectable/");

        Keys cmdCtrl = Platform.getCurrent().is(Platform.WINDOWS) ? Keys.CONTROL : Keys.COMMAND;
        List<WebElement> allNumber = driver.findElements(By.cssSelector("li.ui-state-default"));
        Assert.assertEquals(allNumber.size(),20);

        actions.clickAndHold(allNumber.get(0)).moveToElement(allNumber.get(11)).release().perform();
        actions.keyDown(Keys.CONTROL).perform();

        actions.keyDown(cmdCtrl).perform();
        actions.click(allNumber.get(12)).click(allNumber.get(14)).release().keyUp(Keys.CONTROL).perform();
        sleepInSecond(3);

        for(int i = 0; i < allNumber.size();i++){
            actions.keyDown(cmdCtrl).perform();
            if(i < 15){
                actions.click(allNumber.get(i));
            }
            actions.perform();
        }

    }
    @Test
    public void TC_05_Login() {
    }
    @Test
    public void TC_06_Login() {


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

    public String getEmailAddress() {
        Random rand = new Random();
        return  "kevinlamp" + rand.nextInt(99999) + "@gmail.net";

    }

    public void checkToElement(By byXpath) {
        if(!driver.findElement(byXpath).isSelected()){
            driver.findElement(byXpath).click();
            sleepInSecond(2);
        }
    }

    public void uncheckToElement(By byXpath) {
        if(driver.findElement(byXpath).isSelected()){
            driver.findElement(byXpath).click();
            sleepInSecond(2);
        }
    }

    public void selectItemInDropDown(String parentCss, String childItemCss,String itemTextExpected) {
        driver.findElement(By.cssSelector(parentCss)).click(); //"span#number-button"

        List<WebElement> allItems = explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector(childItemCss)));//"ul#number-menu div"
        for (WebElement item : allItems) {
            if(item.getText().equals(itemTextExpected)){
                item.click();
                break;
            }
        }
    }
    public void selectItemInEditableDropDown(String parentCss, String childItemCss,String itemTextExpected) {
        driver.findElement(By.cssSelector(parentCss)).click(); //"span#number-button"

        List<WebElement> allItems = explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector(childItemCss)));//"ul#number-menu div"
        for (WebElement item : allItems) {
            if(item.getText().equals(itemTextExpected)){
                item.click();
                break;
            }
        }
    }


}