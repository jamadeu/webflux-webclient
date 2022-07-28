package br.com.jamadeu.webclient.application.cep.v2.service.mapper

import br.com.jamadeu.webclient.adapter.output.http.model.AddressByCepV2Response
import br.com.jamadeu.webclient.application.cep.v2.service.model.Address
import br.com.jamadeu.webclient.application.cep.v2.service.model.Coordinates
import br.com.jamadeu.webclient.application.cep.v2.service.model.Location

const val MESSAGE = "Error mapping address"

fun AddressByCepV2Response.toAddress(): Address =
    Address(
        cep = cep ?: throw RuntimeException(MESSAGE),
        state = state ?: throw RuntimeException(MESSAGE),
        city = city ?: throw RuntimeException(MESSAGE),
        neighborhood = neighborhood ?: throw RuntimeException(MESSAGE),
        street = street ?: throw RuntimeException(MESSAGE),
        service = service ?: throw RuntimeException(MESSAGE),
        location = Location(
            type = location.type ?: throw RuntimeException(MESSAGE),
            coordinates = Coordinates(
                longitude = location.coordinates.longitude ?: throw RuntimeException(MESSAGE),
                latitude = location.coordinates.latitude ?: throw RuntimeException(MESSAGE)
            )
        )
    )
