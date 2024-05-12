package br.com.thiagoodev.investapp.domain.models

import com.google.gson.annotations.SerializedName

data class Quotation(
    @SerializedName("indexes")
    val indexes: List<Index>,
    @SerializedName("stocks")
    val stocks: List<Stock>,
    @SerializedName("available_sectors")
    val availableSectors: List<String>,
    @SerializedName("available_stock_types")
    val availableStockTypes: List<String>,
    @SerializedName("current_page")
    val currentPage: Int,
    @SerializedName("total_pages")
    val totalPages: Int,
    @SerializedName("total_per_page")
    val itemsPerPage: Int,
    @SerializedName("total_count")
    val totalCount: Int,
    @SerializedName("has_next_page")
    val hasNextPage: Boolean
) {
    companion object {}
}
