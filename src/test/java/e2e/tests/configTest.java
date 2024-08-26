package e2e.tests;

import lombok.SneakyThrows;
import org.config.AutoConfig;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class configTest extends BaseTest{

    protected AutoConfig cfg;
    @BeforeMethod
    public void init(){
        this.cfg = org.aeonbits.owner.ConfigFactory.create(AutoConfig.class);
        page.navigate(cfg.url());
    }
@SneakyThrows
    @AfterMethod
    public void close(ITestResult result){
        String path = System.getProperty("user.dir");
        String testName = result.getMethod().getMethodName();
        Path videoName =  page.video().path().getFileName();
        page.close();
        context.close();
        browser.close();
        Path isFileExist = Paths.get("").toAbsolutePath().resolve("videos\\"+testName+".webm");
        if(Files.exists(isFileExist)){
            Files.delete(isFileExist);
        }
        File file1 = new File(path+File.separator+"videos"+File.separator+videoName);
        File file2 = new File(path+File.separator+"videos"+File.separator+testName+".webm");
        file1.renameTo(file2);

    }
}
