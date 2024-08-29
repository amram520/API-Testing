package e2e.tests;

import com.microsoft.playwright.*;
import e2e.TestCase;
import lombok.SneakyThrows;
import org.config.AutoConfig;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class BaseTest extends TestCase {

    protected Page page;
    protected AutoConfig cfg;
    Browser browser;
    Playwright playwright;
    BrowserContext context;

    @BeforeTest
    public void inits() {
        playwright = Playwright.create();
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        context = browser.newContext(new Browser.NewContextOptions().setRecordVideoDir(Paths.get("videos/"))
                .setRecordVideoSize(1280, 720));
        page = context.newPage();
        this.cfg = org.aeonbits.owner.ConfigFactory.create(AutoConfig.class);
        page.navigate(cfg.url());

    }

    @SneakyThrows
    @AfterTest
    public void closeBrowser() {
//        String path = System.getProperty("user.dir");
//        String testName = result.getMethod().getMethodName();
//        Path videoName = page.video().path().getFileName();
        page.close();
        context.close();
        browser.close();
//        Path isFileExist = Paths.get("").toAbsolutePath().resolve("videos\\" + testName + ".webm");
//        if (Files.exists(isFileExist)) {
//            Files.delete(isFileExist);
            playwright.close();
//        }

    }
}
