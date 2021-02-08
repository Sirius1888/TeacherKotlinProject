package com.example.teacherkotlinproject.network

import com.example.teacherkotlinproject.model.Publication
import retrofit2.Call
import retrofit2.http.GET


interface SimpleApi {

    @GET("raw/feddd59ced26e92850a45d5e048ec5c3b277e098/Publication.json")
    fun fetchPublications(): Call<MutableList<Publication>>

    @GET("raw/aa8429874c3eaf21537ce5074f81bc64bd28f987/Profile.json")
    fun fetchProfile(): Call<Publication>


}