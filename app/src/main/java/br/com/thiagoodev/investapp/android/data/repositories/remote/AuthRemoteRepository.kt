package br.com.thiagoodev.investapp.android.data.repositories.remote

import br.com.thiagoodev.investapp.android.data.datasources.remote.AuthRemoteDataSource
import br.com.thiagoodev.investapp.android.domain.dtos.AuthDTO
import br.com.thiagoodev.investapp.android.domain.repositories.remote.IAuthRemoteRepository
import br.com.thiagoodev.investapp.android.domain.models.User
import com.google.firebase.auth.AuthResult

class AuthRemoteRepository(private val source: AuthRemoteDataSource) : IAuthRemoteRepository {
    override suspend fun auth(authDTO: AuthDTO): User {
        val result: AuthResult = source.login(authDTO.email, authDTO.password)
        return User(
            id = result.user?.uid ?: "",
            name = result.user?.displayName ?: "",
            profileImage = (result.user?.photoUrl ?: "").toString(),
            email = result.user?.email ?: "",
        )
    }
}