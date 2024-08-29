package e2e.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class DeletionProjectPage {

    private Page page;
    private Locator input;
    private Locator deleteButton;
    private Locator successfulDeletionMsg;

    public DeletionProjectPage(Page page){
        this.page = page;
        this.input = page.locator("#content-body").getByRole(AriaRole.TEXTBOX);
        this.deleteButton = page.getByRole(AriaRole.BUTTON).and(page.getByTitle("Delete"));
        this.successfulDeletionMsg = page.locator("//div[text() = 'Deletion has been scheduled and is performed in the background. You will be notified of the result.']");
    }

    public void enterIntoInput(String projectName){
        input.fill(projectName);
    }

    public void clickDelete(){
        deleteButton.click();
    }

    public boolean validateDeletion(){
        page.waitForTimeout(3000);
        return successfulDeletionMsg.isVisible();
    }
}
