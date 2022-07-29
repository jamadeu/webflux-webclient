package br.com.jamadeu.webclient.adapter.output.http.model


data class AddressByCepV2ErrorResponse(
    val name: String?,
    val message: String?,
    val type: String?,
    val errors: Array<Error> = emptyArray()
)

data class Error(
    val name: String?,
    val message: String?,
    val service: String?
)
