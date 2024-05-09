package br.com.thiagoodev.investapp.domain.repositories

import br.com.thiagoodev.investapp.domain.models.Quotation
import retrofit2.Response
import retrofit2.http.GET

interface QuotationRepository {
    @GET("/api/quote/list")
    suspend fun list(): Response<Quotation>
}