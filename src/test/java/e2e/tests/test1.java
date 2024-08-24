package e2e.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class test1 extends Base{
    @BeforeMethod
    public void before(){

        System.out.println("this before Meth");
    }


    @Test
    public void check1(){
        System.out.println("this test 1");
    }

    @AfterMethod
    public void after(){
        System.out.println("this after Meth");
    }
}
