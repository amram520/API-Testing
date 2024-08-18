package Tests;

import org.petServices.PetService;
import userServices.UserService;
import Models.RootRequest;
import Models.RootResponse;
import lombok.SneakyThrows;
import org.json.JSONObject;
import org.testng.annotations.Test;
import org.utils.SchemaValidator;
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
    private PetService petService = createPetService();


    @Test
    @SneakyThrows
    public void petTest() throws IOException {
        JSONObject userPayload = getPayloadAsJsonObject("petRequest");
        Response<String> response = petService.createPet(userPayload.toString()).execute();
        System.out.println(response);
        System.out.println(response.body());
        assertThat(response.code()).isEqualTo(200);

    }





}
