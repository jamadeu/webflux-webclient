package br.com.jamadeu.webclient.adapter.output.http

import br.com.jamadeu.webclient.adapter.output.http.model.AddressByCepV2ErrorResponse
import br.com.jamadeu.webclient.adapter.output.http.model.AddressByCepV2Response
import br.com.jamadeu.webclient.configuration.HttpClientConfiguration
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Value
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.stereotype.Service
import org.springframework.web.reactive.function.client.awaitExchange
import org.springframework.web.reactive.function.client.bodyToMono
import org.springframework.web.server.ResponseStatusException
import reactor.core.publisher.Mono
import reactor.core.publisher.SignalType
import java.util.logging.Level

@Service
class HttpClient(
    @Value("\${api.cep-v2}")
    private val uriCepV2: String,
    private val httpClientConfiguration: HttpClientConfiguration
) {

    private val logger = LoggerFactory.getLogger(javaClass)

//    fun getAddressByCepV2(cep: String): Mono<AddressByCepV2Response> {
//        logger.info("Starting searching address, cep - $cep")
//        return httpClientConfiguration.webClient()
//            .get()
//            .uri(uriCepV2, cep)
//            .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
//            .retrieve()
//            .onStatus(HttpStatus::isError) {
//                Mono.error(ResponseStatusException(it.statusCode(), "Address not found"))
//            }
//            .bodyToMono(AddressByCepV2Response::class.java)
//            .log("HttpClient.getAddressByCepV2", Level.INFO, SignalType.ON_COMPLETE)
//    }

    fun getAddressByCepV2(cep: String): Mono<AddressByCepV2Response> {
        logger.info("Starting searching address, cep - $cep")
        return httpClientConfiguration.webClient()
            .get()
            .uri(uriCepV2, cep)
            .retrieve()
            .onStatus(HttpStatus::isError) { response ->
                response
                    .bodyToMono(AddressByCepV2ErrorResponse::class.java)
                    .flatMap { error ->
                        logger.info("Cep nao localizado $error")
                        Mono.error(ResponseStatusException(response.statusCode(), error.message))
                    }
            }
            .bodyToMono(AddressByCepV2Response::class.java)
            .log("HttpClient.getAddressByCepV2", Level.INFO, SignalType.ON_COMPLETE)
    }

}