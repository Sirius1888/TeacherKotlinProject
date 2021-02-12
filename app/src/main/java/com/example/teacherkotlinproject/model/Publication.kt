package com.example.teacherkotlinproject.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Publication(
    var id: Int? = null,
    @SerializedName("image") var icon: String? = null,
    var name: String? = null,
    var phoneNumber: String? = null,
    var age: Int? = null,
    var countOfFavorite: Int = 0,
    var images: MutableList<Images>? = null,
    val randomImage: String? = null,
    val comments: MutableList<Comment>? = null,
    var isFavorite: Boolean = false
): Serializable

data class Images(
    var url: String? = null
)