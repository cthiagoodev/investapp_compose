package br.com.thiagoodev.investapp.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
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

        return retrofit.build()
    }
}