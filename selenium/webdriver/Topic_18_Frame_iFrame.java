package selenium.webdriver;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Topic_18_Frame_iFrame {
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
        driver.get("https://www.formsite.com/templates/education/campus-safety-survey/");

        driver.findElement(By.cssSelector("div#imageTemplateContainer>img")).click();
        sleepInSecond(3);

        WebElement formIframe = driver.findElement(By.cssSelector("div#formTemplateContainer>iframe"));

        Assert.assertTrue(formIframe.isDisplayed());

        driver.switchTo().frame(formIframe);

        new Select(driver.findElement(By.cssSelector("select#RESULT_RadioButton-2"))).selectByVisibleText("Sophomore");

        driver.switchTo().defaultContent();

        driver.findElement(By.cssSelector("nav.header--desktop-floater a.menu-item-login")).click();
        sleepInSecond(3);

        driver.findElement(By.cssSelector("button#login")).click();
        sleepInSecond(3);

        Assert.assertEquals(driver.findElement(By.cssSelector("div#message-error")).getText(),"Username and password are both required.");
    }
    @Test
    public void TC_02_Kyna_English(){
        driver.get("https://skills.kynaenglish.vn/");
        driver.switchTo().frame(driver.findElement(By.cssSelector("div.face-content>iframe")));

        Assert.assertEquals(driver.findElement(By.xpath("//a[@title='Kyna.vn']/parent::div/following-sibling::div")).getText(),"169K followers");

        driver.switchTo().defaultContent();

        driver.switchTo().frame("cs_chat_iframe");

        driver.findElement(By.cssSelector("div.button_bar")).click();
        sleepInSecond(3);

        driver.findElement(By.cssSelector("input.input_name")).sendKeys("John Wick");
        driver.findElement(By.cssSelector("input.input_phone")).sendKeys("0987655322");

        new Select(driver.findElement(By.cssSelector("select#serviceSelect"))).selectByVisibleText("TƯ VẤN TUYỂN SINH");
        driver.findElement(By.cssSelector("textarea[name='message']")).sendKeys("Đăng kí khóa học JAVA");
        sleepInSecond(3);

        driver.switchTo().defaultContent();

        driver.findElement(By.cssSelector("input#live-search-bar")).sendKeys("Java");
        sleepInSecond(3);
        driver.findElement(By.cssSelector("button.search-button")).click();
        sleepInSecond(3);

        Assert.assertEquals(driver.findElement(By.cssSelector("div.content>h4")).getText(),"Lập trình Java trong 4 tuần");
    }

    @Test
    public void TC_03_Frame_HDFC_Bank(){
        driver.get("https://netbanking.hdfcbank.com/netbanking");

        driver.switchTo().frame("login_page");

        driver.findElement(By.cssSelector("input[name='fldLoginUserId']")).sendKeys("luis_suarez");
        sleepInSecond(3);

        driver.findElement(By.cssSelector("a.login-btn")).click();
        sleepInSecond(5);

        driver.switchTo().defaultContent();

        driver.findElement(By.cssSelector("input#keyboard")).sendKeys("123456789");
        sleepInSecond(5);


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
