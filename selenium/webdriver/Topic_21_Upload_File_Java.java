package selenium.webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.time.Duration;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class Topic_21_Upload_File_Java {
    WebDriver driver;

    Actions actions;

    JavascriptExecutor jsExecutor;
    String fullName;
    WebDriverWait explicitWait;
    String projectPath = System.getProperty("user.dir");


    String hcmName = "HoChiMinh.jpg";

    String hnName = "HaNoi.jpg";

    String dnName = "DaNang.jpg";

    String hcmFilePath = projectPath + File.separator + "\\UploadFiles\\" + File.separator +  hcmName;

    String hnFilePath = projectPath + File.separator + "\\UploadFiles\\" + File.separator + hnName;

    String dnFilePath = projectPath + File.separator + "\\UploadFiles\\" + File.separator + dnName;


    @BeforeClass
    public void beforeClass(){
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

    }
    @Test
    public void TC_01_Singgle_File(){
        driver.get("https://blueimp.github.io/jQuery-File-Upload");

       By uploadBy = By.cssSelector("input[name='files[]']");

       driver.findElement(uploadBy).sendKeys(hcmFilePath);
       sleepInSecond(2);

        driver.findElement(uploadBy).sendKeys(hnFilePath);
        sleepInSecond(2);

        driver.findElement(uploadBy).sendKeys(dnFilePath);
        sleepInSecond(2);

        Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name' and text()='"+hcmName+"']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name' and text()='"+hnName+"']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name' and text()='"+dnName+"']")).isDisplayed());

        List<WebElement> startButtons = driver.findElements(By.cssSelector("td>button.start"));

        for(WebElement button : startButtons){
            button.click();
            sleepInSecond(2);
        }

        Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name']/a[@title='"+hcmName+"']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name']/a[@title='"+hnName+"']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name']/a[@title='"+dnName+"']")).isDisplayed());

    }
    @Test
    public void TC_02_Multilple_File(){
        driver.get("https://blueimp.github.io/jQuery-File-Upload");

        By uploadBy = By.cssSelector("input[name='files[]']");

        driver.findElement(uploadBy).sendKeys(hcmFilePath + "\n" + hnFilePath + "\n" + dnFilePath );
        sleepInSecond(2);

        Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name' and text()='"+hcmName+"']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name' and text()='"+hnName+"']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name' and text()='"+dnName+"']")).isDisplayed());



        List<WebElement> startButtons = driver.findElements(By.cssSelector("td>button.start"));

        for(WebElement button : startButtons){
            button.click();
            sleepInSecond(2);
        }

        Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name']/a[@title='"+hcmName+"']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name']/a[@title='"+hnName+"']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name']/a[@title='"+dnName+"']")).isDisplayed());
    }

    @Test
    public void TC_03_TechPanda(){


    }
    @Test
    public void TC_04_Selenium_Version_4(){

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




}
