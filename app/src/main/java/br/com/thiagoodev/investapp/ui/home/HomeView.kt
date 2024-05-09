package br.com.thiagoodev.investapp.ui.home

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import br.com.thiagoodev.investapp.ui.home.components.AppBar
import br.com.thiagoodev.investapp.ui.home.components.Capital
import br.com.thiagoodev.investapp.ui.home.components.Chart
import br.com.thiagoodev.investapp.ui.quotation.components.QuotationList

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun HomeView() {
    Surface(
        color = MaterialTheme.colorScheme.background
    ) {
        Scaffold(
            modifier = Modifier
                .fillMaxSize(),
            topBar = { AppBar() },
        ) {
            Column(
                modifier = Modifier.padding(top = 90.dp),
            ) {
                Capital(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 20.dp, end = 20.dp)
                )

                Chart(
                    modifier = Modifier
                        .padding(top = 20.dp, bottom = 20.dp),
                )

                Box(
                    modifier = Modifier.padding(20.dp)
                ) {
                    QuotationList()
                }
            }
        }
    }
}