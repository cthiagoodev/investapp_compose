package br.com.thiagoodev.investapp.ui.quotation.state

import br.com.thiagoodev.investapp.domain.models.Quotation

sealed class QuotationState {
    data object Loading : QuotationState()
    data class Success(val quotation: Quotation) : QuotationState()
    data object Empty : QuotationState()
    data class Error(val error: Throwable) : QuotationState()
}