package e2e.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class HomePage {

    private Page page;
    private Locator selectProject;

    public HomePage(Page page) {
        this.page = page;
        this.selectProject = page.locator("#projects-menu");
    }

    public void selectProject(String projectName){
        selectProject.click();
      Locator  projectList = page.locator("//span[@class = 'spot-list--item-title spot-list--item-title_ellipse-text']",
                new Page.LocatorOptions().setHasText(projectName));
      projectList.click();
    }

    public boolean projectPageTitle(){
        return page.locator("//h1[text() = 'Overview']").isVisible();
    }
}
