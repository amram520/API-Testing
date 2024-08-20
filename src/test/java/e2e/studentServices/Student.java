package e2e.studentServices;

import lombok.SneakyThrows;
import org.config.AutoConfig;
import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;

import java.net.URL;

public class Student {

    @SneakyThrows
    public static <T> T createService(final Class<T> service){
        AutoConfig cfg = org.aeonbits.owner.ConfigFactory.create(AutoConfig.class);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(new URL(cfg.studentBaseUrl()))
                .addConverterFactory(ScalarsConverterFactory.create())
                .build();
        return retrofit.create(service);
    }
}
