package e2e.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import e2e.TestCase;
import il.co.topq.difido.model.Enums;

import java.io.File;

import static utils.Utilities.getScreenShot;

public class WorkPackageCreationPage extends TestCase {

    private Page page;
    private Locator validateNavigation;
    private Locator subjectField;
    private Locator saveButton;
    private Locator successfulMsg;

    public WorkPackageCreationPage(Page page){
        this.page = page;
        this.subjectField =  page.getByLabel("Subject", new Page.GetByLabelOptions().setExact(true));
        this.saveButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Save"));
        this.validateNavigation = page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("People"));
        this.successfulMsg = page.locator("//p/span[text() ='Successful creation.']");
    }

    public void enterSubject(){
        subjectField.fill("automation test");
        report.log("Type into subject field", Enums.Status.success);
        getScreenShot(page, "createWorkPackage");
        report.addImage(new File("./snapshot/createWorkPackage.png"), "create work packages page");
    }

    public void clickSave(){
        saveButton.click();
        report.log("Click on save", Enums.Status.success);
    }

    public String validateNavigation(){
        return validateNavigation.textContent();
    }

    public String validateCreation(){
        return successfulMsg.textContent();
    }
}
