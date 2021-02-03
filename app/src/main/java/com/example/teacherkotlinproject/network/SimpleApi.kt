package com.example.teacherkotlinproject.network

import com.example.teacherkotlinproject.model.Meet
import retrofit2.Call
import retrofit2.http.GET


interface SimpleApi {
    //baseUrl = https://lovetest.me
    @GET("/a_test_1/test_app.json")
    fun getMeet(): Call<MutableList<Meet>>
}