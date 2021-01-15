package com.example.teacherkotlinproject.ui.image

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.teacherkotlinproject.R
import com.example.teacherkotlinproject.ui.image.adapter.ImageListViewPagerAdapter
import com.example.teacherkotlinproject.ui.image_carousel.ImageCarouselFragment
import kotlinx.android.synthetic.main.fragment_image.*


class ImageListFragment(private val fragmentTitle: String) : Fragment() {

    lateinit var adapter: ImageListViewPagerAdapter
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_image, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        tv.text = fragmentTitle
        setupViewPager()
    }

    private fun setupViewPager() {
        if (fragmentTitle != "IMAGE 1") return
        adapter = ImageListViewPagerAdapter(childFragmentManager)
        adapter.addFragments(ImageCarouselFragment("https://icatcare.org/app/uploads/2018/07/Thinking-of-getting-a-cat.png"))
        adapter.addFragments(ImageCarouselFragment("https://img.webmd.com/dtmcms/live/webmd/consumer_assets/site_images/article_thumbnails/other/cat_relaxing_on_patio_other/1800x1200_cat_relaxing_on_patio_other.jpg"))
        adapter.addFragments(ImageCarouselFragment("https://www.study.ru/uploads/server/YNUzTtg0hUDiTWiP.jpg"))
        view_pager.adapter = adapter
    }
}