package br.com.thiagoodev.investapp.ui.quotation_detail

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import br.com.thiagoodev.investapp.domain.models.Stock
import br.com.thiagoodev.investapp.ui.common.appbar.DefaultAppBar
import br.com.thiagoodev.investapp.ui.quotation_detail.components.HeaderInfo

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun QuotationDetailView(navigator: NavHostController, stock: Stock) {
    Surface(
        color = MaterialTheme.colorScheme.background,
    ) {
        Scaffold(
            containerColor = MaterialTheme.colorScheme.background,
            topBar = { DefaultAppBar(navigator) }
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize(),
            ) {
                HeaderInfo(stock, it)

                Column(
                    modifier = Modifier
                        .fillMaxSize(),
                ) {


                }
            }
        }
    }
}