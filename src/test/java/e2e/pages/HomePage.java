package e2e.pages;

import com.microsoft.playwright.Download;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import e2e.TestCase;
import il.co.topq.difido.model.Enums;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class HomePage extends TestCase {

    private Page page;
    private Locator selectProject;
    private Locator addMenuButton;
    private  Locator newProject;
    private Locator projectsListButton;
    private Locator isProjectVisible;
    private Locator listProjects;

    public HomePage(Page page) {
        this.page = page;
        this.selectProject = page.locator("#projects-menu");
        this.addMenuButton = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Open quick add menu"));
        this.newProject = page.locator("//ul[@id ='quick-add-menu']/li");
        this.projectsListButton = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Project lists"));
        this.isProjectVisible = page.locator("//span[@class = 'spot-list--item-title spot-list--item-title_ellipse-text']");
        this.listProjects = page.locator("//span[@class = 'spot-list--item-title spot-list--item-title_ellipse-text']");
    }

    public void clickOnSelectProject(){

        page.waitForTimeout(6000);
        selectProject.click();
        report.log("Click on select projects button", Enums.Status.success);
    }

    public void selectProject(String projectName){
listProjects.filter(new Locator.FilterOptions().setHasText(projectName)).click();
      report.log("select project", Enums.Status.success);
    }

    public void clickAddMenuButton(){
        addMenuButton.click();
        report.log("Click on add menu button", Enums.Status.success);
    }
    public void clickFromAddMenuList(String name){
        newProject.filter(new Locator.FilterOptions().setHasText(name)).click();
        report.log("Click on new project button", Enums.Status.success);
    }

    public boolean isProjectVisible(String projectName){
        page.waitForTimeout(6000);
        Locator isProjectVisibles =  page.locator("//span[@class = 'spot-list--item-title spot-list--item-title_ellipse-text']",
                new Page.LocatorOptions().setHasText(projectName));
        listProjects.filter(new Locator.FilterOptions().setHasText(projectName)).isVisible();
        return isProjectVisibles.isVisible();
    }

    public void clickOnProjectsList(){
    projectsListButton.click();
    }

    public void ff() throws IOException, NoSuchAlgorithmException {
        Download download = page.waitForDownload(() -> {
            page.click("button#downloadButton");
        });

        // Get downloaded file path
        Path path = download.path();

        // Basic verification
        assertTrue(Files.exists(path));
        assertEquals("expected-filename.pdf", download.suggestedFilename());

        // Size verification
        long fileSize = Files.size(path);
        assertTrue(fileSize > 0);

        // Optional: Content verification
        byte[] content = Files.readAllBytes(path);
        String md5Hash = calculateMD5(content);
        assertEquals("expected-md5-hash", md5Hash);

        // Optional: Content type verification
//        assertEquals("application/pdf", download.headers().get("content-type"));
    }
    private String calculateMD5(byte[] content) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] digest = md.digest(content);
        return bytesToHex(digest);
    }

    private String bytesToHex(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }
}
