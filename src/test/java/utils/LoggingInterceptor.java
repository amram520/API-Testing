package utils;

import e2e.TestCase;
import il.co.topq.difido.model.Enums;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.util.logging.Logger;

public class LoggingInterceptor extends TestCase implements Interceptor {
   private Logger logger;

   public LoggingInterceptor(){
       logger = Logger.getLogger(LoggingInterceptor.class.getName());
   }
    @Override public Response intercept(Interceptor.Chain chain) throws IOException {
        Request request = chain.request();
        report.startLevel("The request sent");
        report.log(String.format("The sending url request %s ", request.url()));
        report.log(String.format("The sending headers request %s ", request.headers()));
        report.endLevel();

        logger.info(String.format("Sending request %s on %s",
                request.url(), request.headers()));

        Response response = chain.proceed(request);

        if (response.isSuccessful()) {
            report.startLevel("The response received");
            report.log("The response was successfully received", Enums.Status.success);
            report.log("Response status:",response.toString());
            report.log("Response headers:",response.headers().toString());
            report.endLevel();
        }
        else {
            report.startLevel("The response received");
            report.log("The response is failed", Enums.Status.failure);
            report.log("Status response:", response.toString());
            report.log("Response headers:", response.headers().toString());
            report.endLevel();
        }
        System.out.println(response.body().string());
        return response;

    }
}
