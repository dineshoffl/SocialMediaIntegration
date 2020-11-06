package com.example.socialmediaintegration.di

import androidx.annotation.NonNull
import com.example.socialmediaintegration.BuildConfig
import com.example.socialmediaintegration.retrofit.ApiInterface
import dagger.Module
import dagger.Provides
import okhttp3.HttpUrl
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

/**
 * Module for injecting Retrofit and related Networking components
 */
@Module
internal class RepositoryModule {
    @Singleton
    @Provides
    fun providesHTTPClient(): OkHttpClient {
        val httpClient = OkHttpClient.Builder()
        if (BuildConfig.DEBUG) {
            val interceptor = HttpLoggingInterceptor()
            interceptor.level = HttpLoggingInterceptor.Level.BODY
            httpClient.addInterceptor(interceptor)
        }
        OkHttpClient()

        httpClient.interceptors().add(Interceptor { chain ->
            var request: Request = chain.request()
            val url: HttpUrl =
                request.url.newBuilder().addQueryParameter("q", "London")
                    .addQueryParameter("appid", "e87ac04dced38a378463c1c2f566eba3")
                    .build()
            request = request.newBuilder().url(url).build()
            chain.proceed(request)
        })
        return httpClient.build()
    }

    @Singleton
    @Provides
    fun providesRetrofit(@NonNull client: OkHttpClient?): Retrofit {
        return Retrofit.Builder()
            .baseUrl("http://api.openweathermap.org/")
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
    }

    @Singleton
    @Provides
    fun providesApiInterface(@NonNull retrofit: Retrofit): ApiInterface {
        return retrofit.create(ApiInterface::class.java)
    }
}