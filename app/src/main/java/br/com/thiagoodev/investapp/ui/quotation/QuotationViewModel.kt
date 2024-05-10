package br.com.thiagoodev.investapp.ui.quotation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import br.com.thiagoodev.investapp.domain.models.Quotation
import br.com.thiagoodev.investapp.domain.usecases.ListQuotationsUseCase
import br.com.thiagoodev.investapp.ui.quotation.state.QuotationState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.util.concurrent.Flow
import javax.inject.Inject

@HiltViewModel
class QuotationViewModel @Inject constructor(
    private val listQuotationsUseCase: ListQuotationsUseCase,
) : ViewModel() {
    private val _uiState: MutableLiveData<QuotationState> =
        MutableLiveData(QuotationState.Empty)
    val uiState: LiveData<QuotationState> = _uiState

    init {
        viewModelScope.launch { list() }
    }

    private suspend fun list() {
        _uiState.value = QuotationState.Loading

        try {
            val response: Quotation = listQuotationsUseCase.list()
            _uiState.value = QuotationState.Success(response)
        } catch(error: Exception) {
            _uiState.value = QuotationState.Error(error)
        }
    }
}