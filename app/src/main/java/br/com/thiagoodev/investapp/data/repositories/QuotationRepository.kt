package br.com.thiagoodev.investapp.data.repositories

import androidx.paging.PagingSource
import androidx.paging.PagingState
import br.com.thiagoodev.investapp.data.services.QuotationService
import br.com.thiagoodev.investapp.domain.models.Stock
import javax.inject.Inject

class QuotationRepository @Inject constructor(
    private val service: QuotationService) : PagingSource<Int, Stock>() {
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Stock> {
        val nextPageNumber = params.key ?: 1
        val response = service.list(nextPageNumber)
        return LoadResult.Page(
            data = response.body()!!.stocks,
            prevKey = null,
            nextKey = if(response.body()!!.hasNextPage)
                response.body()!!.currentPage + 1 else response.body()!!.currentPage
        )

    }
    override fun getRefreshKey(state: PagingState<Int, Stock>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }
}