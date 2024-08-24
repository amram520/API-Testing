package e2e.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class WorkPackagesPage {


    private Page page;
    private Locator createWorkPackagesButton;
    private Locator workPackagesTypes;
    private Locator validateNavigation;

    public WorkPackagesPage(Page page){
        this.page =page;
        this.createWorkPackagesButton = page.getByLabel("Create new work package",new Page.GetByLabelOptions().setExact(true));
        this.workPackagesTypes = page.locator("//div[@id = 'types-context-menu']/ul/li");
        this.validateNavigation = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Work packages"));
    }

    public String validateNavigation(){
        return validateNavigation.textContent();
    }


}
