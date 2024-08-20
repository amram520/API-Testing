package e2e.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import org.config.AutoConfig;

public class LoginPage {

    private Page page = null;
    private Locator username;
    private  Locator password;
    private AutoConfig cfg;

    public LoginPage(Page page){
    this.page = page;
    this.username = page.locator("#username");
    this.password = page.locator("id=password");
    this.cfg = org.aeonbits.owner.ConfigFactory.create(AutoConfig.class);
    }

    public void login(){
        username.fill("admin");
        password.fill(cfg.openProjectPassword());
        password.press("Enter");
    }
}
