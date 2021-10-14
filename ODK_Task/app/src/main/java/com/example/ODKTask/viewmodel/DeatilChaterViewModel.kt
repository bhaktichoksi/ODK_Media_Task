package com.example.ODKTask.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.ODKTask.model.MarvelMovie
import com.example.ODKTask.repository.MainActivityRepository

class DeatilChaterViewModel : ViewModel() {

    var servicesLiveData: MutableLiveData<MarvelMovie>? = null

    fun getDetails(postId:String) : LiveData<MarvelMovie>? {
        servicesLiveData = MainActivityRepository.getDetailChater(postId)
        return servicesLiveData
    }

}