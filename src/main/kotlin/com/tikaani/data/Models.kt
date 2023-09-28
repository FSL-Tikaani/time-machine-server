package com.tikaani.data

import kotlinx.serialization.Serializable


@Serializable
data class MiniCardModel(
    val id: String = "",
    val nameCity: String = "",
    val srcImg: String = "",
)

@Serializable
data class CityModel (
    val id: String,
    val cityName: String,
    val arrPhotosCity: ArrayList<String>,
    val cityDescription: String,
    val foundationDate: String,
    val population: String,
    val arrSrc: ArrayList<String>
)

@Serializable
data class HistoryOfCenturyModel(
    val title: String = "Title",
    val arrSrcImg: ArrayList<String> = arrayListOf<String>("https://oddly-generous-monarch.ngrok-free.app/static/arzamas.jpg"),
    val textDescription: String = "Description",
)

@Serializable
data class HistoryData(
    val idCity: String = "",
    val arrCentury: List<HistoryOfCenturyModel> = arrayListOf()
)

