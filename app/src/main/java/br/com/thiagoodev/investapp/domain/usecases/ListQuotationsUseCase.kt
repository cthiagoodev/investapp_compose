package br.com.thiagoodev.investapp.domain.usecases

import androidx.paging.PagingSource
import br.com.thiagoodev.investapp.data.repositories.QuotationRepositoryImp
import br.com.thiagoodev.investapp.domain.models.Quotation
import retrofit2.Response
import javax.inject.Inject

class ListQuotationsUseCase @Inject constructor(private val repository: QuotationRepositoryImp) {
    suspend fun list(): Quotation {
        val params: PagingSource.LoadParams<Int> = PagingSource.LoadParams<Int>()
        val response: Response<Quotation> = repository.load()

        if(!response.isSuccessful) {
            throw Exception()
        }

        if(response.body() == null) {
            throw Exception()
        }

        return response.body()!!
    }
}