package br.com.thiagoodev.investapp.android.modules.quote.domain.models

data class Stock(
    val stock: String,
    val name: String,
    val close: Double,
    val change: Double,
    val volume: Long,
    val marketCap: Double,
    val logo: String,
    val sector: String,
    val type: String
)
