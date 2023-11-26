package selenium.webdriver;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class Topic_17_Shadown_DOM {
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
    public void TC_01_(){
        driver.get("https://automationfc.github.io/shadow-dom/");
        sleepInSecond(5);
        WebElement shadowHostElement = driver.findElement(By.cssSelector("div#shadow_host"));
        SearchContext shadowRootContext =  shadowHostElement.getShadowRoot();
        String someText = shadowRootContext.findElement(By.cssSelector("span#shadow_content>span")).getText();
        System.out.println(someText);
        Assert.assertEquals(someText,"some text");

        WebElement checkboxShadow = shadowRootContext.findElement(By.cssSelector("input[type='checkbox']"));
        Assert.assertFalse(checkboxShadow.isSelected());

        List<WebElement> allInput = shadowRootContext.findElements(By.cssSelector("input"));
        System.out.println(allInput.size());

        WebElement nestedShadowHostElement = shadowRootContext.findElement(By.cssSelector("div#nested_shadow_host"));
        SearchContext nestedShadowHostContext = nestedShadowHostElement.getShadowRoot();

         String nestText = nestedShadowHostContext.findElement(By.cssSelector("div#nested_shadow_content>div")).getText();
         Assert.assertEquals(nestText,"nested text");
    }
    @Test
    public void TC_02_Random_In_DOM(){
        driver.get("https://shopee.vn/");
        sleepInSecond(5);

        WebElement shadowHostElement = driver.findElement(By.cssSelector("shopee-banner-popup-stateful"));
        SearchContext shadownRootContext = shadowHostElement.getShadowRoot();

        //verify popup hiển thị
        if(shadownRootContext.findElements(By.cssSelector("div.home-popup__content")).size()>0 && shadownRootContext.findElements(By.cssSelector("div.home-popup__content")).get(0).isDisplayed()){
            shadownRootContext.findElement(By.cssSelector("div.shopee-popup__close-btn")).click();
            sleepInSecond(3);
        }

        //ko hiển thị/ đã bị đóng rồi qua step Search dữ liệu
        driver.findElement(By.cssSelector("input.shopee-searchbar-input__input")).sendKeys("iphone 15 Pro Max");
        sleepInSecond(3);

        driver.findElement(By.cssSelector("button.shopee-searchbar__search-button")).click();
        sleepInSecond(3);
    }

    @Test
    public void TC_03_Random_Not_In_DOM(){

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
