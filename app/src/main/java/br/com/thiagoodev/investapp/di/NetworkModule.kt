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
        val retrofit: Retrofit.Builder = Retrofit.Builder()
        retrofit.baseUrl("https://brapi.dev/api")
        retrofit.addConverterFactory(GsonConverterFactory.create())
        retrofit.client(buildClient())
        return retrofit.build()
    }

    private fun buildClient(): OkHttpClient {
        val client: OkHttpClient.Builder = OkHttpClient.Builder()
        client.addNetworkInterceptor(TokenInterceptor())
        return client.build()
    }
}