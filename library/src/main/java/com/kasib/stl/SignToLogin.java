package com.kasib.stl;

import com.kasib.stl.network.SignToLoginService;
import com.squareup.okhttp.Interceptor;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;

import retrofit.GsonConverterFactory;
import retrofit.Retrofit;

/**
 * Created by Pasenchuk Victor on 24.10.15
 */
public class SignToLogin {
    private static final String BASE_URL = "https://signtologin.com/mapi/";

    private final String apiKey;

    public SignToLogin(String apiKey) {
        this.apiKey = apiKey;
    }

    public SignToLoginService getSignToLoginService() {
        OkHttpClient client = new OkHttpClient();
        client.interceptors().add(new Interceptor() {
            @Override
            public Response intercept(Interceptor.Chain chain) throws IOException {
                Request request = chain.request();
                Request newRequest;

                newRequest = request.newBuilder()
                        .addHeader("api_key", apiKey)
                        .build();
                return chain.proceed(newRequest);
            }
        });

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit.create(SignToLoginService.class);
    }
}
