package com.example.teacherkotlinproject.ui.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.teacherkotlinproject.R
import com.example.teacherkotlinproject.model.Contact
import com.example.teacherkotlinproject.ui.detail_name.DetailNameFragment
import com.example.teacherkotlinproject.ui.image.ImageListFragment
import com.example.teacherkotlinproject.ui.main.adapter.MainAdapter
import com.example.teacherkotlinproject.ui.main.adapter.MainViewPagerAdapter
import kotlinx.android.synthetic.main.activity_main.*

//Если мы открываем активити, то используем - Intent (Данные передаем через Intent)
//Если мы открываем фрагмент из активити, то используем - supportFragmentManager (Данные передаем через Bundle)
//Если мы открываем фрагмент из фрагмента, то используем - childFragmentManager (Данные передаем через Bundle)
class MainActivity : AppCompatActivity(), MainAdapter.ClickListener {

    lateinit var adapter: MainViewPagerAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupViewPager()
        setupBottomNavigationView()
    }

    private fun setupViewPager() {
        adapter = MainViewPagerAdapter(this)
        adapter.addFragment(ImageListFragment("IMAGE 1"))
        adapter.addFragment(ImageListFragment("IMAGE 2"))
        adapter.addFragment(ImageListFragment("IMAGE 3"))
        view_pager.adapter = adapter
        view_pager.isUserInputEnabled = false;
    }

    private fun setupBottomNavigationView() {
        bottom_navigation_view.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.image -> view_pager.setCurrentItem(0, false)
                R.id.image1 -> view_pager.setCurrentItem(1, false)
                R.id.image2 -> view_pager.setCurrentItem(2, false)
            }
            true
        }
    }

    override fun onItemClick(item: Contact) {
        val fragment = DetailNameFragment().apply {
            arguments = Bundle().apply { putString("name_item", item.name) }
        }
        supportFragmentManager.beginTransaction().add(R.id.container, fragment)
            .addToBackStack(fragment.tag).commit()
    }

}











