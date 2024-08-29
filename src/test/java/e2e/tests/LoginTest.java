package e2e.tests;

import e2e.pages.LoginPage;
import il.co.topq.difido.model.Enums;
import org.testng.annotations.Test;

import java.io.File;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import static utils.Utilities.getScreenShot;

public class LoginTest extends BaseTest{

    LoginPage loginPage;

    @Test
    public void testLogin(){
        assertThat(page).hasTitle("Sign in | OpenProject");
        report.logHtml("<b>Step 1 - Navigate to login page passed</b>", Enums.Status.success);
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
    }
}
