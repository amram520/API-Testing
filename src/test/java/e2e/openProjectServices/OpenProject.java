package e2e.openProjectServices;

import junit.framework.TestCase;
import lombok.Getter;
import lombok.SneakyThrows;
import okhttp3.OkHttpClient;
import org.config.AutoConfig;
import utils.BasicAuthInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;
import utils.LoggingInterceptor;

import java.net.URL;
@Getter
public class OpenProject extends TestCase {

    private static OpenProject instance;

    private final Retrofit retrofit;

    @SneakyThrows
    private OpenProject() {
        // Singleton
        AutoConfig cfg = org.aeonbits.owner.ConfigFactory.create(AutoConfig.class);
        OkHttpClient.Builder okHttp = new OkHttpClient.Builder().addInterceptor(
                new BasicAuthInterceptor("apikey", cfg.apiKey())).addInterceptor(new LoggingInterceptor());
        retrofit = new Retrofit.Builder()
                .baseUrl(new URL(cfg.baseUrl()))
                .addConverterFactory(ScalarsConverterFactory.create())
                .client(okHttp.build())
                .build();
    }
    public static OpenProject getInstance() {
        if (instance == null) {
            instance = new OpenProject();

        }
        return instance;
    }


    @SneakyThrows
    public <T> T createService(final Class<T> service){
        return retrofit.create(service);
    }

}
