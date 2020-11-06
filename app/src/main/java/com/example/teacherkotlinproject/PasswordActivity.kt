package com.example.teacherkotlinproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_password.*

class PasswordActivity : AppCompatActivity() {

    private lateinit var shared: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_password)
        shared = SharedPreferences(this)
        confirmAction()
    }

    private fun confirmAction() {
        check_password_button.setOnClickListener {
            val password = password_edit_text.text.toString()
            if (password.isEmpty() && password != shared.password) return@setOnClickListener

            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }

}