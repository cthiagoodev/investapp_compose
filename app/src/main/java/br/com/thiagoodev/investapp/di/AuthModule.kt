package br.com.thiagoodev.investapp.di

import br.com.thiagoodev.investapp.data.datasources.remote.AuthRemoteDataSource
import br.com.thiagoodev.investapp.data.repositories.remote.AuthRemoteRepositoryImp
import br.com.thiagoodev.investapp.domain.repositories.remote.AuthRemoteRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
class AuthModule {
    @Provides
    fun provideAuthRemoteRepository(source: AuthRemoteDataSource): AuthRemoteRepository {
        return AuthRemoteRepositoryImp(source)
    }
}