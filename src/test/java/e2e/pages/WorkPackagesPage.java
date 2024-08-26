package e2e.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import com.microsoft.playwright.options.SelectOption;

public class WorkPackagesPage {


    private Page page;
    private Locator createWorkPackageButton;
    private Locator workPackagesTypes;
    private Locator validateNavigation;

    public WorkPackagesPage(Page page){
        this.page =page;
        this.createWorkPackageButton = page.locator("//button[@class = 'button -primary add-work-package']");
 //       this.workPackagesTypes = page.locator("//div[@id = 'types-context-menu']/ul/li");
//        this.workPackagesTypes = page.getByRole(AriaRole.LISTITEM);
        this.validateNavigation = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Work packages"));
    }

    public void clickOnCreateWorkPackageButton(){
        createWorkPackageButton.click();
    }

    public void selectworkPackagetype(String type){
        workPackagesTypes = page.locator("//div[@id = 'types-context-menu']/ul/li", new Page.LocatorOptions().setHasText(type));
        workPackagesTypes.click();
    }

    public String validateNavigation(){
        return validateNavigation.textContent();
    }


}
