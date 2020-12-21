package com.example.teacherkotlinproject.ui.profile

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import com.example.teacherkotlinproject.R
import com.example.teacherkotlinproject.helper.SharedPreferences
import com.example.teacherkotlinproject.helper.checkPermissions
import com.example.teacherkotlinproject.helper.showSnackbar
import com.example.teacherkotlinproject.ui.main.MainActivity
import kotlinx.android.synthetic.main.fragment_profile.*

class ProfileFragment : Fragment() {

    lateinit var pref: SharedPreferences

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_profile, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        pref = SharedPreferences(requireContext())
        setupViews()
        editAction()
        phoneAction()
    }

    private fun setupViews() {
        Glide.with(image.context)
            .load(pref.image)
            .into(image)
        name.setText(pref.name)
        surname.setText(pref.surname)
        phone_number.setText(pref.phoneNumber)
    }

    private fun editAction() {
        edit.setOnClickListener {
            if (!name.isEnabled) changeState(true, resources.getString(R.string.save))
            else changeState(false, resources.getString(R.string.edit))
        }
    }

    private fun changeState(state: Boolean, editTitle: String) {
        name.isEnabled = state
        surname.isEnabled = state
        phone_number.isEnabled = state
        edit.text = editTitle

        if (!state) updatePrefs()
    }

    private fun phoneNumber() = phone_number.text.toString()

    private fun updatePrefs() {
        pref.name = name.text.toString()
        pref.surname = surname.text.toString()
        pref.phoneNumber = phoneNumber()
    }

    private fun phoneAction() {
        call.setOnClickListener {
            if (phoneNumber().isEmpty()) showSnackbar(phone_number, "Номер отсутствует")
            else checkPermissions(requireActivity(), Manifest.permission.CALL_PHONE) { openPhone(phoneNumber()) }
        }
    }

    private fun openPhone(number: String) {
        val intent = Intent(Intent.ACTION_CALL)
        intent.data = Uri.parse("tel:$number")
        startActivity(intent)
    }

}