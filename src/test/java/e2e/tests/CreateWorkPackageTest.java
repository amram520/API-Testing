package e2e.tests;

import e2e.pages.*;
import il.co.topq.difido.model.Enums;
import org.testng.annotations.Test;

import java.io.File;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import static org.matcher.ProjectAssertions.assertThat;
import static utils.Utilities.getScreenShot;

public class CreateWorkPackageTest extends configTest{
    LoginPage loginPage;
    HomePage homePage;
    ProjectPage projectPage;
    WorkPackagesPage workPackagesPage;
    WorkPackageCreationPage workPackageCreationPage;


    @Test
    public void testCreateWorkPackage(){
        assertThat(page).hasTitle("Sign in | OpenProject");
        report.logHtml("<b>Step 1 - Navigate to login page</b>", Enums.Status.in_progress);
        getScreenShot(page, "loginPage");
        report.addImage(new File("./snapshot/loginPage.png"), "Login page");
        report.startLevel("Performing login");
        loginPage = new LoginPage(page);
        loginPage.typeUsername(cfg.openProjectUsername());
        loginPage.typePassword(cfg.openProjectPassword());
        loginPage.clickSignInButton();
        assertThat(page).hasTitle("OpenProject");
        getScreenShot(page, "homePage");
        report.addImage(new File("./snapshot/homePage.png"), "Home page");
        report.endLevel();
        report.logHtml("<b>Step 2 - Select project</b>", Enums.Status.in_progress);
        homePage = new HomePage(page);
        report.startLevel("Performing navigation to project page");
        homePage.selectProject("TestProject1");
        projectPage = new ProjectPage(page);
        assertThat(projectPage.validateNavigation()).isEqualTo("TestProject1");
        getScreenShot(page, "projectPage");
        report.addImage(new File("./snapshot/projectPage.png"), "project page");
        report.endLevel();
        report.logHtml("<b>Step 3 - navigation to Work packages page</b>", Enums.Status.in_progress);
        report.startLevel("Click on Work packages");
        projectPage.selectFromToolBar("Work packages");
        report.endLevel();
        report.logHtml("<b>Step 4 - Create work package</b>", Enums.Status.in_progress);
        workPackagesPage = new WorkPackagesPage(page);
        assertThat(workPackagesPage.validateNavigation()).isEqualTo("Work packages");
        report.startLevel("Create work package");
        workPackagesPage.clickOnCreateWorkPackageButton();
        workPackagesPage.selectworkPackagetype("Task");
        workPackageCreationPage = new WorkPackageCreationPage(page);
        assertThat(workPackageCreationPage.validateNavigation()).isEqualTo("People");
        workPackageCreationPage.typeSubject();
        workPackageCreationPage.clickSave();
        assertThat(workPackageCreationPage.validateCreation()).contains("Successful creation");
        report.log("work package creation passed", Enums.Status.success);
        getScreenShot(page, "successfulMsg");
        report.addImage(new File("./snapshot/successfulMsg.png"), "successfulMsg");
        report.endLevel();
    }
}
