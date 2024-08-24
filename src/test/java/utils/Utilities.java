package utils;

import com.microsoft.playwright.Page;

import java.nio.file.Paths;

public class Utilities {

    public static void getScreenShot(Page page, String photoName){
        Page.ScreenshotOptions screenshotOptions = new Page.ScreenshotOptions();
        page.screenshot(screenshotOptions.setFullPage(true).setPath(Paths.get("./snapshot/"+photoName+".png")));
    }
}
