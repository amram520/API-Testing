package Endpoints;

import Models.RootBookResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface BookService {

    @GET("/booking")
    Call<String> booksList();

    @GET("/booking/{id}")
    Call<String> bookById(@Header("Accept") String accept, @Path("id") String i);

    @PUT("/booking/{id}")
    Call<String> updateBook(@Path("id") int i);


}
