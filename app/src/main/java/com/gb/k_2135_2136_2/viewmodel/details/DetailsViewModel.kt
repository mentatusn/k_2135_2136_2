package com.gb.k_2135_2136_2.viewmodel.details

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.gb.k_2135_2136_2.MyApp
import com.gb.k_2135_2136_2.domain.City
import com.gb.k_2135_2136_2.domain.Weather
import com.gb.k_2135_2136_2.model.*
import com.gb.k_2135_2136_2.model.retrofit.RepositoryLocationToOneWeatherRetrofitImpl
import java.io.IOException

class DetailsViewModel(private val liveData: MutableLiveData<DetailsFragmentAppState> = MutableLiveData<DetailsFragmentAppState>()) :
    ViewModel() {

    lateinit var repositoryLocationToOneWeather: RepositoryWeatherByCity
    lateinit var repositoryWeatherAddable: RepositoryWeatherSave

    fun getLiveData(): MutableLiveData<DetailsFragmentAppState> {
        choiceRepository()
        return liveData
    }

    private fun choiceRepository() {
        val sp = MyApp.getMyApp().getSharedPreferences("erhrth", Context.MODE_PRIVATE)
        if (isConnection()) {
            repositoryLocationToOneWeather = when (2) {
                1 -> {
                    RepositoryOkHttpImpl()
                }
                2 -> {
                    RepositoryLocationToOneWeatherRetrofitImpl()
                }
                3 -> {
                    RepositoryWeatherLoaderImpl()
                }
                4 -> {
                    RepositoryRoomImpl()
                }
                else -> {
                    RepositoryLocalImpl()
                }
            }

            repositoryWeatherAddable = when (0) {
                1 -> {
                    RepositoryRoomImpl()
                }
                else -> {
                    RepositoryRoomImpl()
                }
            }
        } else {
            repositoryLocationToOneWeather = when (1) {
                1 -> {
                    RepositoryRoomImpl()
                }
                2 -> {
                    RepositoryLocalImpl()
                }
                else -> {
                    RepositoryLocalImpl()
                }
            }
            repositoryWeatherAddable = when (0) {
                1 -> {
                    RepositoryRoomImpl()
                }
                else -> {
                    RepositoryRoomImpl()
                }
            }
        }


    }


    fun getWeather(city: City) {
        liveData.value = DetailsFragmentAppState.Loading
        repositoryLocationToOneWeather.getWeather(city, callback)
    }

    private val callback = object : CommonWeatherCallback {
        override fun onResponse(weather: Weather) {
            /*Handler(Looper.getMainLooper()).post {

            }*/
            if (isConnection())
                repositoryWeatherAddable.addWeather(weather)
            liveData.postValue(DetailsFragmentAppState.Success(weather))
        }

        override fun onFailure(e: IOException) {
            liveData.postValue(DetailsFragmentAppState.Error(e))
        }
    }



    private fun isConnection(): Boolean {// TODO HW реализация
        return false
    }

    override fun onCleared() {
        super.onCleared()
    }
}