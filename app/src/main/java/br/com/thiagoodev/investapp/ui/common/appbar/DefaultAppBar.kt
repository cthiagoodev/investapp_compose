package br.com.thiagoodev.investapp.ui.common.appbar

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DefaultAppBar() {
    TopAppBar(
        title = { },
        colors = TopAppBarColors(
            containerColor = Color.Transparent
        ),
        navigationIcon = {

        }
    )
}