package br.com.jamadeu.webclient.adapter.output.http.model


data class AddressByCepV2Response(
    val cep: String?,
    val state: String?,
    val city: String?,
    val neighborhood: String?,
    val street: String?,
    val service: String?,
    val location: Location
)

data class Location(
    val type: String?,
    val coordinates: Coordinates
)

data class Coordinates(
    val longitude: String?,
    val latitude: String?
)
