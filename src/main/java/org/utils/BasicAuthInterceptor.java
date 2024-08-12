package org.utils;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.util.Base64;

public class BasicAuthInterceptor implements Interceptor{

    private String credentials;

    public BasicAuthInterceptor(String user, String password) {
        this.credentials = okhttp3.Credentials.basic(user, password);
    }
    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        Request authenticatedRequest = request.newBuilder()
                .header("Authorization", credentials).build();
        return chain.proceed(authenticatedRequest);
    }
}
