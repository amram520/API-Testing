package e2e.tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class test2 extends Base{

    @BeforeClass
    public void tt(){
        System.out.println("before class");
    }
    @Test
    public void check2(){
        System.out.println("this tes2");
    }
}
