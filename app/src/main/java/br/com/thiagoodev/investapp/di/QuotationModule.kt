package br.com.thiagoodev.investapp.di

import br.com.thiagoodev.investapp.data.datasources.QuotationDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import retrofit2.Retrofit

@Module
@InstallIn(ViewModelComponent::class)
object QuotationModule {
    @Provides
    fun provideQuotationDataSource(retrofit: Retrofit): QuotationDataSource {
        return retrofit.create(QuotationDataSource::class.java)
    }
}