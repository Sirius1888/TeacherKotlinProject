package com.example.teacherkotlinproject.ui.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.teacherkotlinproject.R
import com.example.teacherkotlinproject.helper.SharedPreferences
import com.example.teacherkotlinproject.ui.cat.CatFragment
import com.example.teacherkotlinproject.ui.dog.DogFragment
import com.example.teacherkotlinproject.ui.main.adapter.MainViewPagerAdapter
import com.example.teacherkotlinproject.ui.pet.PetFragment
import com.example.teacherkotlinproject.ui.pet.PetViewPagerAdapter
import com.example.teacherkotlinproject.ui.profile.ProfileFragment
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.view_pager
import kotlinx.android.synthetic.main.fragment_pet.*

class MainActivity : AppCompatActivity() {

    //Добавить новый фрагмент FavoritesPets
    //Добавить новый элемент в bottom navigation view (сердечко)
    //В layout добавить TextViw на весь экран с название Favorites pets

    lateinit var adapter: MainViewPagerAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupBottomNavigation()
        setupViewPager()
    }

    private fun setupViewPager() {
        adapter = MainViewPagerAdapter(supportFragmentManager)
        adapter.addFragment(PetFragment())
        adapter.addFragment(ProfileFragment())
        view_pager.adapter = adapter
    }

    private fun setupBottomNavigation() {
        bottom_navigation.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.pets -> view_pager.setCurrentItem(0, false)
                R.id.profile -> view_pager.setCurrentItem(1, false)
            }
            true
        }
    }
}