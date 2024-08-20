package e2e.userServices;

import retrofit2.Call;
import retrofit2.http.*;

public interface UserService {
    @POST("/api/users")
    Call<String> createUser(@Body String createUserRequest);

    @GET("/api/users?page=2")
    Call<String> listUsers();

    @GET("/api/users/2")
    Call<String> updateUser();


}
