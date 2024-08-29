package e2e.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import e2e.TestCase;

import java.util.List;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class ProjectsListPage extends TestCase {

    private Page page;
    private Locator menueButton;
    private Locator menuOptions;

    public ProjectsListPage(Page page){
        this.page = page;
        this.menueButton = page.locator("//button[@id ='action-menu-8010ecd5-b10e-4b66-b88a-7faec1fa3f04-button']");
        this.menuOptions = page.locator("//ul[@id ='action-menu-9177a187-3050-4905-828a-d380ff62899b-list']/li");
    }

    public void clickOnMenuButton(String project){
        page.waitForTimeout(4000);
        getLocatorFromTheListTable(project, 9).click();
    }

    public void selectFromMenu(String option){
//        menuOptions.filter(new Locator.FilterOptions().setHasText(option)).click();
//        menuOptions.last().click();
        page.getByRole(AriaRole.MENUITEM, new Page.GetByRoleOptions().setName(option)).click();

    }

    public Locator getLocatorFromTheListTable(String project, int returnColumn){
        int index = 1;
        List<Locator> button = page.locator("//tr/td[3]").all();
        for (Locator locator : button){
            if(locator.textContent().contains(project)){
                break;
            }
            else {
                index++;
            }
        }
        return page.locator("//tr["+index+"]/td["+returnColumn+"]");
    }
}
