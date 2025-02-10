package org.example;

import com.microsoft.playwright.*;
import okio.Path;
import org.testng.Assert;

import java.io.IOException;
import java.nio.file.Paths;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class Main {
    public static void main(String[] args) {
//        try (Playwright playwright = Playwright.create()) {
//            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
//            BrowserContext context = browser.newContext();
//
//            // הגדר נתיב זמני להורדות
//            Path downloadsPath = Path.get("downloads");
////            context.setDownloadsPath(downloadsPath.toString());
//
//            Page page = context.newPage();
//
//            // האזנה לאירוע ההורדה
//            page.onDownload(download -> {
//                System.out.println("Download started: " + download.url());
//
//                // שמירה של הקובץ לנתיב מסוים
//                Path filePath = download.saveAs(downloadsPath.resolve(download.suggestedFilename()));
//                System.out.println("Downloaded file saved to: " + filePath);
//
//                // וידוא שהקובץ קיים
//                if (filePath.toFile().exists()) {
//                    System.out.println("File downloaded successfully.");
//                } else {
//                    System.out.println("File download failed.");
//                }
//            });
//
//            // פתח את הדף והורד קובץ
//            page.navigate("https://example.com/download");
//            page.click("a#download-link"); // שנה את הסלקטור בהתאם לצורך
//        }
//    }

    }
}
    
