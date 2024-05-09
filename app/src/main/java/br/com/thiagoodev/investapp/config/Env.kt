package br.com.thiagoodev.investapp.config

import io.github.cdimascio.dotenv.dotenv

val env = dotenv {
    directory = "/assets"
    filename = "env"
}