package br.com.thiagoodev.investapp.core.extensions


fun Exception.formattedError(): String {
    return "${message}\n${stackTraceToString()}\n${cause?.toString()}"
}