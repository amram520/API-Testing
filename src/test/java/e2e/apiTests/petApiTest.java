package e2e.apiTests;

import e2e.petServices.PetService;
import e2e.userServices.UserService;
import lombok.SneakyThrows;
import org.json.JSONObject;
import org.testng.annotations.Test;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;
import static payloadRepo.PayloadRepository.getPayloadAsJsonObject;

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
