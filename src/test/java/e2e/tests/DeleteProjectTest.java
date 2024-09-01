package e2e.tests;

import e2e.pages.DeletionProjectPage;
import e2e.pages.HomePage;
import e2e.pages.LoginPage;
import e2e.pages.ProjectsListPage;
import il.co.topq.difido.model.Enums;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

import java.io.File;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import static utils.Utilities.getScreenShot;

public class DeleteProjectTest extends BaseTest{
    LoginPage loginPage;
    HomePage homePage;
    ProjectsListPage projectsList;
    DeletionProjectPage deletionProjectPage;
//(dependsOnMethods = { "testCreateProject" })
    @Test
    public void testDeleteProject() {
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
        homePage =new HomePage(page);
        homePage.clickOnSelectProject();
        homePage.clickOnProjectsList();
        projectsList = new ProjectsListPage(page);
        projectsList.clickOnMenuButton("new project");
        projectsList.selectFromMenu("Delete");
        deletionProjectPage = new DeletionProjectPage(page);
        deletionProjectPage.enterIntoInput("new project");
        deletionProjectPage.clickDelete();
        Assertions.assertThat(deletionProjectPage.validateDeletion()).isEqualTo(true);
    }

}
