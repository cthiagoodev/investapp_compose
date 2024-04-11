package br.com.thiagoodev.investapp.data.repositories.remote

import br.com.thiagoodev.investapp.data.datasources.remote.AuthRemoteDataSource
import br.com.thiagoodev.investapp.domain.models.User
import br.com.thiagoodev.investapp.domain.repositories.remote.AuthRemoteRepository
import com.google.firebase.auth.AuthResult
import javax.inject.Inject

class AuthRemoteRepositoryImp
    @Inject constructor(private val source: AuthRemoteDataSource) : AuthRemoteRepository {
    override suspend fun auth(email: String, password: String): User {
        val result: AuthResult = source.auth(email, password)
        return User.fromFirebase()
    }
}