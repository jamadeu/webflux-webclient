package br.com.jamadeu.webclient.adapter.output.http.exception

class ClientInternalException(override val message: String, e: Throwable? = null) : RuntimeException(message, e)