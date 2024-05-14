package br.com.thiagoodev.investapp.data.datasources

import br.com.thiagoodev.investapp.domain.models.Quotation
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface QuotationDataSource {
    @GET("/api/quote/list")
    suspend fun list(
        @Query("page") page: Int = 0,
        @Query("limit") limit: Int = 10,
    ): Response<Quotation>
}