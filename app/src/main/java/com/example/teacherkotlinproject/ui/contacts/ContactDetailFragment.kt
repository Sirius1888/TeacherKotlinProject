package com.example.teacherkotlinproject.ui.contacts

import android.os.Bundle
import android.provider.ContactsContract
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.teacherkotlinproject.R
import com.example.teacherkotlinproject.helper.showToast
import com.example.teacherkotlinproject.models.Contact
import kotlinx.android.synthetic.main.fragment_contact_detail.*


class ContactDetailFragment : Fragment() {

    //для получения/передачи данных в activity мы использовали intent
    //для получения/передачи данных в fragment мы использовали bundle

    lateinit var contact: Contact

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_contact_detail, container, false)
    }

    override fun onStart() {
        super.onStart()
        contact = arguments?.getSerializable("item") as Contact
        showToast(requireContext(), contact.toString())
        setupViews()
    }

    private fun setupViews() {
        Glide.with(image)
            .load(contact.image)
            .placeholder(R.drawable.ic_people)
            .into(image)

        name.text = contact.firstName
        lastname.text = contact.lastName
        email.text = contact.email
    }


}