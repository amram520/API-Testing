package e2e.openProjectTests;

import lombok.SneakyThrows;
import lombok.val;
import net.javacrumbs.jsonunit.assertj.JsonAssertions;
import e2e.openProjectServices.OpenProject;
import e2e.openProjectServices.OpenProject2;
import e2e.openProjectServices.ViewsService;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TestViews {

    private ViewsService openProject = OpenProject.getInstance().createService(ViewsService.class);

    private OpenProject2 api = new OpenProject2();

    @SneakyThrows
    @Test
    public void getViewsTest() {
        String[] viewesNames = {"Tasks", "Sprint 1", "Product backlog", "Project plan", "Team planner", "Tasks", "Milestones", "Project plan"};
        val response = openProject.getViews().execute();
        System.out.println(response);
        System.out.println(response.body());
        assertThat(response.code()).isEqualTo(200);
        JsonAssertions.assertThatJson(response.body()).node("count").isEqualTo("8");
//        JsonAssertions.assertThatJson(response.body()).node("_embedded").node("elements[$]").node("subject").isEqualTo("it is post request test");
        for (int i = 0; i < viewesNames.length; i++) {
            JsonAssertions.assertThatJson(response.body()).node("_embedded").node("elements[" + i + "]").node("name").isEqualTo(viewesNames[i]);
        }
    }

}
