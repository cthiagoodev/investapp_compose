package br.com.thiagoodev.investapp.ui.quotation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.thiagoodev.investapp.core.extensions.fake
import br.com.thiagoodev.investapp.domain.models.Quotation
import br.com.thiagoodev.investapp.ui.quotation.state.QuotationState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class QuotationViewModel @Inject constructor() : ViewModel() {
    private val _uiState: MutableLiveData<QuotationState> =
        MutableLiveData(QuotationState.Success(Quotation.fake()))
    val uiState: LiveData<QuotationState> = _uiState
}