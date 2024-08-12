package Endpoints;

import Models.RootBookResponse;
import retrofit2.Call;
import retrofit2.http.*;

public interface BookService {

    @GET("/booking")
    Call<String> booksList();

    @Headers("Accept: */*")
    @GET("/booking/{id}")
    Call<String> bookById(@Path("id") String i);

    @PUT("/booking/{id}")
    Call<String> updateBook(@Path("id") int i);


}
