package Endpoints;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.Path;

public interface OpenProjectService {

    @Headers("Accept: application/json")
    @GET("/projects/{id}")
    Call<String> getProjectById(@Header("Authorization") String authorization, @Path("id") int id);

}
