package br.com.thiagoodev.investapp.ui.quotation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.thiagoodev.investapp.core.exceptions.AppException
import br.com.thiagoodev.investapp.domain.models.Quotation
import br.com.thiagoodev.investapp.domain.models.Stock
import br.com.thiagoodev.investapp.domain.usecases.ListQuotationsUseCase
import br.com.thiagoodev.investapp.ui.common.lists.state.PaginationState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class QuotationViewModel @Inject constructor(
    private val listQuotationsUseCase: ListQuotationsUseCase,
) : ViewModel() {
    private val _uiState: MutableLiveData<PaginationState<Stock>> =
        MutableLiveData(PaginationState.empty())
    val uiState: LiveData<PaginationState<Stock>> = _uiState

    suspend fun fetch() {
        _uiState.value = _uiState.value?.copy(isLoading = true)

        try {
            val paginationKey: Int = _uiState.value?.paginationKey ?: 0
            val quotation: Quotation = listQuotationsUseCase.list(paginationKey)
            val cachedItems: List<Stock> = _uiState.value?.items ?: emptyList()
            val endReached: Boolean = quotation.hasNextPage

            _uiState.value = _uiState.value?.copy(
                items = cachedItems + quotation.stocks,
                isLoading = false,
                error = null,
                paginationKey = quotation.currentPage + 1,
                endReached = endReached,
            )
        } catch(error: AppException) {
            _uiState.value = _uiState.value?.copy(
                isLoading = false,
                error = error,
            )
        } catch(error: Exception) {
            _uiState.value = _uiState.value?.copy(
                isLoading = false,
                error = Exception("Ocorreu um erro ao buscar items"),
            )
        }
    }
}