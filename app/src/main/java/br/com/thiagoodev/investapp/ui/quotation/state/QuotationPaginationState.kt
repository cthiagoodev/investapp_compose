package br.com.thiagoodev.investapp.ui.quotation.state

import br.com.thiagoodev.investapp.domain.models.Stock

data class QuotationPaginationState(
    val items: List<Stock> = emptyList(),
    val isLoading: Boolean = false,
    val error: Throwable? = null,
    val paginationKey: Int = 1,
    val endReached: Boolean = false,
) {
    companion object {
        fun empty(): QuotationPaginationState {
            return QuotationPaginationState(
                items = emptyList(),
                isLoading = false,
                error = null,
                paginationKey = 1,
                endReached = false,
            )
        }
    }

    fun copy(
        items: List<Stock>? = null,
        isLoading: Boolean? = null,
        error: Throwable? = null,
        paginationKey: Int? = null,
        endReached: Boolean? = null,
    ): QuotationPaginationState {
        return QuotationPaginationState(
            items = items ?: this.items,
            isLoading = isLoading ?: this.isLoading,
            error = error ?: this.error,
            paginationKey = paginationKey ?: this.paginationKey,
            endReached = endReached ?: this.endReached,
        )
    }
}
