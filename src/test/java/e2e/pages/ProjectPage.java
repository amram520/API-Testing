package e2e.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class ProjectPage {

    private Page page;
    private Locator toolBar;

    private Locator validateNavigation;

    public ProjectPage(Page page) {
        this.page = page;
        this.toolBar = page.locator("//div[@id = 'menu-sidebar']/ul/li");
        this.validateNavigation = page.locator("//button[@id = 'projects-menu']");
    }

    public void selectFromToolBar(String selection){
        toolBar.filter(new Locator.FilterOptions().setHasText(selection)).click();
    }

    public String validateNavigation(){
        return validateNavigation.textContent();
    }
}
