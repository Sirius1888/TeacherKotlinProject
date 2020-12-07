package com.example.teacherkotlinproject.ui.contacts

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.teacherkotlinproject.R
import com.example.teacherkotlinproject.models.Contact
import com.example.teacherkotlinproject.ui.profile.ProfileFragment
import kotlinx.android.synthetic.main.activity_main.*


//A - activitty, F - Fragment
//A (a) -> A (b), A (a) <- A (b)
//A -> F
//F -> A
//F -> F // Bundle +

class MainActivity : AppCompatActivity() {

    /*
    Добавить 4 editText для EditProfileActivity()
    со всех editText нужно получать значения и добавлять их в класс Actors
     */

    var contactFragment = ContactFragment()
    var profileFragment = ProfileFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        addFragments()
        bottom_navigation.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.contact -> navigateFragment(contactFragment)
                R.id.profile -> navigateFragment(profileFragment)
                else -> false
            }
        }

    }

    private fun navigateFragment(fragment: Fragment): Boolean {
        supportFragmentManager.beginTransaction().replace(R.id.container_fragment, fragment).commit()
        return true
    }

    private fun addFragments() {
        supportFragmentManager.beginTransaction().add(R.id.container_fragment, profileFragment).commit()
        supportFragmentManager.beginTransaction().add(R.id.container_fragment, contactFragment).commit()
        supportFragmentManager.beginTransaction().replace(R.id.container_fragment, contactFragment).commit()
    }

}