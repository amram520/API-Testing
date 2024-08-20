package e2e.openProjectServices;

import lombok.SneakyThrows;
import okhttp3.*;
import org.config.AutoConfig;
import org.junit.Test;
import utils.BasicAuthInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;

import java.net.URL;

public class OpenProject2 {

    public final ViewsService viewsService;

    @SneakyThrows
    public OpenProject2() {
        // Singleton
        AutoConfig cfg = org.aeonbits.owner.ConfigFactory.create(AutoConfig.class);
        OkHttpClient.Builder okHttp = new OkHttpClient.Builder().addInterceptor(
                new BasicAuthInterceptor("apikey", cfg.apiKey()));
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(new URL(cfg.baseUrl()))
                .addConverterFactory(ScalarsConverterFactory.create())
                .client(okHttp.build())
                .build();
        viewsService = retrofit.create(ViewsService.class);
    }

    @SneakyThrows
    @Test
    public void run(){
        OkHttpClient client = new OkHttpClient.Builder()
                .addNetworkInterceptor(new LoggingInterceptor())
                .build();

        Request request = new Request.Builder()
                .url("http://www.publicobject.com/helloworld.txt")
                .header("User-Agent", "OkHttp Example")
                .build();

        Response response = client.newCall(request).execute();
        response.body().close();
//        OkHttpClient client = new OkHttpClient();
//        Request request = new Request.Builder().url("https://restful-booker.herokuapp.com/booking").build();
//        Response response = client.newCall(request).execute();
//        Assert.assertEquals(response.code(), 200);
//        System.out.println(response.body().string());
//        OkHttpClient client = new OkHttpClient();
//            RequestBody formBody = new FormBody.Builder()
//                    .add("seardfhch", "Jurahgdssic Park")
//                    .build();
//            Request request = new Request.Builder()
//                    .url("https://en.wikipedia.org/w/index.php")
//                    .post(formBody)
//                    .build();
//
//            try (Response response = client.newCall(request).execute()) {
//                if (!response.isSuccessful())
//                System.out.println(response.body().string());
//                Assert.assertEquals(response.code(), 200);
            }

    }


