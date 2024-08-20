package e2e.openProjectTests;

import e2e.TestCase;
import lombok.SneakyThrows;
import lombok.val;
import net.javacrumbs.jsonunit.assertj.JsonAssertions;
import e2e.openProjectServices.OpenProject;
import e2e.openProjectServices.WorkPackagesService;
import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static payloadRepo.PayloadRepository.getPayloadAsJsonObject;

public class TestWorkPackages extends TestCase {

    private WorkPackagesService workPackagesService = OpenProject.getInstance().createService(WorkPackagesService.class);

    int id = 43;

    @SneakyThrows
    @Test
    public void getWorkPackagesByProjectTest() {
        int id = 3;
        int num = 9;
        val response = workPackagesService.getWorkPackagesByProjectId(id).execute();
        System.out.println(response);
        System.out.println(response.body());
        assertThat(response.code()).isEqualTo(200);
        JsonAssertions.assertThatJson(response.body()).node("_embedded").node("elements[" + num + "]").node("subject").isEqualTo("it is post request test");
    }

    @SneakyThrows
    @Test
    public void testCreateWorkPackages() {
        JSONObject userPayload = getPayloadAsJsonObject("workPackages");
        val response = workPackagesService.createWorkPackages(userPayload.toString()).execute();
        System.out.println(response);
        System.out.println(response.body());
        assertThat(response.code()).isEqualTo(201);
        JSONObject jsonObject = new JSONObject(response.body());
        //validate work package created
        id = jsonObject.getInt("id");
    }

    @SneakyThrows
    @Test(dependsOnMethods = {"testCreateWorkPackages"})
    public void testGetWorkPackageById() {
        val response = workPackagesService.getWorkPackageById(id).execute();
        System.out.println(response);
        System.out.println(response.body());
        assertThat(response.code()).isEqualTo(200);

    }


    @SneakyThrows
    @Test
    public void deleteWorkPackageTest() {
        //validate exist id to delete
        val res = workPackagesService.getAllWorkPackage().execute();
        JSONObject jsonObject = new JSONObject(res.body());
        JSONObject _embedded = jsonObject.getJSONObject("_embedded");
        JSONArray elements = _embedded.getJSONArray("elements");
        System.out.println(elements);
        int id = elements.getJSONObject(0).getInt("id");
        System.out.println("the id to delete " + id);
        val response = workPackagesService.deleteWorkPackage(id).execute();
        System.out.println(response);
        System.out.println(response.body());
        assertThat(response.code()).isEqualTo(204);
    }

    @SneakyThrows
    @Test
    public void getAllWorkPackageTest() {
        val response = workPackagesService.getAllWorkPackage().execute();
        System.out.println(response);
        System.out.println(response.body());
        assertThat(response.code()).isEqualTo(200);
    }
}

