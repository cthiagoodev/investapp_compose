package br.com.thiagoodev.investapp.core.extensions

import androidx.navigation.NavHostController
import br.com.thiagoodev.investapp.config.Routes
import br.com.thiagoodev.investapp.domain.models.Stock
import com.google.gson.Gson

fun NavHostController.toQuotationDetail(stock: Stock) {
    val json: String = Gson().toJson(stock)
    currentBackStackEntry?.savedStateHandle
        ?.apply {
            set("stock", json)
        }

    navigate(Routes.quotationDetail)
}