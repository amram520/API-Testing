package org.bookServices;

import retrofit2.Call;
import retrofit2.http.*;

public interface BookService {

    @GET("/booking")
    Call<String> booksList();

    @Headers("Accept: */*")
    @GET("/booking/{id}")
    Call<String> bookById(@Path("id") String i);

    @Headers({"Content-Type: application/json","Accept: application/json"})
    @PUT("booking/{id}")
    Call<String> updateBook(@Path("id") int i, @Body String body);


}
