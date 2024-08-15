package org.OpenProject;

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


    private OpenProjectService openProjectService;
    private AutoConfig cfg = org.aeonbits.owner.ConfigFactory.create(AutoConfig.class);
    @SneakyThrows
    public OpenProject(){
        OkHttpClient.Builder okHttp = new OkHttpClient.Builder().addInterceptor(
                new BasicAuthInterceptor("apikey", cfg.apiKey()));
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(new URL(cfg.baseUrl()))
                .addConverterFactory(ScalarsConverterFactory.create())
                .client(okHttp.build())
                .build();
        this.openProjectService = retrofit.create(OpenProjectService.class);
    }

}
