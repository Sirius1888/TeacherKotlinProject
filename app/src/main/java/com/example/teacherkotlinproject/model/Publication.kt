package com.example.teacherkotlinproject.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Publication(
    var id: Int,
    @SerializedName("image") var icon: String,
    var name: String,
    var phoneNumber: String,
    var age: Int,
    var countOfFavorite: Int,
    var images: MutableList<Images>,
    val randomImage: String,
    var isFavorite: Boolean = false
): Serializable

data class Images(
    var url: String? = null
)