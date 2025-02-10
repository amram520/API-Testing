package e2e.apiTests;

import e2e.petServices.PetService;
import e2e.userServices.UserService;
import lombok.SneakyThrows;
import okhttp3.OkHttpClient;
import org.assertj.core.api.Fail;
import org.everit.json.schema.Schema;
import org.everit.json.schema.loader.SchemaLoader;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.Test;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;
import org.matcher.SchemaValidator;

import java.io.IOException;
import java.net.SocketTimeoutException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.fail;
import static payloadRepo.PayloadRepository.getPayloadAsJsonObject;

public class petApiTest {
    public PetService createPetService() {
        OkHttpClient.Builder okHttp = new OkHttpClient.Builder().readTimeout(9, TimeUnit.SECONDS).build().newBuilder();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://petstore.swagger.io/v2/")
                .client(okHttp.build())
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


//    @Test
    @SneakyThrows
    public void petTest() throws IOException {
        JSONObject userPayload = getPayloadAsJsonObject("petRequest");
        try {

            Response<String> response = petService.createPet(userPayload.toString()).execute();
            fail("it is fail");
        }
        catch (SocketTimeoutException e){
         assertThat(true).isTrue();
        }
//        System.out.println(response);
//        System.out.println(response.body());
//        assertThat(response.code()).isEqualTo(200);

    }

    @SneakyThrows
@Test
    public void test2(){
    JSONObject userPayload = getPayloadAsJsonObject("petRequest");
    Response<String> response = petService.createPet(userPayload.toString()).execute();
        assertThat(response.code()).isEqualTo(200);
        System.out.println(response.body());
        String st = "src/test/resources/payload/petSchema.json";
        valid(response.body(), st);
//        SchemaValidator.schemaValidate(response.body(),"petSchema");
    }

    public void valid(String response, String jsonSchema){
        try {
             String jsonSchem = new String(Files.readAllBytes(Paths.get(jsonSchema)));
            JSONObject schemaObject = new JSONObject(new JSONTokener(jsonSchem));
//            JSONObject resObject = new JSONObject(new JSONTokener(response));
            Schema schema = SchemaLoader.load(schemaObject);
            JSONObject res = new JSONObject(new JSONTokener(response));
            schema.validate(res);
            System.out.println("success");
        } catch (Exception e){
            System.out.println("error"+ e.getMessage());
            Fail.fail("the response doesn't match the schema");

        }
    }


}
