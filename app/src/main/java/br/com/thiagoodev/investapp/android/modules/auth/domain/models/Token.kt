package br.com.thiagoodev.investapp.android.modules.auth.domain.models

data class Token(
    val access: String,
    val refresh: String,
)