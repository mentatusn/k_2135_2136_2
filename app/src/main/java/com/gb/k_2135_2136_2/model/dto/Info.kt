package com.gb.k_2135_2136_2.model.dto


import com.google.gson.annotations.SerializedName

data class Info(
    @SerializedName("lat")
    val lat: Double,
    @SerializedName("lon")
    val lon: Double,
    @SerializedName("url")
    val url: String
)