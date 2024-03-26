package br.com.thiagoodev.investapp.android.modules.auth.domain.repositories.remote

import br.com.thiagoodev.investapp.android.modules.auth.domain.dto.AuthDTO
import br.com.thiagoodev.investapp.android.modules.user.domain.models.User

interface IAuthRemoteRepository {
    suspend fun auth(authDTO: AuthDTO): User
}