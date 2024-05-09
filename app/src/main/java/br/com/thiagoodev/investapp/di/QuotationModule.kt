package br.com.thiagoodev.investapp.di

import br.com.thiagoodev.investapp.domain.repositories.QuotationRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import retrofit2.Retrofit

@Module
@InstallIn(ViewModelComponent::class)
object QuotationModule {
    @Provides
    fun provideQuotationRepository(retrofit: Retrofit): QuotationRepository {
        return retrofit.create(QuotationRepository::class.java)
    }
}