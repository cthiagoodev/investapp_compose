package br.com.thiagoodev.investapp.di

import br.com.thiagoodev.investapp.core.interceptors.TokenInterceptor
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://brapi.dev")
            .addConverterFactory(GsonConverterFactory.create())
            .client(buildClient())
            .build()
    }

    private fun buildClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .addNetworkInterceptor(TokenInterceptor())
            .build()
    }
}