package com.gb.k_2135_2136_2.viewmodel.citieslist

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.gb.k_2135_2136_2.model.*
import kotlin.random.Random

class CitiesListViewModel(private val liveData: MutableLiveData<CityListFragmentAppState> = MutableLiveData<CityListFragmentAppState>()) :
    ViewModel() {

    lateinit var repositoryCitiesList: RepositoryCitiesList
    //lateinit var repositoryOne: RepositoryOne

    fun getLiveData(): MutableLiveData<CityListFragmentAppState> {
        choiceRepository()
        return liveData
    }

    private fun choiceRepository() {
        repositoryCitiesList = RepositoryCitiesListImpl()
    }

    fun getWeatherListForRussia() {
        sentRequest(Location.Russian)
    }

    fun getWeatherListForWorld() {
        sentRequest(Location.World)
    }

    private fun sentRequest(location: Location) {
        //choiceRepository()
        liveData.value = CityListFragmentAppState.Loading
        Thread {
            Thread.sleep(30L)
            if ((0..3).random(Random(System.currentTimeMillis())) == 10) {
                liveData.postValue(CityListFragmentAppState.Error(IllegalStateException("что-то пошлло не так")))
            } else {
                liveData.postValue(CityListFragmentAppState.SuccessMulti(repositoryCitiesList.getListCities(location)))
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