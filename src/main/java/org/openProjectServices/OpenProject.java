package org.openProjectServices;

import lombok.Getter;
import lombok.SneakyThrows;
import okhttp3.OkHttpClient;
import org.config.AutoConfig;
import org.utils.BasicAuthInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;

import java.net.URL;
@Getter
public class OpenProject {


    @SneakyThrows
    public static <T> T createService(final Class<T> service){
        AutoConfig cfg = org.aeonbits.owner.ConfigFactory.create(AutoConfig.class);
        OkHttpClient.Builder okHttp = new OkHttpClient.Builder().addInterceptor(
                new BasicAuthInterceptor("apikey", cfg.apiKey()));
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(new URL(cfg.baseUrl()))
                .addConverterFactory(ScalarsConverterFactory.create())
                .client(okHttp.build())
                .build();
        return retrofit.create(service);
    }

}
