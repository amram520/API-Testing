package e2e.tests;

import e2e.pages.HomePage;
import e2e.pages.LoginPage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import net.javacrumbs.jsonunit.assertj.JsonAssertions;

import static org.matcher.ProjectAssertions.assertThat;

public class selectProjectTest extends BaseTest{
    LoginPage loginPage;
    HomePage homePage;
    @BeforeClass
    public void login(){
        loginPage = new LoginPage(page);
        loginPage.login();
    }

    @Test
    public void testSelectProject(){
        homePage = new HomePage(page);
        homePage.selectProject("TestProject1");
        assertThat(homePage.projectPageTitle()).isEqualTo(true);
    }
}
