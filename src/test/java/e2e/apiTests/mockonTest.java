package e2e.apiTests;

import lombok.SneakyThrows;
import okhttp3.OkHttpClient;
import org.aeonbits.owner.ConfigFactory;
import org.config.AutoConfig;
import org.testng.Assert;
import org.testng.annotations.Test;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;

import java.util.concurrent.TimeUnit;

public class mockonTest {
    public MockoonService createMockoonService() {
        OkHttpClient.Builder okHttp = new OkHttpClient.Builder().readTimeout(9, TimeUnit.SECONDS).build().newBuilder();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://localhost:3000/")
                .client(okHttp.build())
                .addConverterFactory(ScalarsConverterFactory.create())
                .build();
        return retrofit.create(MockoonService.class);
    }
    private MockoonService mockoonService = createMockoonService();

    @SneakyThrows
    @Test
    public void testGetMockon(){
        AutoConfig config = ConfigFactory.create(AutoConfig.class);
       Response<String> response = mockoonService.getSomething().execute();
        Assert.assertEquals(response.code(), 401);
        System.out.println(response.body());
//        SchemaValidator.schemaValidate(response.body(), "error");
    }

//    @Test
    public void testGet(){
       System.setProperty("demo", "sh");
            AutoConfig config = ConfigFactory.create(AutoConfig.class);
            System.out.println(config.tok());
        System.clearProperty("demo");

    }

//    @Test
    public void testGet1(){
//        System.setProperty("demo", "hi");
        AutoConfig config = ConfigFactory.create(AutoConfig.class);
        System.out.println("##"+config.tok());

    }

}
