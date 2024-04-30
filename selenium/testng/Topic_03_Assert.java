package selenium.testng;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Topic_03_Assert {
    WebDriver driver;
    @Test
    public void test01(){
        String fullName = "Automation FC";
        Assert.assertEquals(fullName,"Automation FC","Actual fullName is not the same!");

        Assert.assertTrue(isElementDisplayed(By.cssSelector("")));
        Assert.assertTrue(isElementDisplayed(By.cssSelector("")),"Element is not displayed!");

        Assert.assertFalse(isElementDisplayed(By.cssSelector("")));
    }

    private boolean isElementDisplayed(By locator){
        return driver.findElement(locator).isDisplayed();

    }
}
