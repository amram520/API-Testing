package e2e.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

public class Base {
int id = 0;
    @BeforeMethod
    public void before(){
        id++;
        System.out.println("this before test"+id);
    }

    @AfterMethod
    public void after(){
        System.out.println("this after test");
    }
}
