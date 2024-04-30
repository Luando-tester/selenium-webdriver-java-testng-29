package selenium.testng;

import org.testng.annotations.*;

public class Topic_02_Annotation {
    @BeforeClass
    public void beforeClass(){
        System.out.println("Before Class");
    }
    @AfterClass
    public void afterClass(){
        System.out.println("After Class");
    }
    @BeforeGroups
    public void beforeGroups(){
        System.out.println("Before Groups");
    }

    @AfterGroups
    public void afterGroups(){
        System.out.println("After Groups");
    }

    @BeforeMethod
    public void beforeMethod(){
        System.out.println("Before Method");
    }

    @AfterMethod
    public void afterMethod(){
        System.out.println("After Method");
    }


    @BeforeSuite
    public void beforeSuite(){
        System.out.println("Before Suite");
    }

    @AfterSuite
    public void afterSuite(){
        System.out.println("After Suite");
    }

    @Test
    public void Test(){
        System.out.println("Test");
    }
}
