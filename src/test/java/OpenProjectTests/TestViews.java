package OpenProjectTests;

import lombok.SneakyThrows;
import lombok.val;
import net.javacrumbs.jsonunit.assertj.JsonAssertions;
import org.openProjectServices.OpenProject;
import org.openProjectServices.ViewsService;
import org.openProjectServices.WorkPackagesService;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TestViews {

    private ViewsService openProject = OpenProject.createService(ViewsService.class);
    @SneakyThrows
    @Test
    public void getViewsTest() {
        String[] viewesNames = {"Tasks", "Sprint 1", "Product backlog", "Project plan", "Team planner", "Tasks", "Milestones", "Project plan"};
        val response = openProject.gatViews().execute();
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
