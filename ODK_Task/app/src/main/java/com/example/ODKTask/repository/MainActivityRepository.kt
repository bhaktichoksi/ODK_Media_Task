package com.example.ODKTask.repository

import android.util.Log
import android.view.View
import android.widget.ProgressBar
import androidx.lifecycle.MutableLiveData
import com.example.ODKTask.model.MarvelMovie
import com.example.ODKTask.retrofit.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

object MainActivityRepository {

    private val serviceSetterGetter = MutableLiveData<MarvelMovie>()
    private val detailChater = MutableLiveData<MarvelMovie>()

    fun getServicesApiCall(progress: ProgressBar): MutableLiveData<MarvelMovie> {

        progress.visibility = View.VISIBLE

        val call = RetrofitClient.apiInterface.getServices()

        call.enqueue(object: Callback<MarvelMovie> {
            override fun onFailure(call: Call<MarvelMovie>, t: Throwable) {
                // TODO("Not yet implemented")
                Log.v("DEBUG : ", t.message.toString())
            }

            override fun onResponse(
                call: Call<MarvelMovie>,
                response: Response<MarvelMovie>
            ) {
                progress.visibility = View.GONE
                // TODO("Not yet implemented")
                Log.v("DEBUG : ", response.body().toString())

                val data = response.body()

                   serviceSetterGetter.value = response.body()
//                val msg = data!!.message
//
//                serviceSetterGetter.value = ServicesSetterGetter(msg)
            }
        })

        return serviceSetterGetter
    }

    fun getDetailChater(postId:String): MutableLiveData<MarvelMovie> {

        val call = RetrofitClient.apiInterface.getDetail(postId)

        call.enqueue(object: Callback<MarvelMovie> {
            override fun onFailure(call: Call<MarvelMovie>, t: Throwable) {
                // TODO("Not yet implemented")
                Log.v("DEBUG : ", t.message.toString())
            }

            override fun onResponse(
                call: Call<MarvelMovie>,
                response: Response<MarvelMovie>
            ) {
                // TODO("Not yet implemented")
                Log.v("DEBUG : ", response.body().toString())

                val data = response.body()

                detailChater.value = response.body()
//                val msg = data!!.message
//
//                serviceSetterGetter.value = ServicesSetterGetter(msg)
            }
        })

        return detailChater
    }



}