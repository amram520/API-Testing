package e2e.tests;

import e2e.pages.HomePage;
import e2e.pages.LoginPage;
import e2e.pages.ProjectPage;
import e2e.pages.WorkPackagesPage;
import il.co.topq.difido.model.Enums;
import org.testng.annotations.Test;

import java.io.File;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import static org.matcher.ProjectAssertions.assertThat;
import static utils.Utilities.getScreenShot;

public class CreateWorkPackageTest extends BaseTest{
    LoginPage loginPage;
    HomePage homePage;
    ProjectPage projectPage;
    WorkPackagesPage workPackagesPage;


    @Test
    public void testCreateWorkPackage(){
        assertThat(page).hasTitle("Sign in | OpenProject");
        report.logHtml("<b>Step 1 - Navigate to login page</b>", Enums.Status.success);
        getScreenShot(page, "loginPage");
        report.addImage(new File("./snapshot/loginPage.png"), "Login page");
        report.startLevel("Performing login");
        loginPage = new LoginPage(page);
        loginPage.typeUsername();
        loginPage.typePassword();
        loginPage.clickSignInButton();
        assertThat(page).hasTitle("OpenProject");
        getScreenShot(page, "homePage");
        report.addImage(new File("./snapshot/homePage.png"), "Home page");
        report.endLevel();
        report.logHtml("<b>Step 2 - Select project</b>", Enums.Status.success);
        homePage = new HomePage(page);
        report.startLevel("Select project");
        homePage.selectProject("TestProject1");
        report.endLevel();
        projectPage = new ProjectPage(page);
        assertThat(projectPage.validateNavigation()).isEqualTo("TestProject1");
        projectPage.selectFromToolBar("Work packages");
        workPackagesPage = new WorkPackagesPage(page);
        assertThat(workPackagesPage.validateNavigation()).isEqualTo("Work packages");
    }
}
