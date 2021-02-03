package com.example.teacherkotlinproject.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class RetrofitClient {

    val retrofit = Retrofit.Builder()
        .baseUrl("https://lovetest.me")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val simpleApi = retrofit.create(SimpleApi::class.java)
}