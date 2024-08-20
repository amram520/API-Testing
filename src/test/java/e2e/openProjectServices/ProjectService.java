package e2e.openProjectServices;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ProjectService {

//    @Headers({"Accept: application/json"})
    @GET("projects/{id}")
    Call<String> getProjectById(@Path("id") int id);

    @GET("projects/schema")
    Call<String> getProjectSchema();

}
