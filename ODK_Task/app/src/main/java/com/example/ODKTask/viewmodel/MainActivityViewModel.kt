package com.example.ODKTask.viewmodel

import android.widget.ProgressBar
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.ODKTask.model.MarvelMovie
import com.example.ODKTask.repository.MainActivityRepository

class MainActivityViewModel : ViewModel() {

    var servicesLiveData: MutableLiveData<MarvelMovie>? = null

    fun getUser(progress: ProgressBar): LiveData<MarvelMovie>? {
        servicesLiveData = MainActivityRepository.getServicesApiCall(progress)
        return servicesLiveData
    }

}