package e2e.tests;

import e2e.pages.*;
import il.co.topq.difido.model.Enums;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

import java.io.File;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import static org.matcher.ProjectAssertions.assertThat;
import static utils.Utilities.getScreenShot;

public class CreateProjectTest extends BaseTest{

    LoginPage loginPage;
    HomePage homePage;
    NewProjectPage newProjectPage;

    @Test
    public void testCreateProject(){
        assertThat(page).hasTitle("Sign in | OpenProject");
        report.logHtml("<b>Step 1 - Navigate to login page</b>", Enums.Status.in_progress);
        getScreenShot(page, "loginPage");
        report.addImage(new File("./snapshot/loginPage.png"), "Login page");
        report.startLevel("Performing login");
        loginPage = new LoginPage(page);
        loginPage.enterUsername(cfg.openProjectUsername());
        loginPage.enterPassword(cfg.openProjectPassword());
        loginPage.clickSignInButton();
        assertThat(page).hasTitle("OpenProject");
        getScreenShot(page, "homePage");
        report.addImage(new File("./snapshot/homePage.png"), "Home page");
        report.endLevel();
        report.logHtml("<b>Step 2 - Click on new project button</b>", Enums.Status.in_progress);
        homePage = new HomePage(page);
        report.startLevel("Performing navigation to create new project page");
        homePage.clickAddMenuButton();
        homePage.clickFromAddMenuList("Project");
        report.endLevel();
        report.logHtml("<b>Step 3 - Create new project page</b>", Enums.Status.in_progress);
        newProjectPage = new NewProjectPage(page);
        report.startLevel("create new project page");
        assertThat(newProjectPage.validatenavigation()).isTrue();
        newProjectPage.enterNamefield("new project");
        newProjectPage.clickSave();
        homePage.clickOnSelectProject();
        System.out.println(homePage.isProjectVisible("new project"));
        assertThat(homePage.isProjectVisible("new project")).isTrue();
        report.log("The project is created", Enums.Status.success);
        getScreenShot(page, "projectList");
        report.addImage(new File("./snapshot/projectList.png"), "project list");
    }

}
