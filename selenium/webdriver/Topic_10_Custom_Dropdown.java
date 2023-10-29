package selenium.webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;
import java.util.Random;

public class Topic_10_Custom_Dropdown {
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

        driver.get("https://jqueryui.com/resources/demos/selectmenu/default.html");

        selectItemInDropDown("span#speed-button","ul#speed-menu div","Faster");
        sleepInSecond(3);

        driver.navigate().refresh();
        selectItemInDropDown("span#files-button","ul#files-menu div", "ui.jQuery.js");
        sleepInSecond(3);

        selectItemInDropDown("span#number-button","ul#number-menu div", "15");
        sleepInSecond(3);

        selectItemInDropDown("span#salutation-button","ul#salutation-menu div", "Dr.");
        sleepInSecond(3);

        Assert.assertEquals(driver.findElement(By.cssSelector("span#speed-button>span.ui-selectmenu-text")).getText(),"Medium");
        Assert.assertEquals(driver.findElement(By.cssSelector("span#files-button>span.ui-selectmenu-text")).getText(),"ui.jQuery.js");
        Assert.assertEquals(driver.findElement(By.cssSelector("span#number-button>span.ui-selectmenu-text")).getText(),"15");
        Assert.assertEquals(driver.findElement(By.cssSelector("span#salutation-button>span.ui-selectmenu-text")).getText(),"Dr.");
    }

    @Test
    public void TC_02_Login() {
        driver.get("https://react.semantic-ui.com/maximize/dropdown-example-selection/");
        selectItemInDropDown("i.dropdown.icon","div.item>span.text","Christian");
        Assert.assertEquals(driver.findElement(By.cssSelector("div.divider.text")).getText(),"Christian");
        sleepInSecond(3);

        selectItemInDropDown("i.dropdown.icon","div.item>span.text","Jenny Hess");
        Assert.assertEquals(driver.findElement(By.cssSelector("div.divider.text")).getText(),"Jenny Hess");
        sleepInSecond(3);

        selectItemInDropDown("i.dropdown.icon","div.item>span.text","Justen Kitsune");
        Assert.assertEquals(driver.findElement(By.cssSelector("div.divider.text")).getText(),"Justen Kitsune");
        sleepInSecond(3);
    }
    @Test
    public void TC_03_Login() {
        driver.get("https://mikerodham.github.io/vue-dropdowns/ ");
        selectItemInDropDown("li.dropdown-toggle","ul.dropdown-menu a", "Second Option");
        Assert.assertEquals(driver.findElement(By.cssSelector("li.dropdown-toggle")).getText(),"Second Option");
        sleepInSecond(3);

        selectItemInDropDown("li.dropdown-toggle","ul.dropdown-menu a", "First Option");
        Assert.assertEquals(driver.findElement(By.cssSelector("li.dropdown-toggle")).getText(),"First Option");
        sleepInSecond(3);

        selectItemInDropDown("li.dropdown-toggle","ul.dropdown-menu a", "Third Option");
        Assert.assertEquals(driver.findElement(By.cssSelector("li.dropdown-toggle")).getText(),"Third Option");
        sleepInSecond(3);
    }
    @Test
    public void TC_04_Login() {
        driver.get("https://react.semantic-ui.com/maximize/dropdown-example-search-selection/");
        selectItemInEditableDropDown("input.search","div.item span","Algeria");
        Assert.assertEquals(driver.findElement(By.cssSelector("div.divider.text")).getText(),"Algeria");
        sleepInSecond(3);

        selectItemInEditableDropDown("input.search","div.item span","Australia");
        Assert.assertEquals(driver.findElement(By.cssSelector("div.divider.text")).getText(),"Australia");
        sleepInSecond(3);

        selectItemInEditableDropDown("input.search","div.item span","Belgium");
        Assert.assertEquals(driver.findElement(By.cssSelector("div.divider.text")).getText(),"Belgium");
        sleepInSecond(3);

    }
    @Test
    public void TC_05_Login() {
        driver.get("https://demo.nopcommerce.com/register");
        selectItemInDropDown("select[name='DateOfBirthDay']","select[name='DateOfBirthDay']>option","18");
        Assert.assertTrue(driver.findElement(By.cssSelector("select[name='DateOfBirthDay']>option[value='18']")).isSelected());
        sleepInSecond(3);

        selectItemInDropDown("select[name='DateOfBirthMonth']","select[name='DateOfBirthMonth']>option","September");
        Assert.assertTrue(driver.findElement(By.cssSelector("select[name='DateOfBirthMonth']>option[value='9']")).isSelected());
        sleepInSecond(3);

        selectItemInDropDown("select[name='DateOfBirthYear']","select[name='DateOfBirthYear']>option","1995");
        Assert.assertTrue(driver.findElement(By.cssSelector("select[name='DateOfBirthYear']>option[value='1995']")).isSelected());
        sleepInSecond(3);
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