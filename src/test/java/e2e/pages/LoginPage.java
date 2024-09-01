package e2e.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import il.co.topq.difido.model.Enums;
import utils.TestCase;

public class LoginPage extends TestCase {

    private Page page = null;
    private Locator username;
    private  Locator password;
    private Locator sighInButton;


    public LoginPage(Page page){
    this.page = page;
    this.username = page.locator("#username");
    this.password = page.locator("id=password");
    this.sighInButton =  page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Sign in"));

    }

    public void enterUsername(String user){
        username.fill(user);
        report.log("Enter username", Enums.Status.success);
    }

    public void enterPassword(String pass){
        password.fill(pass);
        report.log("Enter password", Enums.Status.success);
    }

    public void clickSignInButton(){
        sighInButton.click();
        report.log("Click on SignIn Button", Enums.Status.success);
    }
}
