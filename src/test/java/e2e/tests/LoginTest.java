package e2e.tests;

import e2e.pages.LoginPage;
import org.testng.annotations.Test;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class LoginTest extends BaseTest{

    LoginPage loginPage;

    @Test
    public void testLogin(){
        assertThat(page).hasTitle("Sign in | OpenProject");
        loginPage = new LoginPage(page);
        loginPage.login();
        assertThat(page).hasTitle("OpenProject");
    }
}
