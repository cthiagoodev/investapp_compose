package br.com.thiagoodev.investapp.ui.quotation_detail

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import br.com.thiagoodev.investapp.ui.common.appbar.DefaultAppBar

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun QuotationDetailView() {
    Surface(
        color = MaterialTheme.colorScheme.background,
    ) {
        Scaffold(
            containerColor = MaterialTheme.colorScheme.background,
            topBar = { DefaultAppBar() }
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize(),
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight(.4f)
                        .background(
                            Brush.radialGradient(
                                listOf(
                                    MaterialTheme.colorScheme.primary.copy(
                                        alpha = .8f
                                    ),
                                    Color.Black,
                                ),
                                radius = 700f,
                            )
                        ),
                ) {

                }
                Column(
                    modifier = Modifier
                        .fillMaxSize(),
                ) {

                }
            }
        }
    }
}