package e2e.tests;

import e2e.TestCase;
import e2e.tests.BaseTest;
import il.co.topq.difido.model.Enums;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

import static utils.Utilities.getScreenShot;

public class TestNGListeners extends BaseTest implements ITestListener {
    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("The test: " + result.getName() + " start");
    }
    @Override
    public void onTestSuccess(ITestResult result) {
        report.log("The test: " + result.getName()+ " succeed", Enums.Status.success);
        getScreenShot(page, result.getName()+"succeed");
        report.addImage(new File("./snapshot/"+result.getName()+"succeed.png"), "succeed");
    }
    @Override
    public void onTestFailure(ITestResult result) {
        report.log("The test: " + result.getName() + " failed", Enums.Status.failure);
        getScreenShot(page, result.getName()+"failed");
        report.addImage(new File("./snapshot/"+result.getName()+"failed.png"), "failed");
    }
    @Override
    public void onTestSkipped(ITestResult result) {

    }
    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
    }
    @Override

    public  void onTestFailedWithTimeout(ITestResult result) {
        this.onTestFailure(result);
    }
    @Override
    public void onStart(ITestContext context) {
        System.out.println("The test"+context.getName()+" is start");
    }
    @Override
    public void onFinish(ITestContext context) {
        System.out.println("The test"+context.getName()+" is finish");


    }
}
