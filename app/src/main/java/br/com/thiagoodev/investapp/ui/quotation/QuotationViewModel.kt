package br.com.thiagoodev.investapp.ui.quotation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import br.com.thiagoodev.investapp.domain.models.Stock
import br.com.thiagoodev.investapp.domain.usecases.ListQuotationsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class QuotationViewModel @Inject constructor(
    private val listQuotationsUseCase: ListQuotationsUseCase,
) : ViewModel() {
    val quotations: Flow<PagingData<Stock>> = Pager(pagingConfig()) {
        listQuotationsUseCase.pagingSource() }.flow.cachedIn(viewModelScope)

    private fun pagingConfig(): PagingConfig {
        return PagingConfig(
            pageSize = 10,
        )
    }
}