package br.com.thiagoodev.investapp.android.di

import br.com.thiagoodev.investapp.android.data.repositories.remote.AuthRemoteRepository
import br.com.thiagoodev.investapp.android.domain.repositories.remote.IAuthRemoteRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@Module
@InstallIn(ActivityComponent::class)
abstract class AuthModule {
    @Binds
    abstract fun bindAuthRemoteRepository(
        authRemoteRepository: AuthRemoteRepository): IAuthRemoteRepository

}