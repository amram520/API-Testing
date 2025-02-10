package e2e.openProjectTests;

import e2e.TestCase;
import lombok.SneakyThrows;
import lombok.val;
import net.javacrumbs.jsonunit.assertj.JsonAssertions;
import e2e.openProjectServices.OpenProject;
import e2e.openProjectServices.ProjectService;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.testng.Assert.assertTrue;


public class TestProjects extends TestCase {



        @SneakyThrows
    @Test
    public void getProjectByIdTest(){
            long startTime = System.currentTimeMillis();
        ProjectService openProject = OpenProject.getInstance().createService(ProjectService.class);
        val response = openProject.getProjectById(3).execute();
        long endTime = System.currentTimeMillis();
        long duration = endTime-startTime;
        assertTrue(duration< 3000);
        System.out.println("#########   " + duration);
        System.out.println(response);
        System.out.println(response.body());
//            OpenApiInteractionValidator validator = OpenApiInteractionValidator.createFor(String.valueOf(new URI(""))).build();
//            DefaultRequest request = new DefaultRequest.Builder(("/v1/endpoint"),"")
//                    .method("GET")
//                    .build();
//            DefaultResponse responseToValidate = new DefaultResponse.Builder(response.code())
//                    .body(Body.from(response.body().toString()))  // Get response body as a string
//                    .build();
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

    }


}
