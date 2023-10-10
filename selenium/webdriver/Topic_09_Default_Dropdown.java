package selenium.webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;
import java.util.Random;

public class Topic_09_Default_Dropdown {
    WebDriver driver;
    String projectPath = System.getProperty("user.dir");

    String firstname = "Kevin" , lastname = "lamping", emailAddress = getEmailAddress();
    String companyName = "Selenium WebDriver", password = "123456";

    String day = "15" , month = "November", year = "1950" ;

    By EmailAddressBy = By.cssSelector("input#Email");
    @BeforeClass
    public void beforeClass(){
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

    }


    @Test
    public void TC_01_Register() {
        driver.get("https://demo.nopcommerce.com/");
        driver.findElement(By.cssSelector("a.ico-register")).click();

        driver.findElement(By.id("FirstName")).sendKeys(firstname);
        driver.findElement(By.id("LastName")).sendKeys(lastname);

        Select dayDropDown =  new Select(driver.findElement(By.name("DateOfBirthDay")));
        dayDropDown.selectByVisibleText(day);
        dayDropDown.isMultiple();
        driver.findElement(By.name("DateOfBirthDay")) .isEnabled();
        driver.findElement(By.name("DateOfBirthDay")) .isSelected();
        driver.findElement(By.name("DateOfBirthDay")) .isDisplayed();



        Assert.assertFalse(dayDropDown.isMultiple());

        List<WebElement> dayOptions = dayDropDown.getOptions();
        Assert.assertEquals(dayOptions.size(),32);

        new Select(driver.findElement(By.name("DateOfBirthMonth"))).selectByVisibleText(month);
        new Select(driver.findElement(By.name("DateOfBirthYear"))).selectByVisibleText(year);


        driver.findElement(By.id("Email")).sendKeys(emailAddress);
        driver.findElement(By.id("Company")).sendKeys(companyName);
        driver.findElement(By.id("Password")).sendKeys(password);
        driver.findElement(By.id("ConfirmPassword")).sendKeys(password);

        driver.findElement(By.cssSelector("button#register-button")).click();
        sleepInSecond(3);

        Assert.assertEquals(driver.findElement(By.cssSelector("div.result")).getText(),"Your registration completed");

    }

    @Test
    public void TC_02_Login() {
        driver.get("https://demo.nopcommerce.com/");

        driver.findElement(By.cssSelector("a.ico-login")).click();
        driver.findElement(EmailAddressBy).sendKeys(emailAddress);
        driver.findElement(By.cssSelector("input#Password")).sendKeys(password);
        sleepInSecond(2);

        driver.findElement(By.cssSelector("button.login-button")).click();
        sleepInSecond(2);

        driver.findElement(By.cssSelector("a.ico-account")).click();

        Assert.assertEquals(driver.findElement(By.cssSelector("input#FirstName")).getAttribute("value"),firstname);
        Assert.assertEquals(driver.findElement(By.cssSelector("input#LastName")).getAttribute("value"),lastname);

        Assert.assertEquals(new Select(driver.findElement(By.name("DateOfBirthDay"))).getFirstSelectedOption().getText(),day);
        Assert.assertEquals(new Select(driver.findElement(By.name("DateOfBirthMonth"))).getFirstSelectedOption().getText(),month);
        Assert.assertEquals(new Select(driver.findElement(By.name("DateOfBirthYear"))).getFirstSelectedOption().getText(),year);

        new Select(driver.findElement(By.name("DateOfBirthDay"))).getFirstSelectedOption().getText();


        Assert.assertEquals(driver.findElement(EmailAddressBy).getAttribute("value"),emailAddress);
        Assert.assertEquals(driver.findElement(By.cssSelector("input#Company")).getAttribute("value"),companyName);
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


}