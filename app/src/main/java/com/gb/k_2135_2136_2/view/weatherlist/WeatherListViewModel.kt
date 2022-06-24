package com.gb.k_2135_2136_2.view.weatherlist

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.gb.k_2135_2136_2.viewmodel.AppState
import java.lang.Thread.sleep

class WeatherListViewModel(val liveData: MutableLiveData<AppState> = MutableLiveData<AppState>()) :
    ViewModel() {

    fun sentRequest() {
        liveData.value = AppState.Loading
        Thread{
            sleep(2000L)
            liveData.postValue(AppState.Success(Any()))
        }.start()
    }
}