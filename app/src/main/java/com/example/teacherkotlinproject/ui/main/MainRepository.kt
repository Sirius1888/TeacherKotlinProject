package com.example.teacherkotlinproject.ui.main

import android.content.Context
import com.example.teacherkotlinproject.helper.showToast
import com.example.teacherkotlinproject.model.Meet
import com.example.teacherkotlinproject.model.Publication
import com.example.teacherkotlinproject.network.RetrofitClient
import com.example.teacherkotlinproject.ui.publication.RequestResult
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainRepository(private val callback: RequestResult) {

    private var api = RetrofitClient().simpleApi

    fun fetchPublications() {
        api.fetchPublications().enqueue(object: Callback<MutableList<Publication>> {
            override fun onFailure(call: Call<MutableList<Publication>>, t: Throwable) {
                return callback.onFailure(t)
            }

            override fun onResponse(
                call: Call<MutableList<Publication>>,
                response: Response<MutableList<Publication>>
            ) {
                return if (response.body() != null) callback.onSuccess(response.body()!!)
                else callback.onFailure(Throwable("error"))
            }
        })
    }

}