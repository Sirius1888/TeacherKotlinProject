package com.example.teacherkotlinproject.model

data class Contact(
    var name: String,
    var phoneNumber: String,
    var age: Int,
    var image: String
)


val contactsArray = mutableListOf<Contact>().apply {
    add(Contact("John", "999777222107", 30, ""))
    add(Contact("Sara", "999777222111", 35, ""))
    add(Contact("Andry", "999777555333", 29, ""))
    add(Contact("German", "999777555112", 40, ""))
    add(Contact("Klara", "999777234198", 25, ""))
    add(Contact("Anna", "999777222111", 40, ""))
    add(Contact("Jinny", "999777242106", 49, ""))
}