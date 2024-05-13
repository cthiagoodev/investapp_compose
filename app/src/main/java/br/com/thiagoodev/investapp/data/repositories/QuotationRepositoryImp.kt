package br.com.thiagoodev.investapp.data.repositories

import androidx.paging.PagingSource
import androidx.paging.PagingState
import br.com.thiagoodev.investapp.data.datasources.QuotationDataSource
import br.com.thiagoodev.investapp.domain.models.Quotation
import br.com.thiagoodev.investapp.domain.models.Stock
import br.com.thiagoodev.investapp.domain.repositories.QuotationRepository
import retrofit2.Response
import javax.inject.Inject

class QuotationRepositoryImp @Inject constructor(
    private val source: QuotationDataSource) : PagingSource<Int, Stock>(), QuotationRepository {
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Stock> {
        val nextPageNumber: Int = params.key ?: 1
        val response: Response<Quotation> = source.list(nextPageNumber)
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