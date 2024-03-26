package br.com.thiagoodev.investapp.android.modules.auth.domain.repositories.remote

import br.com.thiagoodev.investapp.android.modules.auth.domain.dto.AuthDTO
import br.com.thiagoodev.investapp.android.modules.auth.domain.models.Token

interface AuthRemoteRepository {
    suspend fun auth(authDTO: AuthDTO): Token
}