package br.com.jamadeu.webclient.application.cep.v2.service

import br.com.jamadeu.webclient.adapter.output.http.HttpClient
import br.com.jamadeu.webclient.application.cep.v2.service.mapper.toAddress
import br.com.jamadeu.webclient.application.cep.v2.service.model.Address
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import reactor.core.publisher.Mono

@Service
class Service(
    private val httpClient: HttpClient
) {

    private val logger = LoggerFactory.getLogger(javaClass)

    fun getAddressByCepV2(cep: String): Mono<Address> {
        logger.info("Call httpClient cep - $cep")
        return httpClient
            .getAddressByCepV2(cep)
            .map { it.toAddress() }
    }

}