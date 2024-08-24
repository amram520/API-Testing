package e2e.tests;

import com.microsoft.playwright.*;
import e2e.TestCase;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.File;
import java.lang.reflect.Method;
import java.nio.file.FileSystem;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BaseTest extends TestCase {

    protected Page page;
     Browser browser;
     Playwright playwright;
     BrowserContext context;


@BeforeMethod
    public void init(){
    playwright = Playwright.create();
    browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
    context = browser.newContext(new Browser.NewContextOptions().setRecordVideoDir(Paths.get("videos/"))
            .setRecordVideoSize(1280, 720));
    page = context.newPage();
    page.navigate("http://localhost:8080/");
}



@AfterMethod
    public void closeBrowser(ITestResult result){
    String path = System.getProperty("user.dir");
    String testName =result.getMethod().getMethodName();
    Path videoName =  page.video().path().getFileName();
    page.close();
    context.close();
    browser.close();
    File file1 = new File(path+File.separator+"videos"+File.separator+videoName);
    File file2 = new File(path+File.separator+"videos"+File.separator+testName+".webm");
    file1.renameTo(file2);
    playwright.close();
}
}
