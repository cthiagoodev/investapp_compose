package br.com.thiagoodev.investapp.domain.services

import br.com.thiagoodev.investapp.domain.models.User
import br.com.thiagoodev.investapp.domain.repositories.remote.AuthRemoteRepository

class AuthService(private val remoteRepository: AuthRemoteRepository) {
    suspend fun login(email: String, password: String): User {
        return remoteRepository.login(email, password)
    }
}