package e2e.examples;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import lombok.SneakyThrows;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import java.net.URL;
import java.util.HashMap;

public class BrowserStack {
@SneakyThrows
    @Test
    public void testBrowserStack() {
    String securityToken = "eyJhbGciOiJIUzI1NiIsInR5cCIgOiAiSldUIiwia2lkIiA6ICI2ZDM2NmJiNS01NDAyLTQ4MmMtYTVhOC1kODZhODk4MDYyZjIifQ.eyJpYXQiOjE3Mjg5ODc1NjEsImp0aSI6ImU1NzMxNzVkLWYwN2ItNGZkMi1iYzdmLTVmZWIxZTFlMDM3ZSIsImlzcyI6Imh0dHBzOi8vYXV0aDMucGVyZmVjdG9tb2JpbGUuY29tL2F1dGgvcmVhbG1zL3RyaWFsLXBlcmZlY3RvbW9iaWxlLWNvbSIsImF1ZCI6Imh0dHBzOi8vYXV0aDMucGVyZmVjdG9tb2JpbGUuY29tL2F1dGgvcmVhbG1zL3RyaWFsLXBlcmZlY3RvbW9iaWxlLWNvbSIsInN1YiI6ImIxMjcxNThhLTU1ZjQtNGVjZS04Njg4LTJkNmM1ZTUwNjQ1MyIsInR5cCI6Ik9mZmxpbmUiLCJhenAiOiJvZmZsaW5lLXRva2VuLWdlbmVyYXRvciIsIm5vbmNlIjoiZmFjZjhiZWMtN2EyYy00MTBkLThiOWMtZGZjMDNkZGIxMWE3Iiwic2Vzc2lvbl9zdGF0ZSI6ImQxZWE4ZGU4LWQ3YzAtNGEzNC1hYThiLWZkNTk5YTBmYTNiOCIsInNjb3BlIjoib3BlbmlkIG9mZmxpbmVfYWNjZXNzIHByb2ZpbGUgZW1haWwiLCJzaWQiOiJkMWVhOGRlOC1kN2MwLTRhMzQtYWE4Yi1mZDU5OWEwZmEzYjgifQ.jMmpoHkTQAdYdaJnriXEOTU6STTh6_vJZozwRALcZkE";
    String cloudName = "trial.app";
    DesiredCapabilities capabilities = new DesiredCapabilities();
    capabilities.setCapability("securityToken", securityToken);
    capabilities.setCapability("platformName", "Android"); // or "iOS" for iOS devices
    capabilities.setCapability("deviceName", "37271FDJH008ER");// Device ID from Perfecto
    capabilities.setCapability("automationName", "UiAutomator2");
//    capabilities.setCapability("deviceSessionId", "226c2dc3-4dd7-483e-84f5-4673913c9a24");
    capabilities.setCapability("autoLaunch",true);
    capabilities.setCapability("appPackage", "com.google.android.keep");
    capabilities.setCapability("appActivity", ".activities.BrowseActivity");
//    capabilities.setCapability("browserName", "Chrome");
//    capabilities.setCapability("chromedriverExecutable","C:\\Users\\Daniel A\\Desktop\\APITestingRetrofit\\src\\test\\driver\\chromedriver.exe");
//    capabilities.setCapability("platformVersion", "12");
//    capabilities.setCapability("manufacturer", "Samsung");
//    capabilities.setCapability("model", "galaxy s22");
//    capabilities.setCapability("useVirtualDevice", true);
//    capabilities.setCapability("app", "Private:General-Store.apk"); // Path to your app in Perfecto repository
//    capabilities.setCapability("autoLaunch", true);
//        cap.setCapability("deviceName", "Redmi Note 11 Pro");
//        cap.setCapability("udid", "G6ORAUNJMBAQ59TK");
//        cap.setCapability("platformName", "Android");
//        cap.setCapability("platformVersion", "13");
//        cap.setCapability("appPackage", "com.android.camera");


        AppiumDriver<MobileElement> driver = null;
        try {
            driver = new AndroidDriver<>(new URL("https://trial.app.perfectomobile.com/nexperience/perfectomobile/wd/hub"), capabilities);
        } catch (Exception e) {
            e.printStackTrace();
        }
//    driver.get("https://www.google.com");
        Thread.sleep(5000);
        driver.findElementById("android:id/button1").click();
    driver.findElementById("android:id/text1").click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//android.widget.TextView[@resource-id=\"android:id/text1\" and @text=\"Angola\"]")).click();
        driver.quit();
    }
}
