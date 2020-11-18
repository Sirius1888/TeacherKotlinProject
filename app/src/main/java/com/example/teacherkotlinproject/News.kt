package com.example.teacherkotlinproject

import java.io.Serializable


data class News(
    var image: Int,
    var title: String,
    var description: String
): Serializable

var newsArray = mutableListOf<News>().apply {
    add(News(R.mipmap.madrid,
        "Для преодоления последствий COVID предложено использовать потенциал СНГ",
    "На встрече с коллегами из СНГ секретарь Совбеза Кыргызстана также сделал акцент на усилении сотрудничества в торгово-экономической сфере."))
    add(News(R.mipmap.madrid,
        "Что говорят инициаторы проекта Конституции — ответы 13 депутатов",
    "Проект Конституции вызвал немало вопросов у общественности и юристов. Редакция Sputnik Кыргызстан обратилась к инициаторам, чтобы они рассказали о проекте, в том числе о том, кто был его автором и поддерживают ли они сами предлагаемые изменения."))
    add(News(R.mipmap.madrid,
        "Мамытов попросил Казахстан разрешить транзитный проезд кыргызстанцам",
        "И. о. президента также обратил внимание казахстанской стороны на возможность оказания содействия в беспрепятственном проезде грузовых авто через пункты пропуска на участках госграницы."))
    add(News(R.mipmap.madrid,
        "Главное о референдуме в Кыргызстане — справка из закона",
        "Что такое референдум и какие правила необходимо соблюсти, чтобы он состоялся, читайте в справочном материале Sputnik Кыргызстан."))
}