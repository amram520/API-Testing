package e2e.tests;

import lombok.val;
import e2e.bookServices.Book;
import e2e.bookServices.BookService;
import lombok.SneakyThrows;
import net.javacrumbs.jsonunit.assertj.JsonAssertions;
import org.json.JSONObject;
import org.testng.annotations.Test;
import retrofit2.Call;

import static org.assertj.core.api.Assertions.assertThat;
import static payloadRepo.PayloadRepository.getPayloadAsJsonObject;

public class bookApiTests {

    private BookService bookService = Book.createService(BookService.class);

    @Test
    @SneakyThrows
    public void testValid() {
        val response = bookService.booksList().execute();
        System.out.println(response);
        System.out.println(response.body());
        assertThat(response.code()).isEqualTo(200);
    }
    @Test
    @SneakyThrows
    public void bookByIdTest() {
        String id = "2";
        Call<String> call = bookService.bookById(id);
        val response = call.execute();
        System.out.println(response);
        System.out.println(response.body());
        JsonAssertions.assertThatJson(response.body()).node("bookingdates").node("checkin").isEqualTo("2015-04-16");
        assertThat(response.code()).isEqualTo(200);
    }

    @SneakyThrows
    @Test
    public void updateBookTest() {
        int id = 3;
        JSONObject userPayload = getPayloadAsJsonObject("bookRequest");
        val response = bookService.updateBook(id,userPayload.toString()).execute();
        System.out.println(response);
        System.out.println(response.body());
        assertThat(response.code()).isEqualTo(200);
    }
}
