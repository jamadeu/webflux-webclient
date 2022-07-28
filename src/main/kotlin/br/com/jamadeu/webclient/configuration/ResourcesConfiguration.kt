package br.com.jamadeu.webclient.configuration

import org.springframework.boot.autoconfigure.web.WebProperties.Resources
import org.springframework.context.annotation.Bean
import org.springframework.stereotype.Component

@Component
class ResourcesConfiguration {

    @Bean
    fun resources(): Resources = Resources()
}