package br.com.thiagoodev.investapp.ui.home

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import br.com.thiagoodev.investapp.ui.home.components.AppBar
import br.com.thiagoodev.investapp.ui.home.components.Capital
import br.com.thiagoodev.investapp.ui.home.components.Chart

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun HomeView() {
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
                    .padding(top = 20.dp),
            )

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(start = 20.dp, end = 20.dp)
            ) {

            }
        }
    }
}