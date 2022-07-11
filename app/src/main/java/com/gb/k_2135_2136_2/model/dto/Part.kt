package com.gb.k_2135_2136_2.model.dto


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Part(
    @SerializedName("condition")
    val condition: String,
    @SerializedName("daytime")
    val daytime: String,
    @SerializedName("feels_like")
    val feelsLike: Int,
    @SerializedName("humidity")
    val humidity: Int,
    @SerializedName("icon")
    val icon: String,
    @SerializedName("part_name")
    val partName: String,
    @SerializedName("polar")
    val polar: Boolean,
    @SerializedName("prec_mm")
    val precMm: Double,
    @SerializedName("prec_period")
    val precPeriod: Int,
    @SerializedName("prec_prob")
    val precProb: Int,
    @SerializedName("pressure_mm")
    val pressureMm: Int,
    @SerializedName("pressure_pa")
    val pressurePa: Int,
    @SerializedName("temp_avg")
    val tempAvg: Int,
    @SerializedName("temp_max")
    val tempMax: Int,
    @SerializedName("temp_min")
    val tempMin: Int,
    @SerializedName("temp_water")
    val tempWater: Int,
    @SerializedName("wind_dir")
    val windDir: String,
    @SerializedName("wind_gust")
    val windGust: Double,
    @SerializedName("wind_speed")
    val windSpeed: Double
):Parcelable