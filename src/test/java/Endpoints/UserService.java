package Endpoints;

import Models.RootRequest;
import Models.RootResponse;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.List;

public interface UserService {
    @POST("/api/users")
    Call<String> createUser(@Body String createUserRequest);

    @GET("/api/users?page=2")
    Call<String> listUsers();

    @GET("/api/users/2")
    Call<String> updateUser();


    @POST("/school")
    Call<RootResponse> createStudent(@Body RootRequest student);

    @POST("/school")
    Call<String> createStudent2(@Body RootRequest student);

    @GET("/getAll")
    Call<List<RootResponse>> getAllStudents();

    @GET("/department/{id}")
    Call<String> getStudent(@Path("id") Long id);


}
