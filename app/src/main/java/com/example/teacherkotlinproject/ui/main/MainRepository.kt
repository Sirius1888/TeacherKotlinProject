package com.example.teacherkotlinproject.ui.main

import com.example.teacherkotlinproject.App.Companion.getDatabase
import com.example.teacherkotlinproject.data.model.Publication
import com.example.teacherkotlinproject.data.network.RetrofitClient
import com.example.teacherkotlinproject.ui.publication.RequestResult
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainRepository(private val callback: RequestResult) {

    private var api = RetrofitClient().simpleApi

    fun fetchPublications() {
        callback.onSuccess(getDatabase().instagramDao().getPublications())
        api.fetchPublications().enqueue(object: Callback<MutableList<Publication>> {
            override fun onFailure(call: Call<MutableList<Publication>>, t: Throwable) {
                return callback.onFailure(t)
            }

            override fun onResponse(
                call: Call<MutableList<Publication>>,
                response: Response<MutableList<Publication>>
            ) {
                return if (response.body() != null) {
                    val data = response.body()
                    getDatabase().instagramDao().insertPublications(data)
                    callback.onSuccess(data)

                } else {
                    callback.onFailure(Throwable("error"))
                }
            }
        })
    }

    fun fetchProfile() {
        api.fetchProfile().enqueue(object: Callback<Publication> {
            override fun onFailure(call: Call<Publication>, t: Throwable) {
                return callback.onFailure(t)
            }

            override fun onResponse(call: Call<Publication>, response: Response<Publication>) {
                return if (response.body() != null) callback.onSuccess(response.body())
                else callback.onFailure(Throwable("error"))
            }
        })
    }
    //CRUD - CREATE, READ, UPDATE, DELETE
    //POST GET PUT DELETE

    //Процесс, поток
    //Ассинхронный, синхронный
    //coroutine - LiveData/Flow, rxJava - Single/Observer

    //Способы передачи данных между сервером и клиентом
    //json, XML, YAML
}