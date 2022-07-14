package com.gb.k_2135_2136_2.model.dto


import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class WeatherDTO(
    val fact: Fact
): Parcelable