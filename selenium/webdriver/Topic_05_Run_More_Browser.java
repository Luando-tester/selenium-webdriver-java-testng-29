package selenium.webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Topic_05_Run_More_Browser {
    WebDriver driver;
    String projectPath = System.getProperty("user.dir");


    @Test
    public void TC_01_Run_On_Frifox() {
        System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
        driver.get("htpps://www.facebook.com/");
        driver.quit();
    }
    @Test
    public void TC_02_Run_On_Chrome() {
        System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\chromedriver.exe");
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
        driver.get("htpps://www.facebook.com/");
        driver.quit();
    }

    @Test

    public void TC_03_Run_On_Edge() {
        System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\msedgedriver.exe");
        driver = new EdgeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("htpps://www.facebook.com/");
        driver.quit();
    }
    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}