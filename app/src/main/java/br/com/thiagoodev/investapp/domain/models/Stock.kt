package br.com.thiagoodev.investapp.domain.models

import com.google.gson.annotations.SerializedName
import kotlin.math.roundToInt

data class Stock (
    @SerializedName("stock")
    val stock: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("close")
    val close: Double,
    @SerializedName("change")
    val change: Double,
    @SerializedName("volume")
    val volume: Double,
    @SerializedName("market_cap")
    val marketCap: Double,
    @SerializedName("logo")
    val logo: String,
    @SerializedName("sector")
    val sector: String,
    @SerializedName("type")
    val type: String
) {
    companion object {}

    fun percentChange(): Double {
        val percent: Double = (change / close - change) * 100
        return (percent * 100).roundToInt().toDouble() / 100
    }
}