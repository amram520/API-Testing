package e2e.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import e2e.TestCase;
import il.co.topq.difido.model.Enums;

import java.io.File;

import static utils.Utilities.getScreenShot;

public class HomePage extends TestCase {

    private Page page;
    private Locator selectProject;

    public HomePage(Page page) {
        this.page = page;
        this.selectProject = page.locator("#projects-menu");
    }

    public void selectProject(String projectName){
        selectProject.click();
        report.startLevel("Performing navigation to project page");
        report.log("Click on projects button", Enums.Status.success);
      Locator  projectsList = page.locator("//span[@class = 'spot-list--item-title spot-list--item-title_ellipse-text']",
                new Page.LocatorOptions().setHasText(projectName));
      projectsList.click();
      report.log("select project", Enums.Status.success);
    }

}
