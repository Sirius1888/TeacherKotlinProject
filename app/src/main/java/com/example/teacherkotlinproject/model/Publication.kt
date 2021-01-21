package com.example.teacherkotlinproject.model

data class Publication(
    var name: String,
    var phoneNumber: String,
    var age: Int,
    var image: MutableList<String>,
    var isFavorite: Boolean = false
)

val imagesArray = mutableListOf<String>().apply {
    add("https://icatcare.org/app/uploads/2018/07/Thinking-of-getting-a-cat.png")
    add("https://img.webmd.com/dtmcms/live/webmd/consumer_assets/site_images/article_thumbnails/other/cat_relaxing_on_patio_other/1800x1200_cat_relaxing_on_patio_other.jpg")
    add("https://www.study.ru/uploads/server/YNUzTtg0hUDiTWiP.jpg")
}

val publicationsArray = mutableListOf<Publication>().apply {
    add(Publication("John", "999777222107", 30, imagesArray))
    add(Publication("Sara", "999777222111", 35, imagesArray))
    add(Publication("Andry", "999777555333", 29, imagesArray))
    add(Publication("German", "999777555112", 40, imagesArray))
    add(Publication("Klara", "999777234198", 25, imagesArray))
    add(Publication("Anna", "999777222111", 40, imagesArray))
    add(Publication("Jinny", "999777242106", 49, imagesArray))
}