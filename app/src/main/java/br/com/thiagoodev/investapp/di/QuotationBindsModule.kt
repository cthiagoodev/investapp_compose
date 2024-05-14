package br.com.thiagoodev.investapp.di

import br.com.thiagoodev.investapp.data.repositories.QuotationRepositoryImp
import br.com.thiagoodev.investapp.domain.repositories.QuotationRepository
import br.com.thiagoodev.investapp.domain.usecases.ListQuotationsUseCase
import br.com.thiagoodev.investapp.domain.usecases.ListQuotationsUseCaseImp
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class QuotationBindsModule {
    @Binds
    abstract fun provideQuotationRepository(imp: QuotationRepositoryImp) : QuotationRepository

    @Binds
    abstract fun provideListQuotationsUseCase(imp: ListQuotationsUseCaseImp): ListQuotationsUseCase
}