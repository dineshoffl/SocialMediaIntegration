package com.example.socialmediaintegration

import okhttp3.*
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object ApiClient {

    open fun getClient(): Retrofit {
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
                request.url().newBuilder().addQueryParameter("q", "London")
                    .addQueryParameter("appid", "e87ac04dced38a378463c1c2f566eba3")
                    .build()
            request = request.newBuilder().url(url).build()
            chain.proceed(request)
        })
        return Retrofit.Builder()
            .baseUrl("http://api.openweathermap.org/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(httpClient.build())
            .build()
    }
}