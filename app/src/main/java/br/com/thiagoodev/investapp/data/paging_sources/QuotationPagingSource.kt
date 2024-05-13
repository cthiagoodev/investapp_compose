package br.com.thiagoodev.investapp.data.paging_sources

import androidx.paging.PagingSource
import androidx.paging.PagingState
import br.com.thiagoodev.investapp.domain.models.Quotation
import br.com.thiagoodev.investapp.domain.models.Stock
import br.com.thiagoodev.investapp.domain.repositories.QuotationRepository

class QuotationPagingSource(
    private val repository: QuotationRepository) : PagingSource<Int, Stock>() {
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Stock> {
        val nextPageNumber: Int = params.key ?: 1
        val response: Quotation = repository.list(nextPageNumber)
        return LoadResult.Page(
            data = response.stocks,
            prevKey = null,
            nextKey = if(response.hasNextPage)
                response.currentPage + 1 else response.currentPage
        )

    }

    override fun getRefreshKey(state: PagingState<Int, Stock>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }
}