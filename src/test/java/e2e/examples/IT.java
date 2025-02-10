package e2e.examples;

import com.microsoft.playwright.*;
import e2e.TestCase;
import il.co.topq.difido.model.Enums;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import lombok.SneakyThrows;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.config.AutoConfig;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.appium.java_client.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;

public class IT extends TestCase {


    private String name;
     Page page;
     AutoConfig cfg;
    Browser browser;
    Playwright playwright;
    BrowserContext context;

    public IT(){

    }
@SneakyThrows
    @Test
    public void testDifferentReportMessages() {
        playwright = Playwright.create();
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(true));
        context = browser.newContext(new Browser.NewContextOptions().setRecordVideoDir(Paths.get("videos/"))
                .setRecordVideoSize(1280, 720));
    context.tracing().start(new Tracing.StartOptions()
            .setScreenshots(true)
            .setSnapshots(true)
            .setSources(true));
        page = context.newPage();
    page.setViewportSize(1280, 720);
        this.cfg = org.aeonbits.owner.ConfigFactory.create(AutoConfig.class);
        page.navigate("https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html");
//        Download download = page.waitForDownload(() -> {
//        page.click("//a[text() = 'https://download.oracle.com/java/17/archive/jdk-17_windows-x64_bin.exe']");
//    });
//        Path path = download.path();
//    File file = new File(path.toString());
//    PDDocument document = PDDocument.
//    PDFTextStripper stripper = new PDFTextStripper();

//    try(FileInputStream fis = new FileInputStream(file)){
//        byte[] header = new byte[4];
//        if(fis.read(header) == 4){
//            String fileHeader = new String(header);
//         if(fileHeader.equals("%PDF"));
//         System.out.println("HEloo");
//        }
//        else {
//            System.out.println("NOOO");
//        }
//    } catch (IOException e){
//        e.printStackTrace();
//    }
//        page.getByLabel("חיפוש", new Page.GetByLabelOptions().setExact(true)).fill("imdb");
//    System.out.println("############  "+page.title());
//        page.keyboard().press("Enter");
//        Thread.sleep(3000);
    Assert.assertEquals("Java Archive Downloads - Java SE 17.0.12 and earlier", page.title());
        report.log("Simple log message");
        report.log("Message with toggle", "The toggle body");
        report.log("Message that fails the test", Enums.Status.success);
        report.logHtml("Html message", "<b>Will appear in bold</b>", Enums.Status.success);
        report.addTestProperty("User", "Itai");
        report.addRunProperty("Build", "1.0.12");
        report.startLevel("<b>Messages will be hidden in this level</b>");
        report.log("Message 1 in toggle");
        report.log("Message 2 in toggle");
        report.log("Message 3 in toggle");
        report.endLevel();
    context.tracing().stop(new Tracing.StopOptions()
            .setPath(Paths.get("trace1.zip")));
        page.close();
        context.close();
        browser.close();
        playwright.close();
    }

    @SneakyThrows
//    @Test
    public void appium(){
        DesiredCapabilities cap = new DesiredCapabilities();
//        cap.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
//        cap.setCapability(MobileCapabilityType.PLATFORM_VERSION,"13");
//        cap.setCapability(MobileCapabilityType.DEVICE_NAME,"G6ORAUNJMBAQ59TK");
//        cap.setCapability(MobileCapabilityType.AUTOMATION_NAME,"UiAutomator2");
        cap.setCapability("deviceName", "Redmi Note 11 Pro");
        cap.setCapability("udid", "G6ORAUNJMBAQ59TK");
        cap.setCapability("platformName", "Android");
        cap.setCapability("platformVersion", "13");
        cap.setCapability("browserName", "Chrome");
        cap.setCapability("chromedriverExecutable","C:\\Users\\Daniel A\\Desktop\\APITestingRetrofit\\src\\test\\driver\\chromedriver.exe");
//        cap.setCapability("appPackage", "com.android.camera");
//        cap.setCapability("appActivity", "com.android.camera.Camera");
//        cap.setCapability(MobileCapabilityType.APP,"C:/Users/Daniel A/Downloads/APKFiles-1/resources/General-Store.apk");

        AppiumDriver<MobileElement> driver = null;
//        WebDriverWait wait = new WebDriverWait(driver, 10);
        try {
            driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), cap);
        } catch (Exception e){
            e.printStackTrace();
        }
        driver.get("https://www.google.com");
        Thread.sleep(5000);
        driver.findElementById("android:id/button1").click();
//        driver.findElementById("android:id/text1").click();
        Thread.sleep(3000);
        driver.findElementById("com.android.permissioncontroller:id/permission_allow_foreground_only_button").click();
//        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.TextView[@resource-id=\"android:id/text1\" and @text=\"Angola\"]")));
        driver.findElement(By.xpath("//android.widget.TextView[@resource-id=\"android:id/text1\" and @text=\"Angola\"]")).click();
        MobileElement name = driver.findElementById("com.androidsample.generalstore:id/nameField");
        name.sendKeys("Mordi");
        MobileElement button = driver.findElementById("com.androidsample.generalstore:id/btnLetsShop");
        button.click();
        Thread.sleep(3000);
        TouchAction action = new TouchAction<>(driver);
        action.press(PointOption.point(500,1500)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1))).moveTo(PointOption.point(500,300)).release().perform();
        driver.quit();
    }

}
