package com.example.teacherkotlinproject.ui.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.bumptech.glide.Glide
import com.example.teacherkotlinproject.R
import com.example.teacherkotlinproject.helper.showToast
import com.example.teacherkotlinproject.model.Images
import com.example.teacherkotlinproject.model.Publication
import com.example.teacherkotlinproject.ui.detail_publication.DetailPublicationFragment
import com.example.teacherkotlinproject.ui.main.MainRepository
import com.example.teacherkotlinproject.ui.profile.adapter.ProfileAdapter
import com.example.teacherkotlinproject.ui.publication.RequestResult
import kotlinx.android.synthetic.main.fragment_profile.*


class ProfileFragment : Fragment(), ProfileAdapter.ClickListener, RequestResult {

    private lateinit var adapter: ProfileAdapter
    private val COUNT_OF_GRID = 3
    private lateinit var repository: MainRepository
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_profile, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        adapter = ProfileAdapter(this)
        rv.layoutManager = GridLayoutManager(requireContext(), COUNT_OF_GRID)
        rv.adapter = adapter
    }

    override fun onResume() {
        super.onResume()
        repository = MainRepository(this)
        repository.fetchProfile()
    }

    override fun onItemClick(item: Images) {
        val fragment = DetailPublicationFragment()
        val bundle = Bundle()
//        bundle.putSerializable("publication", item)
//        fragment.arguments = bundle
//        activity?.supportFragmentManager?.beginTransaction()?.add(R.id.main, fragment)?.addToBackStack(fragment.tag)?.commit()
    }

    override fun onFailure(t: Throwable) {
        showToast(requireContext(), t.message.toString())
    }

    override fun <T>onSuccess(result: T) {
        val user = result as Publication
        setupViews(user)
    }

    private fun setupViews(user: Publication) {
        Glide.with(requireContext()).load(user.icon).into(image_civ)
        name_tv.text = user.name
        description_tv.text = user.phoneNumber
        user.images?.let { adapter.addItems(it) }
    }
}