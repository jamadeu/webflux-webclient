package br.com.jamadeu.webclient.adapter.output.http.exception

import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import reactor.core.publisher.Mono

@Service
class ClientExceptionUtils {

    private val logger = LoggerFactory.getLogger(javaClass)

    fun exception(
        statusCode: HttpStatus,
        origin: String,
        message: String? = null
    ): Mono<Throwable> {
        logger.error("statusCode={}, reasonPhrase={}", statusCode.value(), statusCode.reasonPhrase)
        return Mono.error(choose(statusCode, origin, message))
    }

    fun choose(statusCode: HttpStatus, origin: String, message: String? = null): Throwable {
        return when (statusCode.value()) {
            HttpStatus.NOT_FOUND.value() -> ClientNotFoundException(
                "$origin - NotFoundException"
            )

            else -> ClientInternalException("$origin - ClientInternalException")
        }
    }
}