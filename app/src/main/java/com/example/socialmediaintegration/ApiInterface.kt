package com.example.socialmediaintegration

import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query


interface ApiInterface {

    @GET("/data/2.5/weather")
    fun getWeatherReport(@Query("q")cityName : String, @Query("appid")apiKey : String): Call<ResponseBody>
}