package selenium.webdriver;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Objects;
import java.util.Random;
import java.util.Set;

public class Topic_20_JavascriptExecutor {
    WebDriver driver;

    Actions actions;

    JavascriptExecutor jsExecutor;
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

        jsExecutor = (JavascriptExecutor) driver;

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(30));

    }
    @Test
    public void TC_01_(){
        driver.get("http://live.techpanda.org");
        jsExecutor.executeScript("window.location = 'http://live.techpnada.org'");
        String techPandaDomain = (String) executeforBrowser("return document.domain;");
        Assert.assertEquals(techPandaDomain,"live.techpanda.org");

        String homePageUrl = (String) executeforBrowser("return document.URL;");
        Assert.assertEquals(homePageUrl,"http://live.techpanda.org/");



        highlightElement("//a[text()='Customer Service']");
        clickToElementByJS("//a[text()='Customer Service']");

        String customerTitle = (String) executeforBrowser("return document.title");
        Assert.assertEquals(customerTitle,"Customer Service");

        highlightElement("//a[text()='Mobile']");
        clickToElementByJS("//a[text()='Mobile']");

        highlightElement("//a[text()='Samsung Galaxy']/parent::h2/following-sibling::div[@class='actions']/button");
        clickToElementByJS("//a[text()='Samsung Galaxy']/parent::h2/following-sibling::div[@class='actions']/button");

        Assert.assertTrue(getInnerText().contains("Samsung Galaxy was added to your shopping cart."));

        scrollToBottomPage();

        highlightElement("//input[@id='newsletter']");
        sendkeyToElementByJS("//input[@id='newsletter']",getEmailAddress());

        highlightElement("//button[@title='Subscribe']");
        clickToElementByJS("//button[@title='Subscribe']");

        Assert.assertTrue(isExpectedTextInInnerText("Thank you for your subscription."));

        navigateToUrlByJS("https://www.facebook.com/");
        sleepInSecond(3);

        Assert.assertEquals(executeForBrowser("return document.domain;"),"facebook.com");

    }
    @Test
    public void TC_02_Kyna_English(){

    }

    @Test
    public void TC_03_TechPanda(){


    }
    @Test
    public void TC_04_Selenium_Version_4(){

    }


    @AfterClass
    public void afterClass() {
        //driver.quit();
    }

    public void sleepInSecond (long timeInSecond){
        try{
            Thread.sleep(timeInSecond * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public void switchToWindowByID(String expectedID){
        Set<String> allIDs = driver.getWindowHandles();

        for (String id:allIDs) {
            if (id.equals(expectedID)){
                driver.switchTo().window(id);
                break;
            }
        }
    }

    public Object executeforBrowser(String javaScript) {
        return jsExecutor.executeScript(javaScript);
    }

    public String getInnerText() {
        return (String) jsExecutor.executeScript("return document.documentElement.innerText;");
    }

    public boolean areExpectedTextInInnerText(String textExpected) {
        String textActual = (String) jsExecutor.executeScript("return document.documentElement.innerText.match('"+ textExpected +"')[0];");
        return textActual.equals(textExpected);
    }
    public void switchToWindowByTitle(String expectedTitle) {
        Set<String> allIDs = driver.getWindowHandles();
        for(String id:  allIDs) {
            driver.switchTo().window(id);

            String actualTitle = driver.getTitle();
            if(actualTitle.equals(expectedTitle)){
                break;
            }
        }
    }

    public WebElement getElement(String locator) {
        return driver.findElement(By.xpath(locator));
    }
    public boolean isImageLoaded(String locator) {
        boolean status = (boolean) jsExecutor.executeScript("return argument[0].complete && typeof argument[0].naturalWidth != 'undefined' && arguments[0].naturalWidth > 0",getElement(locator));
        return status;
    }

    public void closeAllWindowWithoutParent(String parentID){
        Set<String> allIDs = driver.getWindowHandles();

        for(String id : allIDs) {
            if(!id.equals(parentID)) {
                driver.switchTo().window(id);
                driver.close();
            }
        }
    }

    public void highlightElement(String locator) {
        WebElement element = getElement(locator);
        String originalStyle = element.getAttribute("style");
        jsExecutor.executeScript("arguments[0].setAttribute('style',arguments[1])" ,element,"border:2px solid red ; border-style: dashed;");
        sleepInSecond(2);
        jsExecutor.executeScript("arguments[0].setAttribute('style',arguments[1])",element,"border: 2px solid red;border-style:dashed");
        sleepInSecond(2);
        jsExecutor.executeScript("arguments[0].setAttribute('style',arguments[1])",element,originalStyle);
    }

    public void clickToElementByJS(String locator) {
        jsExecutor.executeScript("arguments[0].click();",getElement(locator));
        sleepInSecond(3);
    }

    public void scrollToElementOnTop(String locator) {
        jsExecutor.executeScript("arguments[0].scrollIntoView(true);",getElement(locator));
    }

    public void scrollToElementOnDown(String locator) {
        jsExecutor.executeScript("arguments[0.scrollIntoView(false);",getElement(locator));
    }

    public void scrollToBottomPage(){
        jsExecutor.executeScript("window.scrollBy(0,document.body.scrollHeight)");
    }



//    public void sendKeyToElementByJS(String locator,String value) {
//        jsExecutor.executeScript("arguments[0].getAttribute('value','" + value + "')",getElement(locator));
//    }

    public String getAttributeInDOM(String locator, String attributeName) {
        return (String) jsExecutor.executeScript("return arguments[0].getAttribute('"+ attributeName +"');",getElement(locator));
    }

    public String getElementValidatorMessage(String locator) {
        return (String) jsExecutor.executeScript("return arguments[0].validationMessage;)",getElement(locator));
    }
    public Object executeForBrowser(String javaScript) {
        return jsExecutor.executeScript(javaScript);
    }



    public boolean isExpectedTextInInnerText(String textExpected) {
        String textActual = (String) jsExecutor.executeScript("return document.documentElement.innerText.match('" + textExpected + "')[0];");
        return textActual.equals(textExpected);
    }



    public void navigateToUrlByJS(String url) {
        jsExecutor.executeScript("window.location = '" + url + "'");
        sleepInSecond(3);
    }

    public void hightlightElement(String locator) {
        WebElement element = getElement(locator);
        String originalStyle = element.getAttribute("style");
        jsExecutor.executeScript("arguments[0].setAttribute('style', arguments[1])", element, "border: 2px solid red; border-style: dashed;");
        sleepInSecond(2);
        jsExecutor.executeScript("arguments[0].setAttribute('style', arguments[1])", element, originalStyle);
    }

    public void setAttributeInDOM(String locator, String attributeName, String attributeValue) {
        jsExecutor.executeScript("arguments[0].setAttribute('" + attributeName + "', '" + attributeValue +"');", getElement(locator));
    }

    public void removeAttributeInDOM(String locator, String attributeRemove) {
        jsExecutor.executeScript("arguments[0].removeAttribute('" + attributeRemove + "');", getElement(locator));
    }

    public void sendkeyToElementByJS(String locator, String value) {
        jsExecutor.executeScript("arguments[0].setAttribute('value', '" + value + "')", getElement(locator));
    }



    public String getElementValidationMessage(String locator) {
        return (String) jsExecutor.executeScript("return arguments[0].validationMessage;", getElement(locator));
    }

   public String getEmailAddress(){
       Random rand = new Random();
       return "kevinlamp" + rand.nextInt(99999) + "@gmail.net";
   }



}
