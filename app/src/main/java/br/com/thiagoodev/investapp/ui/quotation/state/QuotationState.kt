package br.com.thiagoodev.investapp.ui.quotation.state

sealed class QuotationState {
    data class Loading(val quotation: Any) : QuotationState()
    data class Success(val quotation: Any) : QuotationState()
    data class Empty(val quotation: Any) : QuotationState()
    data class Error(val error: Throwable) : QuotationState()
}