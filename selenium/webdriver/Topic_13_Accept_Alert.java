package selenium.webdriver;

import org.openqa.selenium.*;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.HasDevTools;
import org.openqa.selenium.devtools.v114.network.Network;
import org.openqa.selenium.devtools.v114.network.model.Headers;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.*;

public class Topic_13_Accept_Alert {
    WebDriver driver;

    WebDriverWait explicitWait;
    String projectPath = System.getProperty("user.dir");


    String username = "admin";
    String password = "admin";
    @BeforeClass
    public void beforeClass(){
        driver = new FirefoxDriver();

        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(30));

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

    }


    @Test
    public void TC_01_JQuery() {
        driver.get("https://automationfc.github.io/basic-form/index.html");

        driver.findElement(By.xpath("//button[text()='Click for JS Alert']")).click();

        By resultText = By.xpath("//p[@id='result']");
        sleepInSecond(3);

        Alert alert = driver.switchTo().alert();

        Assert.assertEquals(alert.getText(),"I am a JS Alert");

        alert.accept();

        sleepInSecond(3);

        Assert.assertEquals(driver.findElement(resultText).getText(),"You clicked an alert successfully");


    }

    @Test
    public void TC_02_Login() {

    }
    @Test
    public void TC_03_Login() {

    }
    @Test
    public void TC_04_Login() {
        String username = "admin";
        String password = "admin";

     // Cách 1 : truyền thẳng user /pass vào url
     // Trick - ByPass
//    driver.get("http://" + username + ": " + password + "@the-internet.herokuapp.com/basic_auth");
//    Assert.assertTrue(driver.findElement(By.xpath("//p[contains(text(),'Congratulation! You must have the proper credenentials')]")).isDisplayed());

        // Cách 2: Từ Page A thao tác lên 1 element nó sẽ qua page B (cần phải thao tác và Auth Alert trước)
        driver.get("http://the-internet.herokuapp.com/");

        String authenLinkUrl =  driver.findElement(By.xpath("//a[text()='Basic Auth']")).getAttribute("href");
        String[] authenArray = authenLinkUrl.split("//");
        driver.get(authenArray[0] + "//" + username + ":" + password + "@" + authenArray[1]);
        Assert.assertTrue(driver.findElement(By.xpath("//p[contains(text(),'Congratulation! You must have the proper credenentials')]")).isDisplayed());


    }
    @Test
    public void TC_05_Login() {

        DevTools devTools = ((HasDevTools) driver).getDevTools();

        devTools.createSession();

        devTools.send(Network.enable(Optional.empty(),Optional.empty(),Optional.empty()));
        Map<String , Object> headers = new HashMap<String, Object>();
        String basicAuthen = "Basic" + new String(new Base64().encode(String.format("%s:%s",username,password).getBytes()));
        headers.put("Authorization", basicAuthen);

        devTools.send(Network.setExtraHTTPHeaders(new Headers(headers)));
        driver.get("https://the-internet.herokuapp.com/basic-auth");
        Assert.assertTrue(driver.findElement(By.xpath("//p[contains(text(),'Congratulation! You must have the proper credenentials')]")).isDisplayed());
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