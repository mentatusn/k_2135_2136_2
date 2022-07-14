package com.gb.k_2135_2136_2.viewmodel.details

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.gb.k_2135_2136_2.MyApp
import com.gb.k_2135_2136_2.model.*
import com.gb.k_2135_2136_2.model.dto.WeatherDTO
import com.gb.k_2135_2136_2.model.retrofit.RepositoryDetailsRetrofitImpl
import com.gb.k_2135_2136_2.utils.SP_DB_NAME_IS_RUSSIAN
import java.io.IOException

class DetailsViewModel(private val liveData: MutableLiveData<DetailsFragmentAppState> = MutableLiveData<DetailsFragmentAppState>()) :
    ViewModel() {

    lateinit var repository: RepositoryDetails

    fun getLiveData(): MutableLiveData<DetailsFragmentAppState> {
        choiceRepository()
        return liveData
    }

    private fun choiceRepository() {
        val sp = MyApp.getMyApp().getSharedPreferences("erhrth", Context.MODE_PRIVATE)
        repository = when (sp.getInt("rturtu",2)) {
            1 -> {
                RepositoryDetailsOkHttpImpl()
            }
            2 -> {
                RepositoryDetailsRetrofitImpl()
            }
            3 -> {
                RepositoryDetailsWeatherLoaderImpl()
            }
            else -> {
                RepositoryDetailsLocalImpl()
            }
        }
    }


    fun getWeather(lat: Double, lon: Double) {



        choiceRepository()
        liveData.value = DetailsFragmentAppState.Loading
        repository.getWeather(lat, lon,callback)
    }

    private val callback = object :MyLargeSuperCallback{
        override fun onResponse(weatherDTO: WeatherDTO) {
            /*Handler(Looper.getMainLooper()).post {

            }*/
            liveData.postValue(DetailsFragmentAppState.Success(weatherDTO))
        }

        override fun onFailure(e: IOException) {
            liveData.postValue(DetailsFragmentAppState.Error(e))
        }
    }

    private fun isConnection(): Boolean {
        return false
    }

    override fun onCleared() { // TODO HW ***
        super.onCleared()
    }
}