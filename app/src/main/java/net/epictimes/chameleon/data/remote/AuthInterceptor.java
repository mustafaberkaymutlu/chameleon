package net.epictimes.chameleon.data.remote;

import android.support.annotation.NonNull;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class AuthInterceptor implements Interceptor {
    @Override
    public Response intercept(@NonNull Chain chain) throws IOException {
        final Request request = chain.request()
                .newBuilder()
                .addHeader("consumer_key", Services.CONSUMER_KEY)
                .build();

        return chain.proceed(request);
    }
}
