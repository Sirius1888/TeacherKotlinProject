package com.example.teacherkotlinproject

var array = mutableListOf<String>()

var imageArray = mutableListOf<Int>().apply {
    add(R.mipmap.london)
    add(R.mipmap.madrid)
    add(R.mipmap.paris)
}

var cityArray = mutableListOf<City>().apply {
    add(City(R.mipmap.london, "London", "London is biggest city in British"))
    add(City(R.mipmap.madrid, "Madrid", "Madrid is biggest city in Spain"))
    add(City(R.mipmap.paris, "Paris", "Paris is biggest city in France"))
    add(City(R.mipmap.london, "Bishkek", "Bishkek is biggest city in Kyrgyzstan"))
    add(City(R.mipmap.madrid, "Moscow", "Moscow is biggest city in Russia"))
    add(City(R.mipmap.paris, "Nur-Sultan", "Nur-Sultan is biggest city in Kazakhstan"))
}
