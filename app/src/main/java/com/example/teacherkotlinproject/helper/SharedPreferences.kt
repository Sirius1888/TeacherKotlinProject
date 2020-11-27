package com.example.teacherkotlinproject.helper

import android.content.Context
import android.content.SharedPreferences
import androidx.core.content.edit

const val LOGIN = "login"
const val PASSWORD = "password"

class SharedPreferences(context: Context) {

    private val sharedPreferences: SharedPreferences = context.getSharedPreferences("authorization_application", Context.MODE_PRIVATE)

    var login: String
    get() {
        return sharedPreferences.getStringOrDefault(LOGIN)
    }
    set(value) {
        sharedPreferences.edit {
            putString(LOGIN, value)
        }
    }

    var password: String
        get() {
            return sharedPreferences.getStringOrDefault(PASSWORD)
        }
        set(value) {
            sharedPreferences.edit {
                putString(PASSWORD, value)
            }
        }

    private fun SharedPreferences.getStringOrDefault(key: String, default: String = "") =
        getString(key, default) ?: default
}

