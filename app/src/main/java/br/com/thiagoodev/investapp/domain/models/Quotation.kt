package br.com.thiagoodev.investapp.domain.models

import com.google.gson.annotations.SerializedName

data class Quotation(
    @SerializedName("indexes")
    val indexes: List<Index>,
    @SerializedName("stocks")
    val stocks: List<Stock>,
    @SerializedName("availableSectors")
    val availableSectors: List<String>,
    @SerializedName("availableStockTypes")
    val availableStockTypes: List<String>,
    @SerializedName("currentPage")
    val currentPage: Int,
    @SerializedName("totalPages")
    val totalPages: Int,
    @SerializedName("totalPerPage")
    val itemsPerPage: Int,
    @SerializedName("totalCount")
    val totalCount: Int,
    @SerializedName("hasNextPage")
    val hasNextPage: Boolean
) {
    companion object {}
}
