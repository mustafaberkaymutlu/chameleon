package net.epictimes.chameleon.data.remote;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.facebook.stetho.okhttp3.StethoInterceptor;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import net.epictimes.chameleon.BuildConfig;
import net.epictimes.chameleon.data.PhotoDataSource;
import net.epictimes.chameleon.di.doc.RemoteDataSource;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class RemoteDataSourceModule {

    @RemoteDataSource
    @Singleton
    @Provides
    PhotoDataSource provideRemoteDataSource(Services services) {
        return new PhotoRemoteDataSource(services);
    }

    @Singleton
    @Provides
    Services provideServices(@NonNull Retrofit retrofit) {
        return retrofit.create(Services.class);
    }

    @Singleton
    @Provides
    Retrofit provideRetrofit(@NonNull OkHttpClient okHttpClient, @NonNull Gson gson) {
        return new Retrofit.Builder()
                .baseUrl(Services.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(okHttpClient)
                .build();
    }

    @Singleton
    @Provides
    OkHttpClient provideOkHttpClient(@NonNull AuthInterceptor authInterceptor,
                                     @Nullable StethoInterceptor stethoInterceptor,
                                     @Nullable HttpLoggingInterceptor httpLoggingInterceptor) {
        final OkHttpClient.Builder okHttpClientBuilder = new OkHttpClient.Builder();

        okHttpClientBuilder.addInterceptor(authInterceptor);

        if (stethoInterceptor != null) {
            okHttpClientBuilder.addNetworkInterceptor(stethoInterceptor);
        }

        if (httpLoggingInterceptor != null) {
            httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            okHttpClientBuilder.addInterceptor(httpLoggingInterceptor);
        }

        return okHttpClientBuilder.build();
    }

    @Singleton
    @Provides
    Gson provideGson() {
        return new GsonBuilder()
                .setDateFormat(Services.API_DATE_FORMAT)
                .create();
    }

    @Singleton
    @Provides
    AuthInterceptor provideAuthInterceptor() {
        return new AuthInterceptor();
    }

    @Singleton
    @Nullable
    @Provides
    StethoInterceptor provideStethoInterceptor() {
        if (BuildConfig.DEBUG) {
            return new StethoInterceptor();
        }

        return null;
    }

    @Singleton
    @Nullable
    @Provides
    HttpLoggingInterceptor provideHttpLoggingInterceptor() {
        if (BuildConfig.DEBUG) {
            return new HttpLoggingInterceptor();
        }

        return null;
    }

}
