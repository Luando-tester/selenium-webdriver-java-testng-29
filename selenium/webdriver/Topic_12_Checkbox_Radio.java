package selenium.webdriver;

import org.openqa.selenium.*;
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

public class Topic_12_Checkbox_Radio {
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
        driver.get("https://demos.telerik.com/kendo-ui/checkbox/index");

        By rearSideCheckbox = By.xpath("//label[text()='Rear side airbags']/preceding-sibling::input");
        By dualZoneCheckbox = By.xpath("//label[text()='Dual-zone air conditioning']/preceding-sibling::input");

        checkToElement(rearSideCheckbox);
        checkToElement(dualZoneCheckbox
        );


        if(!driver.findElement(rearSideCheckbox).isSelected()){
            driver.findElement(rearSideCheckbox).click();
            sleepInSecond(2);
        }

        if(!driver.findElement(dualZoneCheckbox).isSelected()){
            driver.findElement(dualZoneCheckbox).click();
            sleepInSecond(2);
        }
        sleepInSecond(2);

        Assert.assertTrue(driver.findElement(rearSideCheckbox).isSelected());
        Assert.assertTrue(driver.findElement(dualZoneCheckbox).isSelected());



    }

    @Test
    public void TC_02_Login() {
        driver.get("https://demos.telerik.com/kendo-ui/radiobutton/index");

        By twoPatrolRadio = By.xpath("//label[text()='2.0 Petrol, 147kW']/preceding-sibling::input");
        By twoDieseRadio = By.xpath("//label[text()='2.0 Diesel, 103kW']/preceding-sibling::input");

        checkToElement(twoPatrolRadio);

        Assert.assertTrue(driver.findElement(twoPatrolRadio).isSelected());
        Assert.assertFalse(driver.findElement(twoDieseRadio).isSelected());

        checkToElement(twoDieseRadio);

        Assert.assertFalse(driver.findElement(twoPatrolRadio).isSelected());
        Assert.assertTrue(driver.findElement(twoDieseRadio).isSelected());
    }
    @Test
    public void TC_03_Login() {
        driver.get("https://demos.telerik.com/kendo-ui/radiobutton/index");

        List<WebElement> allCheckboxes = driver.findElements(By.cssSelector("div.form-single-collumn input[type='checkbox']"));

            for(WebElement checkbox: allCheckboxes) {
                if(!checkbox.isSelected()) {
                    checkbox.click();
                    sleepInSecond(1);
                }
            }
            for(WebElement checkbox : allCheckboxes) {
                Assert.assertTrue(checkbox.isSelected());
            }
            driver.manage().deleteAllCookies();
            driver.navigate().refresh();

            allCheckboxes = driver.findElements(By.cssSelector("div.form-single-collumn input[type='checkbox']"));

            for(WebElement checkbox : allCheckboxes) {
                if(checkbox.getAttribute("value").equals("Heart Attack") && !checkbox.isSelected()){
                    checkbox.click();
                    sleepInSecond(3);
                }
            }

            for(WebElement checkbox : allCheckboxes) {
                if(checkbox.getAttribute("value").equals("Heart Attack")){
                    Assert.assertTrue(checkbox.isSelected());
                } else {
                    Assert.assertFalse(checkbox.isSelected());
                }
            }
    }
    @Test
    public void TC_04_Login() {


    }
    @Test
    public void TC_05_Login() {
        driver.get("https://tiemchungcovid19.gov.vn/portal/register-person");

        driver.findElement(By.xpath("//div[text()='Đăng ký cho người thân']/preceding-sibling::div/div[@class='mat-radio-outer-circle']")).click();
        sleepInSecond(3);
        Assert.assertTrue(driver.findElement(By.xpath("//div[text()='Đăng ký cho người thân']/preceding-sibling::div/input")).isSelected());

        By registerRadio = By.xpath("//div[text()='Đăng ký cho người thân']/preceding-sibling::div/input");


        ((JavascriptExecutor)driver).executeScript("arguments[0].click();", driver.findElement(registerRadio));
        sleepInSecond(3);

        Assert.assertTrue(driver.findElement(registerRadio).isSelected());
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