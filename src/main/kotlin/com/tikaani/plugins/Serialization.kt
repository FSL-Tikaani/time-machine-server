package com.tikaani.plugins

import com.tikaani.data.*
import io.ktor.http.*
import io.ktor.serialization.kotlinx.json.*
import io.ktor.server.application.*
import io.ktor.server.plugins.contentnegotiation.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Application.configureSerialization() {
    install(ContentNegotiation) {
        json()
    }
    routing {
        get("/json/kotlinx-serialization") {
            call.respond(mapOf("hello" to "world"))
        }
        // MiniCards
        get("/json/createItemMiniCard/") {
            //createMiniCard()
            call.respond(HttpStatusCode.NotFound)
        }

        get("/json/getAllItemsMiniCards/") {
            call.respond(getAllMiniCardsMongo())
        }

        // Cities
        get("/json/createItemCity/") {
            //createCity()
            call.respond(HttpStatusCode.NotFound)
        }

        get("/json/getCity/{cityId}/") {
            val cityId = call.parameters["cityId"]
            call.respond(getCity(cityId!!))
        }

        // History
        get("/json/createHistory/") {
            //createHistory()
            call.respond(HttpStatusCode.NotFound)
        }

        get("/json/getItemsHistory/{cityId}/") {
            val cityId = call.parameters["cityId"]
            call.respond(getAllHistory(cityId!!))
        }
    }
}
