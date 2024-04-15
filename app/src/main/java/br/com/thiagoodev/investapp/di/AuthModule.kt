package br.com.thiagoodev.investapp.di

import br.com.thiagoodev.investapp.data.repositories.remote.AuthRemoteRepositoryImp
import br.com.thiagoodev.investapp.domain.repositories.remote.AuthRemoteRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class AuthModule {
    @Binds
    abstract fun provideAuthRemoteRepository(imp: AuthRemoteRepositoryImp): AuthRemoteRepository
}