package e2e.apiTests;

import retrofit2.Call;
import retrofit2.http.GET;

public interface MockoonService {

    @GET("lior")
    Call<String> getSomething();
}
