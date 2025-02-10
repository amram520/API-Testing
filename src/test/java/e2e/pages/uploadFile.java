package e2e.pages;

import com.microsoft.playwright.*;
import org.config.AutoConfig;
import org.testng.annotations.Test;

import java.nio.file.Paths;

public class uploadFile {

    static Page page;
    Browser browser;
    Playwright playwright;
    BrowserContext context;

    @Test
    public void upload(){
        playwright = Playwright.create();
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        page = browser.newPage();
        page.navigate("https://davidwalsh.name/demo/multiple-file-upload.php");
        page.locator("//input[@type = 'file']").click();
        page.setInputFiles("//input[@type = 'file']", Paths.get("pom.xml"));
    }
}
