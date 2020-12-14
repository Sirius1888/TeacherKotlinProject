package com.example.teacherkotlinproject.helper

import android.content.Context
import android.content.SharedPreferences
import androidx.core.content.edit

const val NAME = "name"
const val SURNAME = "surname"
const val IMAGE = "image"
const val PHONE_NUMBER = "phoneNumber"

class SharedPreferences(context: Context) {

    private val sharedPreferences: SharedPreferences = context.getSharedPreferences("application", Context.MODE_PRIVATE)

    var name: String
    get() {
        return sharedPreferences.getStringOrDefault(NAME, "Sergey")
    }
    set(value) {
        sharedPreferences.edit {
            putString(NAME, value)
        }
    }

    var surname: String
    get() {
        return sharedPreferences.getStringOrDefault(SURNAME, "Karukes")
    }
    set(value) {
        sharedPreferences.edit {
            putString(SURNAME, value)
        }
    }

    var image: String
    get() {
        return sharedPreferences.getStringOrDefault(IMAGE, "https://knowhow.pp.ua/wp-content/uploads/2020/05/unnamed-2.jpg")
    }
    set(value) {
        sharedPreferences.edit {
            putString(IMAGE, value)
        }
    }

    var phoneNumber: String
    get() {
        return sharedPreferences.getStringOrDefault(PHONE_NUMBER, "+996555555000")
    }
    set(value) {
        return sharedPreferences.edit {
            putString(PHONE_NUMBER, value)
        }
    }

    private fun SharedPreferences.getStringOrDefault(key: String, default: String = "") =
        getString(key, default) ?: default
}

