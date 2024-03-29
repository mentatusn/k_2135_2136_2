package com.gb.k_2135_2136_2.model.dto


import android.os.Parcelable
import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Keep
@Parcelize
data class Fact(
    @SerializedName("feels_like")
    val feelsLike: Int,
    @SerializedName("temp")
    val temp: Int,
    val icon: String= "bkn_n"
) : Parcelable