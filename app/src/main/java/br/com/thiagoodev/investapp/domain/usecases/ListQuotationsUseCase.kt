package br.com.thiagoodev.investapp.domain.usecases

import androidx.paging.PagingData
import br.com.thiagoodev.investapp.data.paging_sources.QuotationPagingSource
import br.com.thiagoodev.investapp.domain.models.Quotation
import br.com.thiagoodev.investapp.domain.models.Stock
import kotlinx.coroutines.flow.Flow

interface ListQuotationsUseCase {
    fun getQuotationResult(): Flow<PagingData<Stock>>
}