package br.com.thiagoodev.investapp.core.extensions

import java.text.DecimalFormat

fun Double.toReal(): String {
    val formatter = DecimalFormat("#,##0.00")
    return "R$ ${formatter.format(this)}"
}