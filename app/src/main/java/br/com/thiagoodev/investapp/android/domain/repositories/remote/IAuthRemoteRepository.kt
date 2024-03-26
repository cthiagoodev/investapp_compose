package br.com.thiagoodev.investapp.android.domain.repositories.remote

import br.com.thiagoodev.investapp.android.domain.dtos.AuthDTO
import br.com.thiagoodev.investapp.android.domain.models.User

interface IAuthRemoteRepository {
    suspend fun auth(authDTO: AuthDTO): User
}