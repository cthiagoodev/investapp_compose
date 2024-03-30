package br.com.thiagoodev.investapp.android.domain.services

import br.com.thiagoodev.investapp.android.domain.dtos.AuthDTO
import br.com.thiagoodev.investapp.android.domain.models.User
import br.com.thiagoodev.investapp.android.domain.repositories.remote.IAuthRemoteRepository
import javax.inject.Inject

class AuthService @Inject constructor(private val remoteRepository: IAuthRemoteRepository) {
    suspend fun auth(authDTO: AuthDTO): User {
        return remoteRepository.auth(authDTO)
    }
}