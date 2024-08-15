package Tests;

import org.OpenProject.OpenProject;
import org.OpenProject.OpenProjectService;
import lombok.SneakyThrows;
import net.javacrumbs.jsonunit.assertj.JsonAssertions;
import okhttp3.*;
import static org.assertj.core.api.Assertions.assertThat;

import org.testng.annotations.Test;
import org.utils.BasicAuthInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;

import java.io.IOException;
import java.net.URL;

public class OkHttpTest {

//@SneakyThrows
//    public OpenProjectService createOpenProjectService(){
//        OkHttpClient.Builder okHttp = new OkHttpClient.Builder().addInterceptor(
//                new BasicAuthInterceptor("apikey","73e10a7b938dc699545c05b4a21301bfdbabe36be881aeaa2044cedd5e55d9b6" ));
//        Retrofit retrofit = new Retrofit.Builder()
//                .baseUrl(new URL("http://localhost:8080/api/v3/"))
//                .addConverterFactory(ScalarsConverterFactory.create())
//                .client(okHttp.build())
//                .build();
//        return retrofit.create(OpenProjectService.class);
//    }
    private OkHttpClient client = new OkHttpClient();
//    private OpenProjectService service = OpenProject;

//    @SneakyThrows
//    @Test
//    public void check(){
//        retrofit2.Response<String> response = service.getProjectById(3).execute();
//        System.out.println(response);
//        System.out.println(response.body());
//        JsonAssertions.assertThatJson(response.body()).node("name").isEqualTo("TestProject1");
//        assertThat(response.code()).isEqualTo(200);
//    }


    @Test
    public void whenGetRequest_thenCorrect() throws IOException {

        Request request = new Request.Builder()
                .url("http://localhost:8080/api/v3/projects/3/")
                .addHeader("Authorization", Credentials.basic("apikey", "73e10a7b938dc699545c05b4a21301bfdbabe36be881aeaa2044cedd5e55d9b6"))
                                .build();
        Call call = client.newCall(request);
        Response response = call.execute();
        ResponseBody responseBody = response.body();
        System.out.println(response.body().string());
        JsonAssertions.assertThatJson(responseBody.string()).node("name").isEqualTo("TestProject1");
//        JsonAssertions.assertThatJson(response.body()).node("description").node("raw").isEqualTo("**This is the first test project**");
        assertThat(response.code()).isEqualTo(200);
    }
}
