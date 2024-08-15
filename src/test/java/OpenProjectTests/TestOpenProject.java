package OpenProjectTests;

import lombok.SneakyThrows;
import lombok.val;
import net.javacrumbs.jsonunit.assertj.JsonAssertions;
import org.OpenProject.OpenProject;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TestOpenProject {



        @SneakyThrows
    @Test
    public void getProjectByIdTest(){
        OpenProject openProjectss = new OpenProject();
        val response = openProjectss.getOpenProjectService().getProjectById(3).execute();
        System.out.println(response);
        System.out.println(response.body());
        JsonAssertions.assertThatJson(response.body()).node("name").isEqualTo("TestProject1");
        JsonAssertions.assertThatJson(response.body()).node("description").node("raw").isEqualTo("**This is the first test project**");
        assertThat(response.code()).isEqualTo(200);
    }

    @SneakyThrows
    @Test
    public void UpdateProjectByIdTest(){
        OpenProject openProjectss = new OpenProject();
        val response = openProjectss.getOpenProjectService().getProjectById(3).execute();
        System.out.println(response);
        System.out.println(response.body());
        JsonAssertions.assertThatJson(response.body()).node("name").isEqualTo("TestProject1");
        JsonAssertions.assertThatJson(response.body()).node("description").node("raw").isEqualTo("**This is the first test project**");
        assertThat(response.code()).isEqualTo(200);
    }
}
