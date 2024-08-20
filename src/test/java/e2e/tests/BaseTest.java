package e2e.tests;

import com.microsoft.playwright.*;
import org.testng.annotations.*;

import java.nio.file.Paths;

public class BaseTest {

    protected Page page;
     Browser browser;
     Playwright playwright;
//     BrowserContext context;


@BeforeTest
    public void init(){
    playwright = Playwright.create();
    browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
//    context = browser.newContext(new Browser.NewContextOptions().setRecordVideoDir(Paths.get("videos/")));
    page = browser.newPage();
    page.navigate("http://localhost:8080/");
}

@AfterTest
    public void closeBrowser(){
    page.close();
//    context.close();
    browser.close();
    playwright.close();
}
}
