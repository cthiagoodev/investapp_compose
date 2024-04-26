package br.com.thiagoodev.investapp.ui.home

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
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
            modifier = Modifier.padding(
                top = 90.dp, start = 20.dp, end = 20.dp),
        ) {
            Capital()
            Box(
                modifier = Modifier.padding(top = 20.dp),
            ) {
                Chart()
            }
        }
    }
}