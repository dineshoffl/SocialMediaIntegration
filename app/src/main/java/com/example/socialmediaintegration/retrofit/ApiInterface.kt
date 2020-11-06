package com.example.socialmediaintegration.retrofit

import androidx.lifecycle.LiveData
import com.example.socialmediaintegration.api.ApiResponse
import io.reactivex.Single
import okhttp3.Call
import okhttp3.ResponseBody
import retrofit2.http.GET


interface ApiInterface {

    @GET("/data/2.5/weather")
    fun getWeatherReport(): LiveData<ApiResponse<Void>>

}