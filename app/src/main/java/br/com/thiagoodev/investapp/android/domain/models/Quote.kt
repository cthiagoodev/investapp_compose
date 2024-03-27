package br.com.thiagoodev.investapp.android.domain.models

data class Quote(
    val indexes: List<Index>,
    val stocks: List<Stock>,
    val availableSectors: List<String>,
    val availableStockTypes: List<String>,
    val currentPage: Int,
    val totalPages: Int,
    val itemsPerPage: Int,
    val totalCount: Int,
    val hasNextPage: Boolean
)
