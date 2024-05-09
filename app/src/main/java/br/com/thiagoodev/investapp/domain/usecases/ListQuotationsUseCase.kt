package br.com.thiagoodev.investapp.domain.usecases

import br.com.thiagoodev.investapp.domain.models.Quotation
import br.com.thiagoodev.investapp.domain.repositories.QuotationRepository
import retrofit2.Response
import javax.inject.Inject

class ListQuotationsUseCase @Inject constructor(private val repository: QuotationRepository) {
    suspend fun list(): Quotation {
        val response: Response<Quotation> = repository.list()

        if(!response.isSuccessful) {
            throw Exception()
        }

        if(response.body() == null) {
            throw Exception()
        }

        return response.body()!!
    }
}