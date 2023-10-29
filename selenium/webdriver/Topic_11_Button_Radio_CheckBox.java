package selenium.webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;
import java.util.Random;

public class Topic_11_Button_Radio_CheckBox {
    WebDriver driver;

    WebDriverWait explicitWait;
    String projectPath = System.getProperty("user.dir");

    @BeforeClass
    public void beforeClass(){
        driver = new FirefoxDriver();

        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(30));

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

    }


    @Test
    public void TC_01_JQuery() {

//        driver.findElement(By.cssSelector("span#number-button")).click();
//        sleepInSecond(5);
//        explicitWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("ul#number-menu div")));
//
//        List<WebElement> allItems = driver.findElements(By.cssSelector("ul#number-menu div"));
//
//        for (WebElement item : allItems) {
//           String textItem = item.getText();
//           if (textItem == ("8")){
//               item.click();
//               break;
//           }
//        }

       driver.get("https://egov.danang.gov.vn/reg");

       WebElement registerButton = driver.findElement(By.cssSelector("input.egov-button"));

       Assert.assertFalse(registerButton.isEnabled());

       driver.findElement(By.cssSelector("input#chinhSach")).click();
       sleepInSecond(2);

       Assert.assertTrue(registerButton.isEnabled());

       String registerBackgroundRGB = registerButton.getCssValue("background-color");

       Color registerBackgroundColor = Color.fromString(registerBackgroundRGB);

       String registerBackgroundHexa = registerBackgroundColor.asHex();

       System.out.println("Background color Hexa = " + registerBackgroundHexa);

       Assert.assertEquals(registerBackgroundHexa,"#ef5a00");

    }

    @Test
    public void TC_02_Login() {
        driver.get("https://www.fahasa.com/customer/account/create");
        driver.findElement(By.cssSelector("li.popup-login-tab-login")).click();
        sleepInSecond(2);

        WebElement loginButton = driver.findElement(By.cssSelector("li.popup-login-tab-login"));

        Assert.assertTrue(loginButton.isEnabled());

        Assert.assertEquals(Color.fromString(loginButton.getCssValue("background-color")).asHex().toLowerCase(),"#000000");

        driver.findElement(By.cssSelector("input#login_username")).sendKeys("dam@gmail.com");
        driver.findElement(By.cssSelector("input#login_password")).sendKeys("123456");
        sleepInSecond(2);

        Assert.assertTrue(loginButton.isEnabled());

        Assert.assertEquals(Color.fromString(loginButton.getCssValue("background-color")).asHex().toLowerCase(),"#000000");

        driver.findElement(By.cssSelector("input#login_username")).sendKeys("dam@gmail.com");
        driver.findElement(By.cssSelector("input#login_password")).sendKeys("123456");

        Assert.assertTrue(loginButton.isEnabled());

        Assert.assertEquals(Color.fromString(loginButton.getCssValue("background-color")).asHex().toLowerCase(),"#000000"); //#c92127


    }
    @Test
    public void TC_03_Login() {

    }
    @Test
    public void TC_04_Login() {


    }
    @Test
    public void TC_05_Login() {

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