package br.com.thiagoodev.investapp.ui.quotation_detail.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.thiagoodev.investapp.core.extensions.AppGreen
import br.com.thiagoodev.investapp.core.extensions.toReal
import br.com.thiagoodev.investapp.domain.models.Stock
import coil.compose.AsyncImage
import coil.decode.SvgDecoder
import coil.request.ImageRequest
import java.util.Locale

@Composable
fun HeaderInfo(stock: Stock, padding: PaddingValues) {
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
                .fillMaxSize()
                .padding(horizontal = 10.dp)
                .padding(
                    top = padding.calculateTopPadding(),
                    bottom = 10.dp
                ),
            verticalArrangement = Arrangement.Bottom,
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
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

            Row(
                modifier = Modifier
                    .padding(top = 10.dp)
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Text(
                    modifier = Modifier.padding(end = 10.dp),
                    text = stock.type.replaceFirstChar {
                        if(it.isLowerCase()) it.titlecase(Locale.ROOT) else it.toString() },
                    style = MaterialTheme.typography.bodySmall.copy(
                        color = Color.White,
                    ),
                )

                Text(
                    text = stock.sector.replaceFirstChar {
                        if(it.isLowerCase()) it.titlecase(Locale.ROOT) else it.toString() },
                    style = MaterialTheme.typography.bodySmall.copy(
                        color = Color.White,
                    ),
                )
            }


            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 20.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Text(
                    text = stock.close.toReal(),
                    style = MaterialTheme.typography.titleLarge.copy(
                        fontSize = 42.sp,
                        color = Color.White,
                    ),
                )

                Text(
                    text = "81%",
                    style = MaterialTheme.typography.titleLarge.copy(
                        color = Color.AppGreen,
                    ),
                )
            }
        }
    }
}