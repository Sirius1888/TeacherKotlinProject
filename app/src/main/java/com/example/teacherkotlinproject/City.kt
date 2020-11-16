package com.example.teacherkotlinproject

import java.io.Serializable

//Сериализация(Превращение объекта в другой вид) и Десериализация(И возвращение объекта в обычное состояние)
data class City(
    var image: Int,
    var name: String,
    var description: String
) : Serializable