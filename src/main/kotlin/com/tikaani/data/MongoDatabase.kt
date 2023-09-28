package com.tikaani.data

import com.mongodb.BasicDBObject
import org.litote.kmongo.coroutine.coroutine
import org.litote.kmongo.reactivestreams.KMongo


val client = KMongo.createClient().coroutine

val database = client.getDatabase("main_database")

val collectionMiniCards = database.getCollection<MiniCardModel>()

val collectionCities = database.getCollection<CityModel>()

val collectionHistory = database.getCollection<HistoryData>()

suspend fun getAllMiniCardsMongo(): List<MiniCardModel> {
    val data = collectionMiniCards.find().toList()
    return data
}

suspend fun getAllCities(): List<CityModel> {
    val data = collectionCities.find().toList()
    return data
}

suspend fun getCity(cityId: String): CityModel {
    val filter = BasicDBObject("id", cityId)

    return collectionCities.findOne(filter)!!
}


suspend fun getAllHistory(cityId: String): List<HistoryOfCenturyModel> {
    val filter = BasicDBObject("idCity", cityId)
    val data = collectionHistory.findOne(filter)
    return data!!.arrCentury
}