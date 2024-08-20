package e2e.openProjectServices;

import retrofit2.Call;
import retrofit2.http.*;

public interface WorkPackagesService {

    @GET("projects/{id}/work_packages")
    Call<String> getWorkPackagesByProjectId(@Path("id") int id);

    @Headers("Content-Type: application/json")
    @POST("work_packages")
    Call<String> createWorkPackages(@Body String body);

    @GET("work_packages/{id}")
    Call<String> getWorkPackageById(@Path("id") int id);

    @DELETE("work_packages/{id}")
    Call<String> deleteWorkPackage(@Path("id") int id);

    @GET("work_packages")
    Call<String> getAllWorkPackage();
}
