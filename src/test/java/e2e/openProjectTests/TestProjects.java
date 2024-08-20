package e2e.openProjectTests;

import e2e.TestCase;
import il.co.topq.difido.model.Enums;
import lombok.SneakyThrows;
import lombok.val;
import net.javacrumbs.jsonunit.assertj.JsonAssertions;
import e2e.openProjectServices.OpenProject;
import e2e.openProjectServices.ProjectService;
import org.testng.annotations.Test;
import utils.SchemaValidator;

import static org.assertj.core.api.Assertions.assertThat;

public class TestProjects extends TestCase {



        @SneakyThrows
    @Test
    public void getProjectByIdTest(){
        ProjectService openProject = OpenProject.getInstance().createService(ProjectService.class);
        val response = openProject.getProjectById(3).execute();
        System.out.println(response);
        System.out.println(response.body());
        JsonAssertions.assertThatJson(response.body()).node("name").isEqualTo("TestProject1");
        JsonAssertions.assertThatJson(response.body()).node("description").node("raw").isEqualTo("**This is the first test project**");
        assertThat(response.code()).isEqualTo(200);
    }
    @SneakyThrows
    @Test
    public void getProjectSchemaTest(){
        ProjectService openProject = OpenProject.getInstance().createService(ProjectService.class);
        val response = openProject.getProjectSchema().execute();
        System.out.println(response);
        System.out.println(response.body());
        assertThat(response.code()).isEqualTo(200);
        SchemaValidator.schemaValidate(response.body(),"projectSchema");
    }


}
