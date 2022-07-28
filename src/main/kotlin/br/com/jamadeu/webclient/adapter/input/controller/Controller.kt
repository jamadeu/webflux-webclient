package br.com.jamadeu.webclient.adapter.input.controller

import br.com.jamadeu.webclient.adapter.input.controller.model.GetAddressByCepV2Response
import br.com.jamadeu.webclient.application.cep.v2.service.Service
import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Mono


@RestController
@RequestMapping("/v1/api")
class Controller(
    private val service: Service
) {
    //TODO erro quando o cep nao encontrado
    private val logger = LoggerFactory.getLogger(javaClass)

    @GetMapping("/cep-v2/{cep}")
    fun getAddressByCepV2(@PathVariable("cep") cep: String): Mono<GetAddressByCepV2Response> {
        logger.info("Controller - getAddressByCepV2, cep - $cep")
        return service
            .getAddressByCepV2(cep)
            .map { GetAddressByCepV2Response(it) }
    }

}