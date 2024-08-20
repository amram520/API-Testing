package e2e.examples;

import e2e.TestCase;
import il.co.topq.difido.model.Enums;
import org.testng.annotations.Test;

import java.io.File;

public class TestReports extends TestCase {

    private String name;

    public TestReports(){

    }

    @Test
    public void testDifferentReportMessages() {
        report.log("Simple log message");
        report.log("Message with toggle", "The toggle body");
        report.log("Message that fails the test", Enums.Status.success);
        report.logHtml("Html message", "<b>Will appear in bold</b>", Enums.Status.success);
        report.addTestProperty("User", "Itai");
        report.addRunProperty("Build", "1.0.12");
//        report.addImage(new File("screenshot.png"), "My screenshot");
//        report.addFile(new File("system.log"), "System log file");
        report.startLevel("Messages will be hidden in this level");
        report.log("Message 1 in toggle");
        report.log("Message 2 in toggle");
        report.log("Message 3 in toggle");
        report.endLevel();
    }

}
