package com.gb.k_2135_2136_2.model.dto


import android.os.Parcelable
import androidx.annotation.Keep
import kotlinx.android.parcel.Parcelize

@Keep
@Parcelize
data class WeatherDTO(
    val fact: Fact
): Parcelable