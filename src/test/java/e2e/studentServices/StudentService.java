package e2e.studentServices;

import e2e.models.RootRequest;
import e2e.models.RootResponse;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

import java.util.List;

public interface StudentService {

    @POST("/school")
    Call<RootResponse> createStudent(@Body RootRequest student);

    @POST("/school")
    Call<String> createStudent2(@Body RootRequest student);

    @GET("/getAll")
    Call<List<RootResponse>> getAllStudents();

    @GET("/department/{id}")
    Call<String> getStudent(@Path("id") Long id);
}
