package e2e.tests;

import e2e.TestCase;
import e2e.userServices.UserService;
import il.co.topq.difido.model.Enums;
import lombok.SneakyThrows;
import net.javacrumbs.jsonunit.assertj.JsonAssertions;
import org.json.JSONObject;
import org.testng.annotations.Test;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;

import static org.assertj.core.api.Assertions.assertThat;
import static payloadRepo.PayloadRepository.getPayloadAsJsonObject;

public class userTest extends TestCase {
    public UserService createUserService() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://reqres.in/")
                .addConverterFactory(ScalarsConverterFactory.create())
                .build();
        return retrofit.create(UserService.class);
    }

    private UserService userService = createUserService();


    @Test
    @SneakyThrows
    public void testValidateUserCreateUsingNewInfrastructure() {
        JSONObject userPayload = getPayloadAsJsonObject("userRequest");
        userPayload.put("job","CTO");
        Response<String> response = userService.createUser(userPayload.toString()).execute();
        System.out.println(response);
        System.out.println(response.body());
        assertThat(response.code()).isEqualTo(201);
        JsonAssertions.assertThatJson(response.body()).node("id").isString();
    }


    @Test
    @SneakyThrows
    public void testValidateUser() {
        JSONObject userPayload = getPayloadAsJsonObject("petRequest");
        System.out.println(userPayload);
        Response<String> response = userService.listUsers().execute();
        System.out.println(response);
        System.out.println(response.body());
        assertThat(response.code()).isEqualTo(200);
    }

    @Test
    @SneakyThrows
    public void testUpdateUser() {
        JSONObject userPayload = getPayloadAsJsonObject("userRequest");
        System.out.println(userPayload);
        Response<String> response = userService.updateUser().execute();
        System.out.println(response);
        System.out.println(response.body());
        assertThat(response.code()).isEqualTo(200);
    }

}
