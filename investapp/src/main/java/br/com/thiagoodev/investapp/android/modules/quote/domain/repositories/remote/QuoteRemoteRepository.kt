package br.com.thiagoodev.investapp.android.modules.quote.domain.repositories.remote

import br.com.thiagoodev.investapp.android.modules.quote.domain.models.Quote
import retrofit2.http.GET

interface QuoteRemoteRepository {
    @GET("/api/quote/list")
    suspend fun list(): List<Quote>
}