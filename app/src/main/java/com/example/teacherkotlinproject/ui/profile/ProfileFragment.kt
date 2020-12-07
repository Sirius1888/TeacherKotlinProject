package com.example.teacherkotlinproject.ui.profile

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.teacherkotlinproject.R
import com.example.teacherkotlinproject.models.dicaprio
import kotlinx.android.synthetic.main.fragment_profile.*

class ProfileFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_profile, container, false)
        return view
    }

    override fun onStart() {
        super.onStart()
        setupViews()
        editAction()
    }

    private fun setupViews() {
        Glide.with(this)
            .load(dicaprio.image)
            .into(image)
        name.text = dicaprio.name
        age.text = dicaprio.age
        bio.text = dicaprio.bio
    }

    private fun editAction() {
        edit.setOnClickListener {
            val intent = Intent(activity, EditProfileActivity::class.java)
            startActivity(intent)
        }
    }
}