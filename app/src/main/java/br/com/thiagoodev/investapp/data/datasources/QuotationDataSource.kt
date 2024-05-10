package br.com.thiagoodev.investapp.data.datasources

import androidx.paging.PagingSource
import androidx.paging.PagingState
import br.com.thiagoodev.investapp.domain.models.Quotation
import br.com.thiagoodev.investapp.domain.repositories.QuotationRepository
import retrofit2.Response
import javax.inject.Inject

class QuotationDataSource @Inject constructor(
    private val repository: QuotationRepository) : PagingSource<Int, Quotation>() {
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Quotation> {
        val nextPage = params.key ?: 1

        val response: Response<Quotation> = repository.list(nextPage)
        val data: List<Quotation> = listOf(response.body()!!)
        val nextKey: Int = if(response.body()!!.hasNextPage) {
            response.body()!!.currentPage + 1
        } else 1

        return LoadResult.Page(
            data = data,
            nextKey = nextKey,
            prevKey = null,
        )
    }

    override fun getRefreshKey(state: PagingState<Int, Quotation>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }
}