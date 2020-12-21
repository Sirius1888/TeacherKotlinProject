package com.example.teacherkotlinproject.models

import java.io.Serializable


data class Pet(
    var image: String,
    var name: String,
    var height: String,
    var isLiked: Boolean = false,
    var description: String,
    var species: String
): Serializable

val catArray = mutableListOf<Pet>().apply {
    add(Pet("https://petstime.ru/sites/default/files/styles/article-600/public/inline/images/angliyskie1.jpg?itok=YbmUSUmb", "Tom", "30", true, "Hate Jerry", "home"))
    add(Pet("https://petstime.ru/sites/default/files/styles/article-600/public/inline/images/angliyskie2.jpg?itok=ecOfLA1B","Jeny", "28", false, "Little kitty", "swinks"))
    add(Pet("https://petstime.ru/sites/default/files/styles/article-600/public/inline/images/angliyskie3.jpg?itok=m-BJQfhT", "Ki", "18", false, "Ко́шка, или дома́шняя ко́шка, — домашнее животное, одно из наиболее популярных «животных-компаньонов».", "Canadian"))
    add(Pet("https://petstime.ru/sites/default/files/styles/article-600/public/inline/images/angliyskie4.jpg?itok=kd8HhM4m", "Milo", "30", false, "Ко́шка, или дома́шняя ко́шка, — домашнее животное, одно из наиболее популярных «животных-компаньонов».", "home"))
    add(Pet("https://petstime.ru/sites/default/files/styles/article-600/public/inline/images/angliyskie5.jpg?itok=n5_WHkYq", "Simon", "35", true, "Ко́шка, или дома́шняя ко́шка, — домашнее животное, одно из наиболее популярных «животных-компаньонов».", "British"))
    add(Pet("https://petstime.ru/sites/default/files/styles/article-600/public/inline/images/angliyskie6.jpeg?itok=_uuhQzER","Jasper", "10", true, "Ко́шка, или дома́шняя ко́шка, — домашнее животное, одно из наиболее популярных «животных-компаньонов».", "home"))
}

val dogArray = mutableListOf<Pet>().apply {
    add(Pet("https://icdn.lenta.ru/images/2019/12/06/12/20191206122159535/pwa_vertical_1280_dab2ef83b33313f403795e63869f6cc7.jpg", "Tom", "65", true, "Соба́ка — домашнее животное, одно из наиболее популярных животных-компаньонов. Первоначально домашняя собака была выделена в отдельный биологический вид Линнеем в 1758 году, в 1993 году реклассифицирована Смитсоновским институтом и Американской ассоциацией териологов в подвид волка.", "home"))
    add(Pet("https://b1.m24.ru/c/1351349.jpg","Jeny", "28", false, "Little kitty", "swinks"))
    add(Pet("https://i.ytimg.com/vi/nLTTa0ToTU8/maxresdefault.jpg", "Ki", "18", false, "Соба́ка — домашнее животное, одно из наиболее популярных животных-компаньонов. Первоначально домашняя собака была выделена в отдельный биологический вид Линнеем в 1758 году, в 1993 году реклассифицирована Смитсоновским институтом и Американской ассоциацией териологов в подвид волка.", "Canadian"))
    add(Pet("https://icdn.lenta.ru/images/2019/12/06/12/20191206122159535/pwa_vertical_1280_dab2ef83b33313f403795e63869f6cc7.jpg", "Tom", "55", true, "Hate Jerry", "home"))
    add(Pet("https://b1.m24.ru/c/1351349.jpg","Jeny", "28", false, "Little kitty", "swinks"))
    add(Pet("https://i.ytimg.com/vi/nLTTa0ToTU8/maxresdefault.jpg", "Ki", "30", false, "Соба́ка — домашнее животное, одно из наиболее популярных животных-компаньонов. Первоначально домашняя собака была выделена в отдельный биологический вид Линнеем в 1758 году, в 1993 году реклассифицирована Смитсоновским институтом и Американской ассоциацией териологов в подвид волка.", "Canadian"))
}