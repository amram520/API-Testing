package e2e.bookServices;

import lombok.SneakyThrows;
import okhttp3.OkHttpClient;
import org.config.AutoConfig;
import utils.BasicAuthInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;

import java.net.URL;

public class Book {

    @SneakyThrows
    public static <T> T createService(final Class<T> service){
        AutoConfig cfg = org.aeonbits.owner.ConfigFactory.create(AutoConfig.class);
        OkHttpClient.Builder okHttp = new OkHttpClient.Builder().addInterceptor(
                new BasicAuthInterceptor("admin", cfg.bookPassword()));
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(new URL(cfg.bookBaseUrl()))
                .addConverterFactory(ScalarsConverterFactory.create())
                .client(okHttp.build())
                .build();
        return retrofit.create(service);
    }
}
