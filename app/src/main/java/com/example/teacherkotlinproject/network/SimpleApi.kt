package com.example.teacherkotlinproject.network

import com.example.teacherkotlinproject.model.Publication
import retrofit2.Call
import retrofit2.http.GET


interface SimpleApi {

    @GET("raw/aecf079d3f312456be5cce39adeef9fb38013972/Publication.json")
    fun fetchPublications(): Call<MutableList<Publication>>

    @GET("raw/aecf079d3f312456be5cce39adeef9fb38013972/Profile.json")
    fun fetchProfile(): Call<Publication>

}