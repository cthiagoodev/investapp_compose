package br.com.thiagoodev.investapp.domain.models

data class Quotation (
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
