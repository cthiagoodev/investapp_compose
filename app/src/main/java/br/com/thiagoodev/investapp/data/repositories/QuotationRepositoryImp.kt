package br.com.thiagoodev.investapp.data.repositories

import androidx.paging.PagingSource
import androidx.paging.PagingState
import br.com.thiagoodev.investapp.core.exceptions.NoDataException
import br.com.thiagoodev.investapp.data.datasources.QuotationDataSource
import br.com.thiagoodev.investapp.domain.models.Quotation
import br.com.thiagoodev.investapp.domain.models.Stock
import br.com.thiagoodev.investapp.domain.repositories.QuotationRepository
import retrofit2.Response
import javax.inject.Inject

class QuotationRepositoryImp @Inject constructor(
    private val source: QuotationDataSource) : QuotationRepository {
    override suspend fun list(page: Int): Quotation {
        val response: Response<Quotation> = source.list(page)

        if(!response.isSuccessful) {
            throw NoDataException(response.message())
        }

        return
    }
}