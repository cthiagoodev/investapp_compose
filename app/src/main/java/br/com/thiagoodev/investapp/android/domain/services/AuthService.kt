package br.com.thiagoodev.investapp.android.domain.services

import br.com.thiagoodev.investapp.android.domain.dtos.AuthDTO
import br.com.thiagoodev.investapp.android.domain.models.User
import br.com.thiagoodev.investapp.android.domain.repositories.remote.IAuthRemoteRepository

class AuthService(private val remoteRepository: IAuthRemoteRepository) {
    suspend fun login(authDTO: AuthDTO): User {
        return remoteRepository.auth(authDTO)
    }
}