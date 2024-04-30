package orangehrm.orders;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Order_1_Search {

    @BeforeClass
    public void init(){
        System.out.println("Pre-Condition for below testcase");
    }

    @Test(groups = "orders")
    public void testSearchWithDate(){

    }
    @Test(groups = "orders")
    public void testSearchWithBilling(){

    }
    @Test(groups = "orders")
    public void testSearchWithProduct(){

    }

    @AfterClass
    public void after(){
        System.out.println("Pre-Condition for below testcase");
    }

}
