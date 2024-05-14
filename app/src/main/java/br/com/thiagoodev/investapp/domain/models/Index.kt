package br.com.thiagoodev.investapp.domain.models

import com.google.gson.annotations.SerializedName

data class Index (
    @SerializedName("stock")
    val stock: String,
    @SerializedName("name")
    val name: String
) {
    companion object {}
}