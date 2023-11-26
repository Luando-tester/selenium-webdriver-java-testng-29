package selenium.webdriver;

import org.openqa.selenium.*;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.HasDevTools;
import org.openqa.selenium.devtools.v114.network.Network;
import org.openqa.selenium.devtools.v114.network.model.Headers;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import javax.swing.*;
import java.awt.*;
import java.awt.event.InputEvent;
import java.io.*;
import java.nio.charset.Charset;
import java.time.Duration;
import java.util.*;
import java.util.List;

public class Topic_14_Action {
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
        driver.get("https://automationfc.github.io/basic-form/");
        WebElement doubleClickButton =  driver.findElement(By.xpath("//button[text()='Double click me']"));

        if(driver.toString().contains("firefox")) {
            javascriptExecutor.executeScript("arguments[0].scrollIntoView(false);",doubleClickButton);
            sleepInSecond(3);
        }


        actions.doubleClick(doubleClickButton).perform();
        sleepInSecond(2);

        Assert.assertEquals(driver.findElement(By.cssSelector("p#demo")).getText(),"Hello Automation Guys!");

        Assert.assertTrue(driver.findElement(By.xpath("//p[@id='demo' and text()='Hello Automation Guys!']")).isDisplayed());
    }
    @Test
    public void TC_06_Login() {
        driver.get("http://swisnl.github.io/jQuery-contextMenu/demo.html");
        actions.contextClick(driver.findElement(By.cssSelector("span.context-menu-one"))).perform();
        sleepInSecond(2);

        Assert.assertTrue(driver.findElement(By.cssSelector("li.context-menu-icon-paste")).isDisplayed());
        actions.moveToElement(driver.findElement(By.cssSelector("li.context-menu-icon-paste"))).perform();
        sleepInSecond(2);

    }
    @Test
    public void TC_07_Login() {
        driver.get("https://automationfc.github.io/kendo-drag-drop/");

        WebElement smallCircle = driver.findElement(By.cssSelector("div#draggable"));
        WebElement bigCircle = driver.findElement(By.cssSelector("div#droptarget"));

        actions.dragAndDrop(smallCircle,bigCircle).perform();
        sleepInSecond(3);

        Assert.assertEquals(bigCircle.getText(),"You did great!");

        Assert.assertEquals(Color.fromString(bigCircle.getCssValue("background-color")).asHex().toLowerCase(),"#03a9f4");
    }
    @Test
    public void TC_08_Login() throws  IOException{
        driver.get("https://automationfc.github.io/drag-drop-html5/");

        String columnA = "div#column-a";
        String columnB = "div#column-b";

        String projectPath = System.getProperty("user.dir");
        String dragAndDropFilePath = projectPath + "/dragAndDrop/drag_and_drop_helper.js";

        String jsContentFile = getContentFile(dragAndDropFilePath);
        jsContentFile =  jsContentFile + "$('"+ columnA + "').simulateDragDrop({ dropTarget: '" + columnB + "' });";
        javascriptExecutor.executeScript(jsContentFile);
        sleepInSecond(3);

        javascriptExecutor.executeScript(jsContentFile);
        sleepInSecond(3);

        Assert.assertEquals(driver.findElement(By.cssSelector("div#column-a>header")).getText(),"A");
        Assert.assertEquals(driver.findElement(By.cssSelector("div#column-b>header")).getText(),"B");
    }

    @Test
    public void TC_09_Login() throws AWTException{
        driver.get("https://automationfc.github.io/drag-drop-html5/");
        dragAndDropHTML5ByXpath("//div[@id='column-a']","//div[@id='column-b']");
        sleepInSecond(3);

        Assert.assertEquals(driver.findElement(By.cssSelector("div#column-a>header")).getText(),"A");
        Assert.assertEquals(driver.findElement(By.cssSelector("div#column-b>header")).getText(),"B");

        dragAndDropHTML5ByXpath("//div[@id='column-a']","//div[@id='column-b']");
        sleepInSecond(3);

        Assert.assertEquals(driver.findElement(By.cssSelector("div#column-a>header")).getText(),"A");
        Assert.assertEquals(driver.findElement(By.cssSelector("div#column-b>header")).getText(),"B");
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

    public String getContentFile(String filePath) throws IOException {
        Charset cs = Charset.forName("UTF-8");
        FileInputStream stream = new FileInputStream(filePath);
        try {
            Reader reader = new BufferedReader(new InputStreamReader(stream, cs));
            StringBuilder builder = new StringBuilder();
            char[] buffer = new char[8192];
            int read;
            while ((read = reader.read(buffer, 0, buffer.length)) > 0) {
                builder.append(buffer, 0, read);
            }
            return builder.toString();
        } finally {
            stream.close();
        }
    }
    public void dragAndDropHTML5ByXpath(String sourceLocator, String targetLocator) throws AWTException {

        WebElement source = driver.findElement(By.xpath(sourceLocator));
        WebElement target = driver.findElement(By.xpath(targetLocator));

        // Setup robot
        Robot robot = new Robot();
        robot.setAutoDelay(500);

        // Get size of elements
        Dimension sourceSize = source.getSize();
        Dimension targetSize = target.getSize();

        // Get center distance
        int xCentreSource = sourceSize.width / 2;
        int yCentreSource = sourceSize.height / 2;
        int xCentreTarget = targetSize.width / 2;
        int yCentreTarget = targetSize.height / 2;

        Point sourceLocation = source.getLocation();
        Point targetLocation = target.getLocation();

        // Make Mouse coordinate center of element
        sourceLocation.x += 20 + xCentreSource;
        sourceLocation.y += 110 + yCentreSource;
        targetLocation.x += 20 + xCentreTarget;
        targetLocation.y += 110 + yCentreTarget;

        // Move mouse to drag from location
        robot.mouseMove(sourceLocation.x, sourceLocation.y);

        // Click and drag
        robot.mousePress(InputEvent.BUTTON1_MASK);
        robot.mousePress(InputEvent.BUTTON1_MASK);
        robot.mouseMove(((sourceLocation.x - targetLocation.x) / 2) + targetLocation.x, ((sourceLocation.y - targetLocation.y) / 2) + targetLocation.y);

        // Move to final position
        robot.mouseMove(targetLocation.x, targetLocation.y);

        // Drop
        robot.mouseRelease(InputEvent.BUTTON1_MASK);
    }


}