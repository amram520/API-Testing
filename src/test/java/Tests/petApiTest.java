package Tests;

import Endpoints.PetService;
import Endpoints.UserService;
import Models.Guardian;
import Models.RootRequest;
import Models.RootResponse;
import Models.StoreResponse;
import lombok.SneakyThrows;
import net.javacrumbs.jsonunit.assertj.JsonAssertions;
import org.json.JSONObject;
import org.testng.annotations.Test;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

import java.io.IOException;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.payloadRepo.PayloadRepository.getPayloadAsJsonObject;

public class petApiTest {
    public PetService createPetService() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://petstore.swagger.io/v2/")
                .addConverterFactory(ScalarsConverterFactory.create())
                .build();
        return retrofit.create(PetService.class);
    }

    public UserService createUserService() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://localhost:8082/")
                .addConverterFactory(ScalarsConverterFactory.create())
                .build();
        return retrofit.create(UserService.class);
    }
    public UserService createUserService2() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://localhost:8082/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit.create(UserService.class);
    }
    private PetService petService = createPetService();
    private UserService userServices = createUserService();
    private UserService userService = createUserService2();

    @Test
    @SneakyThrows
    public void petTest() throws IOException {
        JSONObject userPayload = getPayloadAsJsonObject("petRequest");
        Response<String> response = petService.createPet(userPayload.toString()).execute();
        System.out.println(response);
        System.out.println(response.body());
        assertThat(response.code()).isEqualTo(200);

    }

    @Test
    @SneakyThrows
    public void getStudentTest() throws IOException {
        Long id = 2L;
        Response<String> response = userServices.getStudent(id).execute();
        System.out.println(response);
        System.out.println(response.body());
        assertThat(response.code()).isEqualTo(200);

    }

    @Test
    @SneakyThrows
    public void createStudentTest() throws IOException {
        Guardian guardian = new Guardian("eli", "088065454");
        RootRequest rootRequest = new RootRequest("boki", "2003-07-11", "sdfds@gmail.com", guardian);
      Response<RootResponse> response = userService.createStudent(rootRequest).execute();
        System.out.println(response);
        System.out.println(response.body());
        assertThat(response.code()).isEqualTo(200);
        assertThat(response.body().getName())
                .isNotEmpty()
                .isEqualTo(rootRequest.getName());
    }
    @Test
    @SneakyThrows
    public void getAllStudentTest() throws IOException {
        Response<List<RootResponse>> response = userService.getAllStudents().execute();
        System.out.println(response);
        System.out.println(response.body());
        assertThat(response.code()).isEqualTo(200);
//        assertThat(response.body().getName())
//                .isNotEmpty()
//                .isEqualTo(rootRequest.getName());
    }

}
