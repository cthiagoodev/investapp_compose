package br.com.thiagoodev.investapp.domain.usecases

import br.com.thiagoodev.investapp.data.paging_sources.QuotationPagingSource
import br.com.thiagoodev.investapp.domain.models.Quotation

interface ListQuotationsUseCase {
    fun pagingSource(): QuotationPagingSource
    suspend fun list(page: Int): Quotation
}