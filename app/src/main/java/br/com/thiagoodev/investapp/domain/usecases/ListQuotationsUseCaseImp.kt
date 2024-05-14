package br.com.thiagoodev.investapp.domain.usecases

import br.com.thiagoodev.investapp.data.paging_sources.QuotationPagingSource
import javax.inject.Inject

class ListQuotationsUseCaseImp @Inject constructor(
    private val source: QuotationPagingSource) : ListQuotationsUseCase {
    override fun pagingSource(): QuotationPagingSource {
        return source
    }
}