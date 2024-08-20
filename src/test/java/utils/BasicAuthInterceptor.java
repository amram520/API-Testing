package utils;

import il.co.topq.difido.model.Enums;
import okhttp3.Credentials;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class BasicAuthInterceptor extends TestCase implements Interceptor{

    private String credentials;

    public BasicAuthInterceptor(String user, String password) {
        this.credentials = Credentials.basic(user, password);
    }
    @Override
    public Response intercept(Interceptor.Chain chain) throws IOException {
        Request request = chain.request();
        Request authenticatedRequest = request.newBuilder()
                .header("Authorization", credentials).build();
//        report.startLevel("The response sent");
//        report.log(String.format("The sending url request %s ", request.url()));
//        report.endLevel();
        Response response = chain.proceed(authenticatedRequest);
//        System.out.println(response.body());
//        if (response.isSuccessful()) {
//            report.startLevel("The response received");
//            report.log("The response was successfully received", Enums.Status.success);
//            report.log("Response status:",response.toString());
//            report.log("Response headers:",response.headers().toString());
//            report.endLevel();
//        }
//        else {
//            report.startLevel("The response received");
//            report.log("The response is failed", Enums.Status.failure);
//            report.log("Status response:", response.toString());
//            report.log("Response headers:", response.headers().toString());
//            report.endLevel();
//        }
        return response;
    }

}
