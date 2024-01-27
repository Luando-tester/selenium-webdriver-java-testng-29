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
import java.util.Set;

public class Topic_19_Window_Tab {
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
    public void TC_01_Basic_Form(){
        driver.get("https://automationfc.github.io/basic-form/index.html");

        driver.findElement(By.xpath("//a[text()='GOOGLE']")).click();
        sleepInSecond(3);

        switchToWindowByTitle("Google");

        driver.findElement(By.cssSelector("textarea[name='q']")).sendKeys("Selenium");
        sleepInSecond(3);

        switchToWindowByTitle("Selenium WebDriver");

        driver.findElement(By.xpath("//a[text()='FACEBOOK']")).click();
        sleepInSecond(3);

        switchToWindowByTitle("Facebook – log in or sign up");
        switchToWindowByTitle("Facebook – log in or sign up");

        driver.findElement(By.cssSelector("input#email")).sendKeys("dam@gmail.com");
        sleepInSecond(3);
    }
    @Test
    public void TC_02_Kyna_English(){
        driver.get("https://skills.kynaenglish.vn/");

        driver.findElement(By.cssSelector("div.hotline img[alt='facebook']")).click();
        sleepInSecond(3);

        switchToWindowByTitle("Kyna.vn | Ho Chi Minh city | Facebook");


         driver.findElement(By.cssSelector("form#login_popup_cta_form input[name='email']")).sendKeys("dam@gmail.com");
         sleepInSecond(3);

         switchToWindowByTitle("Kyna.vn - Học online cùng chuyên gia");


         driver.findElement(By.cssSelector("div.hotline img[alt='youtube']")).click();
         sleepInSecond(3);

         switchToWindowByTitle("Kyna.vn - Youtube");
         switchToWindowByTitle("Kyna.vn - Youtube");

         Assert.assertEquals(driver.findElement(By.cssSelector("div#inner-header-container yt-formatted-string#text")).getText(),"Kyna.vn");
    }

    @Test
    public void TC_03_TechPanda(){
        driver.get("http://live.techpanda.org/");

        driver.findElement(By.xpath("//a[text()='Mobile']")).click();
        sleepInSecond(3);

        driver.findElement(By.xpath("//a[@title='Samsung Galaxy']/parent::h2/following-sibling::div[@class='actions']//a[@class='link-compare']")).click();
        sleepInSecond(3);
        Assert.assertEquals(driver.findElement(By.cssSelector("li.success-msg span")).getText(),"The product Samsung Galaxy has been added to comparison list.");

        driver.findElement(By.xpath("//a[@title='Sony Xperia']/parent::h2/following-sibling::div[@class='actions']//a[@class='link-compare']")).click();
        sleepInSecond(3);
        Assert.assertEquals(driver.findElement(By.cssSelector("li.success-msg span")).getText(),"The product Sony Xperia has been added to comparison list.");

        driver.findElement(By.xpath("//button[@title='Compare']")).click();

        driver.findElement(By.xpath("//a[@title='IPhone']/parent::h2/following-sibling::div[@class='actions']//a[@class='link-compare']")).click();
        sleepInSecond(3);
        Assert.assertEquals(driver.findElement(By.cssSelector("li.success-msg span")).getText(),"The product IPhone has been added to comparison list.");

        driver.findElement(By.xpath("//button[@title='Compare']")).click();
        sleepInSecond(3);

        switchToWindowByTitle("Products Comparison List - Magento Commerce");

        Assert.assertEquals(driver.findElement(By.cssSelector("div.page-title>h1")).getText(),"COMPARE PRODUCTS");

        switchToWindowByTitle("Products Comparison List - Magento Commerce");

        Assert.assertEquals(driver.findElement(By.cssSelector("div.page-title>h1")).getText(),"COMPARE PRODUCTS");

        switchToWindowByTitle("Mobile");

        driver.findElement(By.cssSelector("input#search")).sendKeys("Samsung Galaxy");
        sleepInSecond(3);

    }
    @Test
    public void TC_04_Selenium_Version_4(){
        driver.get("https://skills.kynaenglish.vn/");
        System.out.println("Driver ID Kyna = "+ driver.toString());
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());


        driver.switchTo().newWindow(WindowType.WINDOW).get("https://skills.kynaenglish.vn/phan-tich-ky-thuat-trong-chung-khoan");
        System.out.println("Driver ID = " + driver.toString());
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());

        driver.findElement(By.cssSelector("a.crs-btn-buy")).click();
        sleepInSecond(3);

        driver.switchTo().newWindow(WindowType.TAB).get("https://www.facebook.com/kyna.vn");
        System.out.println("Driver ID =" + driver.toString());
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());
        driver.findElement(By.cssSelector("form#login_popup_cta_form input[name='email']")).sendKeys("dam@gmail.com");
        sleepInSecond(3);


        switchToWindowByTitle("Kyna.vn - Học online cùng chuyên gia");
        switchToWindowByTitle("Kyna.vn - Học online cùng chuyên gia");

        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());
        
        driver.findElement(By.cssSelector("input#live-search-bar")).sendKeys("Java");
        sleepInSecond(3);
        driver.findElement(By.cssSelector("button.search-button")).click();
        sleepInSecond(3);

        Assert.assertEquals(driver.findElement(By.cssSelector("div.content>h4")).getText(),"Lập trình Java trong 4 tuần");


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
    public void switchToWindowByID(String expectedID){
        Set<String> allIDs = driver.getWindowHandles();

        for (String id:allIDs) {
            if (id.equals(expectedID)){
                driver.switchTo().window(id);
                break;
            }
        }
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
    public void closeAllWindowWithoutParent(String parentID){
        Set<String> allIDs = driver.getWindowHandles();

        for(String id : allIDs) {
            if(!id.equals(parentID)) {
                driver.switchTo().window(id);
                driver.close();
            }
        }
    }

}
