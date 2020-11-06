package com.example.socialmediaintegration.retrofit

import io.reactivex.Single
import okhttp3.ResponseBody
import retrofit2.http.GET


interface ApiInterface {

    @GET("/data/2.5/weather")
    fun getWeatherReport(): Single<ResponseBody>

}