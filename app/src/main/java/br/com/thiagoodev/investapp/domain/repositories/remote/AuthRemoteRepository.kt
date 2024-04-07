package br.com.thiagoodev.investapp.domain.repositories.remote

import br.com.thiagoodev.investapp.domain.models.User

interface AuthRemoteRepository {
    suspend fun auth(email: String, password: String): User
}