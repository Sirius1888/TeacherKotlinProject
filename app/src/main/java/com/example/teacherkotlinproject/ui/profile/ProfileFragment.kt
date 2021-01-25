package com.example.teacherkotlinproject.ui.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.GridLayout
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.bumptech.glide.Glide
import com.example.teacherkotlinproject.R
import com.example.teacherkotlinproject.model.Publication
import com.example.teacherkotlinproject.model.publicationsArray
import com.example.teacherkotlinproject.ui.detail_publication.DetailPublicationFragment
import com.example.teacherkotlinproject.ui.profile.adapter.ProfileAdapter
import kotlinx.android.synthetic.main.fragment_profile.*


class ProfileFragment : Fragment(), ProfileAdapter.ClickListener {

    private lateinit var adapter: ProfileAdapter
    private val COUNT_OF_GRID = 3
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_profile, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
        setupViews()
    }

    private fun setupRecyclerView() {
        adapter = ProfileAdapter(this)
        rv.layoutManager = GridLayoutManager(requireContext(), COUNT_OF_GRID)
        rv.adapter = adapter
        adapter.addItems(userPublications())
    }

    private fun setupViews() {
        val user = userPublications().last()
        Glide.with(requireContext()).load(user.icon).into(image_civ)
        name_tv.text = user.name
        description_tv.text = user.phoneNumber
    }

    private fun userPublications(): MutableList<Publication> = publicationsArray.filter { it.id == 7 } as MutableList<Publication>

    // из активити supportFragmentManager
    // из фрагмента childFragmentManager

    override fun onItemClick(item: Publication) {
        val fragment = DetailPublicationFragment()
        val bundle = Bundle()
        bundle.putSerializable("publication", item)
        fragment.arguments = bundle
        activity?.supportFragmentManager?.beginTransaction()?.add(R.id.main, fragment)?.addToBackStack(fragment.tag)?.commit()
    }

}