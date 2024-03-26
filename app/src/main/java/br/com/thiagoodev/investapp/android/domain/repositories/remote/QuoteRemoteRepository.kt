package br.com.thiagoodev.investapp.android.domain.repositories.remote

import br.com.thiagoodev.investapp.android.domain.models.Quote
import retrofit2.http.GET

interface QuoteRemoteRepository {
    @GET("/api/quote/list")
    suspend fun list(): List<Quote>
}