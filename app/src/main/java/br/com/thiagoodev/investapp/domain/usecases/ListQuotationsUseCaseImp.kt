package br.com.thiagoodev.investapp.domain.usecases

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import br.com.thiagoodev.investapp.data.paging_sources.QuotationPagingSource
import br.com.thiagoodev.investapp.domain.models.Stock
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ListQuotationsUseCaseImp @Inject constructor(
    private val source: QuotationPagingSource) : ListQuotationsUseCase {

    override fun getQuotationResult(): Flow<PagingData<Stock>> {
        return Pager(PagingConfig(pageSize = 10)) { source }.flow
    }
}