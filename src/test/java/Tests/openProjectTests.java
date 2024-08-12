package Tests;

import Endpoints.BookService;
import Endpoints.OpenProjectService;
import lombok.SneakyThrows;
import okhttp3.OkHttpClient;
import org.testng.annotations.Test;
import org.utils.BasicAuthInterceptor;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

import static org.assertj.core.api.Assertions.assertThat;

public class openProjectTests {
    public OpenProjectService createOpenProjectService() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://localhost:8080/api/v3/")
                .addConverterFactory(ScalarsConverterFactory.create())
                .build();
        return retrofit.create(OpenProjectService.class);
    }

    private OpenProjectService service = createOpenProjectService();


    @Test
    @SneakyThrows
    public void getProjectByIdTest() {
        int id = 3;
        String username = "apikey";
        String passward = "73e10a7b938dc699545c05b4a21301bfdbabe36be881aeaa2044cedd5e55d9b6";
        String base = username + ":" + passward;
        String basicAuth = "Basic " + Base64.getEncoder().encodeToString(base.getBytes());
            System.out.println(basicAuth);
        Response<String> response = service.getProjectById(basicAuth, id).execute();
        System.out.println(response);
        System.out.println(response.body());
        assertThat(response.code()).isEqualTo(200);
    }

}

