package br.com.thiagoodev.investapp.domain.models

data class User(
    val uuid: String,
    val name: String,
    val email: String,
    val profileImage: String,
)
