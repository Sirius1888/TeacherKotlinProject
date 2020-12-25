package com.example.teacherkotlinproject.ui.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.teacherkotlinproject.R
import com.example.teacherkotlinproject.ui.favorites.FavoritesPetsFragment
import com.example.teacherkotlinproject.ui.main.adapter.MainViewPagerAdapter
import com.example.teacherkotlinproject.ui.pet.PetFragment
import com.example.teacherkotlinproject.ui.profile.ProfileFragment
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.view_pager

class MainActivity : AppCompatActivity() {

    //подумать как можно убрать CatFragment и DogFragment
    //Вместо этих фрагментов использовать PetListFragment

    lateinit var adapter: MainViewPagerAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupBottomNavigation()
        setupViewPager()
    }

    private fun setupViewPager() {
        adapter = MainViewPagerAdapter(this)
        adapter.addFragment(PetFragment())
        adapter.addFragment(ProfileFragment())
        adapter.addFragment(FavoritesPetsFragment())
        view_pager.offscreenPageLimit = 3
        view_pager.adapter = adapter
        view_pager.isEnabled = false
        view_pager.isUserInputEnabled = false
    }

    private fun setupBottomNavigation() {
        bottom_navigation.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.pets -> view_pager.setCurrentItem(0, false)
                R.id.profile -> view_pager.setCurrentItem(1, false)
                R.id.favorite -> view_pager.setCurrentItem(2, false)
            }
            true
        }
    }
}