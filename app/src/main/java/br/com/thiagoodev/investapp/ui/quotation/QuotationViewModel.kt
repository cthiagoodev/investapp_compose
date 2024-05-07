package br.com.thiagoodev.investapp.ui.quotation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.thiagoodev.investapp.ui.quotation.state.QuotationState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class QuotationViewModel @Inject constructor() : ViewModel() {
    private val _uiState: MutableLiveData<QuotationState> =
        MutableLiveData()
    val uiState: LiveData<QuotationState> = _uiState
}