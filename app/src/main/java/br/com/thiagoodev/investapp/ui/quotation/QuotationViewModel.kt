package br.com.thiagoodev.investapp.ui.quotation

import androidx.lifecycle.ViewModel
import androidx.paging.PagingData
import br.com.thiagoodev.investapp.domain.models.Stock
import br.com.thiagoodev.investapp.domain.usecases.ListQuotationsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import javax.inject.Inject

@HiltViewModel
class QuotationViewModel @Inject constructor(
    private val listQuotationsUseCase: ListQuotationsUseCase,
) : ViewModel() {
    private val _uiState: MutableStateFlow<PagingData<Stock>> = MutableStateFlow(PagingData.empty())
    val uiState: Flow<PagingData<Stock>> = _uiState.asStateFlow()

    suspend fun initPagination() {
        listQuotationsUseCase.getQuotationResult()
            .collectLatest { _uiState.value = it }
    }
}