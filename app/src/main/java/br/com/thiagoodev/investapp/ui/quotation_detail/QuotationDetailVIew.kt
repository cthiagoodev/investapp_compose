package br.com.thiagoodev.investapp.ui.quotation_detail

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import br.com.thiagoodev.investapp.domain.models.Stock
import br.com.thiagoodev.investapp.ui.common.appbar.DefaultAppBar
import coil.compose.AsyncImage
import coil.decode.SvgDecoder
import coil.request.ImageRequest

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
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight(.4f)
                        .background(
                            Brush.radialGradient(
                                listOf(
                                    MaterialTheme.colorScheme.primary.copy(alpha = .8f),
                                    Color.Black,
                                ),
                                radius = 700f,
                            )
                        ),
                ) {
                    Column(
                        modifier = Modifier
                            .padding(horizontal = 10.dp)
                            .padding(
                                top = it.calculateTopPadding(),
                                bottom = 10.dp
                            ),
                    ) {
                        Row(
                            horizontalArrangement = Arrangement.SpaceBetween,
                        ) {
                            Column {
                                Text(
                                    text = stock.name,
                                    style = MaterialTheme.typography.titleLarge.copy(
                                        color = Color.White,
                                    ),
                                )

                                Text(
                                    text = stock.stock,
                                    style = MaterialTheme.typography.bodySmall.copy(
                                        color = Color.White,
                                    ),
                                )
                            }

                            AsyncImage(
                                modifier = Modifier
                                    .size(50.dp)
                                    .clip(RoundedCornerShape(100.dp)),
                                model = ImageRequest.Builder(LocalContext.current)
                                    .data(stock.logo)
                                    .decoderFactory(SvgDecoder.Factory())
                                    .build(),
                                contentDescription = null,
                            )

                        }
                    }
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