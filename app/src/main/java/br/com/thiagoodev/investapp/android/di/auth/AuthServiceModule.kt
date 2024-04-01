package br.com.thiagoodev.investapp.android.di.auth

import br.com.thiagoodev.investapp.android.data.datasources.remote.AuthRemoteDataSource
import br.com.thiagoodev.investapp.android.data.repositories.remote.AuthRemoteRepository
import com.google.firebase.auth.FirebaseAuth
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelScoped::class)
class AuthServiceModule {
    @Provides
    fun provideIAuthRemoteRepository(auth: FirebaseAuth): AuthRemoteRepository {
        return AuthRemoteRepository(AuthRemoteDataSource(auth))
    }
}