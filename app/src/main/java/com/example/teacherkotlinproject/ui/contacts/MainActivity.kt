package com.example.teacherkotlinproject.ui.contacts

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.teacherkotlinproject.R
import com.example.teacherkotlinproject.models.Contact


//A - activitty, F - Fragment
//A (a) -> A (b), A (a) <- A (b)
//A -> F
//F -> A
//F -> F // Bundle

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager
            .beginTransaction()
            .add(R.id.container_fragment, ContactFragment())
            .commit()
    }

}