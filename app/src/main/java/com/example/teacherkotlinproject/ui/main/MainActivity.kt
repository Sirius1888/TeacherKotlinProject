package com.example.teacherkotlinproject.ui.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.teacherkotlinproject.R
import com.example.teacherkotlinproject.helper.SharedPreferences
import com.example.teacherkotlinproject.ui.cat.CatFragment
import com.example.teacherkotlinproject.ui.dog.DogFragment
import com.example.teacherkotlinproject.ui.pet.PetFragment
import com.example.teacherkotlinproject.ui.profile.ProfileFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    /*!!Подготовиться к ежемесячному экзамену по темам:
        Recycler, Snackbar,
        Dialogs, toolbar, fragment,
        viewpager, tabLayout,
        bottomNavigationView
     */
    //Если есть номер телефона в поле phoneNumber тогда сделать переход на звонилку устройства иначе отобразить сообщение "Номер отсутствует"
    //Упростить 2 метода в ProfileFragment - setEditState(), updateEditingViews()
    //(Доп) отказаться от переменной isEdit в ProfileFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupBottomNavigation()
        addStartFragment()
    }

    private fun setupBottomNavigation() {
        bottom_navigation.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.pets -> navigateFragment(PetFragment())
                R.id.profile -> navigateFragment(ProfileFragment())
                else -> false
            }
        }
    }

    private fun navigateFragment(fragment: Fragment): Boolean {
        supportFragmentManager.beginTransaction().replace(R.id.container_fragment, fragment).commit()
        return true
    }

    private fun addStartFragment() {
        supportFragmentManager.beginTransaction().add(R.id.container_fragment, PetFragment()).commit()
    }

}