package br.com.thiagoodev.investapp.data.paging_sources

import androidx.paging.PagingSource
import androidx.paging.PagingState
import br.com.thiagoodev.investapp.core.exceptions.AppException
import br.com.thiagoodev.investapp.domain.models.Quotation
import br.com.thiagoodev.investapp.domain.models.Stock
import br.com.thiagoodev.investapp.domain.repositories.QuotationRepository
import javax.inject.Inject

class QuotationPagingSource @Inject constructor(
    private val repository: QuotationRepository) : PagingSource<Int, Stock>() {
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Stock> {
        try {
            val page: Int = params.key ?: 1
            val response: Quotation = repository.list(page)

            if(response.totalPages != page) {
                this.invalidate()
                return LoadResult.Invalid()
            }

            return LoadResult.Page(
                data = response.stocks,
                prevKey = null,
                nextKey = if(response.hasNextPage)
                    response.currentPage + 1 else response.currentPage
            )
        } catch(error: AppException) {
            return LoadResult.Error(error)
        } catch (error: Exception) {
            return LoadResult.Error(Exception("Ocorreu um erro ao buscar resultados"))
        }

    }

    override fun getRefreshKey(state: PagingState<Int, Stock>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }
}