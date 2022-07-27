package br.com.jamadeu.webclient.adapter.output.http.exception

class ClientNotFoundException(override val message: String, e: Throwable? = null) : RuntimeException(message, e)