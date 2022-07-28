package br.com.jamadeu.webclient.adapter.input.controller.model

import br.com.jamadeu.webclient.application.cep.v2.service.model.Address

data class GetAddressByCepV2Response(
    val cep: String,
    val state: String,
    val city: String,
    val neighborhood: String,
    val street: String,
    val service: String,
    val location: Location
) {
    constructor(address: Address) : this(
        cep = address.cep,
        state = address.state,
        city = address.city,
        neighborhood = address.neighborhood,
        street = address.street,
        service = address.service,
        location = Location(
            type = address.location.type,
            coordinates = Coordinates(
                longitude = address.location.coordinates.longitude,
                latitude = address.location.coordinates.latitude
            )
        )

    )
}

data class Location(
    val type: String,
    val coordinates: Coordinates
)

data class Coordinates(
    val longitude: String,
    val latitude: String
)
