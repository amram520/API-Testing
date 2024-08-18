package org.openProjectServices;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface ViewsService {

    @GET("views")
    Call<String> gatViews();

    @POST("views/{id}")
    Call<String> createView(@Path("id") String id, @Body String body);
}
