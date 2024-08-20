package e2e.tests;

import e2e.models.RootRequest;
import e2e.models.RootResponse;
import e2e.studentServices.Student;
import e2e.studentServices.StudentService;
import lombok.SneakyThrows;
import lombok.val;
import org.testng.annotations.Test;
import utils.SchemaValidator;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class studentApiTests {
    public StudentService createUserService() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://localhost:8082/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit.create(StudentService.class);
    }

    private StudentService studentService = createUserService();

    private StudentService service = Student.createService(StudentService.class);


    @Test
    @SneakyThrows
    public void createStudentTest() throws IOException {
//        Guardian guardian = new Guardian("eli", "088065454");
        RootRequest rootRequest = new RootRequest("boki", "2003-07-11", "sdfds@gmail.com");
        Response<RootResponse> response = studentService.createStudent(rootRequest).execute();
        System.out.println("response");
        System.out.println(response.body().getName());
        assertThat(response.code()).isEqualTo(200);
        assertThat(response.body().getName())
                .isNotEmpty()
                .isEqualTo(rootRequest.getName());
    }
    @Test
    @SneakyThrows
    public void getAllStudentTest() throws IOException {
        Response<List<RootResponse>> response = studentService.getAllStudents().execute();
        System.out.println(response);
        System.out.println(response.body());
        assertThat(response.code()).isEqualTo(200);
    }

    @Test
    @SneakyThrows
    public void getStudentTest() throws IOException {
        Long id = 6L;
        val response = service.getStudent(id).execute();
        System.out.println(response);
        System.out.println(response.body());
        assertThat(response.code()).isEqualTo(200);
        SchemaValidator.schemaValidate(response.body(), "studentSchema");

    }
}
