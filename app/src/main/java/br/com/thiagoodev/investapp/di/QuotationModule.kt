package br.com.thiagoodev.investapp.di

import br.com.thiagoodev.investapp.data.services.QuotationService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import retrofit2.Retrofit

@Module
@InstallIn(ViewModelComponent::class)
object QuotationModule {
    @Provides
    fun provideQuotationService(retrofit: Retrofit): QuotationService {
        return retrofit.create(QuotationService::class.java)
    }
}