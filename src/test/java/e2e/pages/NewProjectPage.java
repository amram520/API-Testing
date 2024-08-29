package e2e.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import com.microsoft.playwright.options.KeyboardModifier;
import com.microsoft.playwright.options.MouseButton;

public class NewProjectPage {

    private Page page;
    private  Locator validateNavigation;
    private Locator nameField;
    private Locator saveButton;

    public NewProjectPage(Page page){
        this.page = page;
        this.nameField = page.getByLabel("Name *");
        this.validateNavigation = page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("New project"));
        this.saveButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Save"));
    }
    public boolean validatenavigation(){
        return validateNavigation.isVisible();
    }

    public void enterNamefield(String name){
        nameField.fill(name);
        nameField.dblclick();
    }

    public void clickSave(){
        saveButton.click();
    }
}
