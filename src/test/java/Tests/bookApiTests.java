package Tests;

import Endpoints.BookService;
import lombok.SneakyThrows;
import net.javacrumbs.jsonunit.assertj.JsonAssertions;
import org.json.JSONObject;
import org.testng.annotations.Test;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;

import static org.assertj.core.api.Assertions.assertThat;
import static org.payloadRepo.PayloadRepository.getPayloadAsJsonObject;

public class bookApiTests {

    public BookService createBookService() {
//        OkHttpClient.Builder ok = null;
//        ok.authenticator((route, response) ->
//                response.request().newBuilder()
//                        .header("Accept", "application/json")
//                        .build());
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://restful-booker.herokuapp.com/")
                .addConverterFactory(ScalarsConverterFactory.create())
                .build();
        return retrofit.create(BookService.class);
    }
    private BookService bookService = createBookService();

    @Test
    @SneakyThrows
    public void testValid() {
        Response<String> response = bookService.booksList().execute();
        System.out.println(response);
        System.out.println(response.body());
        assertThat(response.code()).isEqualTo(200);
    }
    @Test
    @SneakyThrows
    public void bookByIdTest() {
        String id = "2";
        Call<String> call = bookService.bookById(id);
        Response<String> response = call.execute();
        System.out.println(response);
        System.out.println(response.body());
        JsonAssertions.assertThatJson(response.body()).node("bookingdates").node("checkin").isEqualTo("2022-06-12");

        assertThat(response.code()).isEqualTo(200);
    }


    @Test
    @SneakyThrows
    public void updateBookTest() {
        int id = 1;
        JSONObject userPayload = getPayloadAsJsonObject("userRequest");
        Response<String> response = bookService.updateBook(id).execute();
        System.out.println(response);
        System.out.println(response.body());
        assertThat(response.code()).isEqualTo(200);
    }
}
