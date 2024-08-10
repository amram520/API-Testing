package Tests;

import Endpoints.UserService;
import Models.CreateUserRequest;
import Models.CreateUserResponse;
import com.google.gson.Gson;
import lombok.SneakyThrows;
import lombok.val;
import net.javacrumbs.jsonunit.assertj.JsonAssertions;
import okhttp3.Headers;
import okhttp3.OkHttpClient;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.payloadRepo.PayloadRepository.getPayloadAsJsonObject;

public class userTest {
    public UserService createUserService() {
//        Headers.Builder head = new Headers.Builder();
//        OkHttpClient.Builder ok = null;
//        ok.authenticator((route, response) ->
//                response.request().newBuilder()
//                        .headers(head.add("Content-Type","application/json").build()).build());
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://reqres.in/")
                .addConverterFactory(ScalarsConverterFactory.create())
                .build();
        return retrofit.create(UserService.class);
    }

    private UserService userService = createUserService();

//    @Test
//    public void validateUserCreation() throws IOException {
//        String name = "morpheus";
//        String job = "leader";
////        UserClient userClient =new UserClient();
//        CreateUserRequest createUserRequest = new
//                CreateUserRequest(name, job);
//        Response<CreateUserResponse> createUserResponse =
//                userService.createUser(createUserRequest).execute();
////        Response<CreateUserResponse> createUserResponse =
////                createUser(createUserRequest);
//        assertThat(createUserResponse.code()).isEqualTo(201);
//        assertThat(createUserResponse.body().getName()).isEqualTo(name);
//    }

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
