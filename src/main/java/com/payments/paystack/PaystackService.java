package com.payments.paystack;

import com.payments.paystack.PaystackSetup;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.Request.Builder;

import retrofit2.Call;

public abstract class PaystackService<T> {

    @SuppressWarnings({ "unchecked", "rawtypes" })
    public final IResult<?> enqueue(final Call<?> call, final IResult resultCallback) {
        call.enqueue(resultCallback);
        return resultCallback;
    }

    public abstract T getServiceApi();

    protected final OkHttpClient getHttpClient() {
        return new OkHttpClient.Builder().readTimeout(PaystackSetup.getReadTimeout(), TimeUnit.SECONDS)
                .writeTimeout(PaystackSetup.getWriteTimeout(), TimeUnit.SECONDS)
                .connectTimeout(PaystackSetup.getConnectTimeout(), TimeUnit.SECONDS).addInterceptor(new Interceptor() {
                    @Override
                    public Response intercept(Chain chain) throws IOException {
                        String authToken = PaystackSetup.getAuthToken();
                        Request originalRequest = chain.request();
                        Builder newRequestBuilder = originalRequest.newBuilder().addHeader("Authorization",
                                authToken == null ? "" : "Bearer " + authToken);
                        Response response = chain.proceed(newRequestBuilder.build());
                        return response;
                    }
                }).cache(null).build();
    }
}