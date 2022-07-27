package br.com.jamadeu.webclient

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan

@ComponentScan("br.com.jamadeu.webclient")
@ConfigurationProperties
@SpringBootApplication
class WebclientApplication

fun main(args: Array<String>) {
	runApplication<WebclientApplication>(*args)
}
