package com.example.teacherkotlinproject.views

import android.content.Context
import android.util.AttributeSet
import android.view.MotionEvent
import androidx.viewpager.widget.ViewPager


//class UnscrollViewPager: ViewPager {
//
//    private var isDisable = false
//    constructor(context: Context) : super(context)
//    constructor(context: Context, attrs: AttributeSet) : super(context, attrs)
//
//    override fun onInterceptHoverEvent(event: MotionEvent): Boolean {
//        return when (isDisable) {
//            true -> super.onInterceptHoverEvent(event)
//            else -> false
//        }
//    }
//
//    override fun onTouchEvent(event: MotionEvent): Boolean {
//        return when (isDisable) {
//            true -> super.onTouchEvent(event)
//            else -> false
//        }
//    }
//
//    fun setPagingEnabled(disable: Boolean) {
//        isDisable = disable
//    }
//}