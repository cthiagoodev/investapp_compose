package br.com.thiagoodev.investapp.ui.common.lists.state

data class PaginationState<T>(
    val items: List<T> = emptyList(),
    val isLoading: Boolean = false,
    val error: Throwable? = null,
    val paginationKey: Int = 1,
    val endReached: Boolean = false,
) {
    companion object {
        fun <T> empty(): PaginationState<T> {
            return PaginationState(
                items = emptyList(),
                isLoading = false,
                error = null,
                paginationKey = 1,
                endReached = false,
            )
        }
    }

    fun copy(
        items: List<T>? = null,
        isLoading: Boolean? = null,
        error: Throwable? = null,
        paginationKey: Int? = null,
        endReached: Boolean? = null,
    ): PaginationState<T> {
        return PaginationState(
            items = items ?: this.items,
            isLoading = isLoading ?: this.isLoading,
            error = error ?: this.error,
            paginationKey = paginationKey ?: this.paginationKey,
            endReached = endReached ?: this.endReached,
        )
    }
}
