package br.com.jamadeu.webclient.configuration.properties

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.ConstructorBinding

@ConstructorBinding
@ConfigurationProperties(prefix = "api")
data class HttpClientConfigProperties(
    val baseUrl: String,
    val cepV2: String
)
