package br.com.thiagoodev.investapp.data.services

import br.com.thiagoodev.investapp.domain.models.Quotation
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface QuotationService {
    @GET("/api/quote/list")
    suspend fun list(@Query("page") page: Int = 1): Response<Quotation>
}