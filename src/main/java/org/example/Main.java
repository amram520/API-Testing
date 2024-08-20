package org.example;

import com.microsoft.playwright.*;
import okio.Path;
import org.testng.Assert;

import java.io.IOException;
import java.nio.file.Paths;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class Main {
    public static void main(String[] args) {
        Playwright playwright = Playwright.create();
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
            Page page = browser.newPage();
            page.navigate("http://localhost:8080/");
            System.out.println(page.title());
        Assert.assertEquals(page.title(), "Sign in | OpenProject");
            page.locator("#username").fill("admin");
           Locator pass = page.locator("id=password");
           pass.fill("1234567890");
           pass.press("Enter");
            System.out.println(page.title());
        try{assertThat(page).hasTitle("OpenProject");}
        catch (AssertionError e){
            e.printStackTrace();
            System.exit(1);
        }
        Page.ScreenshotOptions screenshotOptions = new Page.ScreenshotOptions();
        page.screenshot(screenshotOptions.setFullPage(true).setPath(Paths.get("./snapshot/pagePhoto.jpg")));
        page.locator("#projects-menu").click();
            page.close();
            browser.close();
            playwright.close();

        }
    }
