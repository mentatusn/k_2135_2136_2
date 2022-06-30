package com.gb.k_2135_2136_2.view.weatherlist

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.gb.k_2135_2136_2.model.*
import com.gb.k_2135_2136_2.viewmodel.AppState
import kotlin.random.Random

class WeatherListViewModel(private val liveData: MutableLiveData<AppState> = MutableLiveData<AppState>()) :
    ViewModel() {

    lateinit var repositoryMulti: RepositoryMany
    lateinit var repositoryOne: RepositoryOne

    fun getLiveData(): MutableLiveData<AppState> {
        choiceRepository()
        return liveData
    }

    private fun choiceRepository() {
        repositoryOne = if (isConnection()) {
            RepositoryRemoteImpl()
        } else {
            RepositoryLocalImpl()
        }
        repositoryMulti = RepositoryLocalImpl()
    }

    fun getWeatherListForRussia() {
        sentRequest(Location.Russian)
    }

    fun getWeatherListForWorld() {
        sentRequest(Location.World)
    }

    private fun sentRequest(location: Location) {
        //choiceRepository()
        liveData.value = AppState.Loading
        Thread {
            Thread.sleep(3000L)
            if ((0..3).random(Random(System.currentTimeMillis())) == 10) {
                liveData.postValue(AppState.Error(IllegalStateException("что-то пошлло не так")))
            } else {
                liveData.postValue(AppState.SuccessMulti(repositoryMulti.getListWeather(location)))
            }
        }.start()
    }

    private fun isConnection(): Boolean {
        return false
    }

    override fun onCleared() { // TODO HW ***
        super.onCleared()
    }
}