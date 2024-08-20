package e2e.petServices;
import retrofit2.Call;
import retrofit2.http.*;

public interface PetService {

//    @GET("pet/findByStatus")
//    Call<PetRootResponse> addPet(@Query("status") String petStatus) ;

    @POST("pet")
    Call<String> createPet(@Body String pet);

    @GET("/store/inventory")
    Call<String> store();

}
