package com.example.teacherkotlinproject.ui.main

import android.graphics.drawable.PictureDrawable
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.teacherkotlinproject.R
import com.example.teacherkotlinproject.ui.favorite.FavoriteFragment
import com.example.teacherkotlinproject.ui.main.adapter.MainViewPagerAdapter
import com.example.teacherkotlinproject.ui.profile.ProfileFragment
import com.example.teacherkotlinproject.ui.publication.PublicationFragment
import kotlinx.android.synthetic.main.activity_main.*
import java.io.InputStream

//Если мы открываем активити, то используем - Intent (Данные передаем через Intent)
//Если мы открываем фрагмент из активити, то используем - supportFragmentManager (Данные передаем через Bundle)
//Если мы открываем фрагмент из фрагмента, то используем - childFragmentManager (Данные передаем через Bundle)

class MainActivity : AppCompatActivity() {

    lateinit var adapter: MainViewPagerAdapter
    private lateinit var repository: MainRepository
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupViewPager()
        setupBottomNavigationView()
    }

    private fun setupViewPager() {
        adapter = MainViewPagerAdapter(this)
        adapter.addFragment(PublicationFragment())
        adapter.addFragment(FavoriteFragment())
        adapter.addFragment(ProfileFragment())
        view_pager.adapter = adapter
        view_pager.isUserInputEnabled = false
    }

    private fun setupBottomNavigationView() {
        bottom_navigation_view.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.image -> changeCurrentFragment(0)
                R.id.favorite -> changeCurrentFragment(1)
                R.id.profile -> changeCurrentFragment(2)
            }
            true
        }
    }

    private fun changeCurrentFragment(position: Int) {
        view_pager.setCurrentItem(position, false)
    }
}