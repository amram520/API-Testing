package OpenProjectTests;

import lombok.SneakyThrows;
import lombok.val;
import net.javacrumbs.jsonunit.assertj.JsonAssertions;
import org.openProjectServices.OpenProject;
import org.openProjectServices.WorkPackagesService;
import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.payloadRepo.PayloadRepository.getPayloadAsJsonObject;

public class TestWorkPackages {

    private WorkPackagesService openProject = OpenProject.createService(WorkPackagesService.class);

    @SneakyThrows
    @Test
    public void getWorkPackagesByProjectTest(){
        int id = 3;
         int s = 9;
        val response = openProject.getWorkPackagesByProjectId(3).execute();
        System.out.println(response);
        System.out.println(response.body());
        assertThat(response.code()).isEqualTo(200);
        JsonAssertions.assertThatJson(response.body()).node("_embedded").node("elements["+s+"]").node("subject").isEqualTo("it is post request test");
    }

    @SneakyThrows
    @Test
    public void createWorkPackagesTest(){
        JSONObject userPayload = getPayloadAsJsonObject("workPackages");
        val response = openProject.createWorkPackages(userPayload.toString()).execute();
        System.out.println(response);
        System.out.println(response.body());
        assertThat(response.code()).isEqualTo(201);
        JSONObject jsonObject = new JSONObject(response.body());
        //validate work package created
        getWorkPackageByIdTest(jsonObject.getInt("id"));
    }

    @SneakyThrows
    @Test
    public void getWorkPackageByIdTest(){
        int id = 43;
        val response = openProject.getWorkPackageById(id).execute();
        System.out.println(response);
        System.out.println(response.body());
        assertThat(response.code()).isEqualTo(200);

    }

    @SneakyThrows
    @Test
    public void getWorkPackageByIdTest(int id){
        val response = openProject.getWorkPackageById(id).execute();
        System.out.println(response);
        System.out.println(response.body());
        assertThat(response.code()).isEqualTo(200);
    }

    @SneakyThrows
    @Test
    public void deleteWorkPackageTest(){
        //validate exist id to delete
        val res = openProject.getAllWorkPackage().execute();
        JSONObject jsonObject = new JSONObject(res.body());
        JSONObject _embedded = jsonObject.getJSONObject("_embedded");
        JSONArray elements = _embedded.getJSONArray("elements");
        System.out.println(elements);
        int id = elements.getJSONObject(0).getInt("id");
        System.out.println("the id to delete " +id);
        val response = openProject.deleteWorkPackage(id).execute();
        System.out.println(response);
        System.out.println(response.body());
        assertThat(response.code()).isEqualTo(204);
    }

    @SneakyThrows
    @Test
    public void getAllWorkPackageTest(){
        val response = openProject.getAllWorkPackage().execute();
        System.out.println(response);
        System.out.println(response.body());
        assertThat(response.code()).isEqualTo(200);
        }
        }

