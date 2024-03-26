package br.com.thiagoodev.investapp

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform