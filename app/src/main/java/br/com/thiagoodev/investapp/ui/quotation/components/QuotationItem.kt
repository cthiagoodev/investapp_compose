package br.com.thiagoodev.investapp.ui.quotation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import br.com.thiagoodev.investapp.config.Routes
import br.com.thiagoodev.investapp.core.extensions.AppGreen
import br.com.thiagoodev.investapp.core.extensions.toReal
import br.com.thiagoodev.investapp.domain.models.Stock
import coil.compose.AsyncImage
import coil.decode.SvgDecoder
import coil.request.ImageRequest
import com.google.gson.Gson
import com.valentinilk.shimmer.shimmer

@Composable
fun QuotationItem(stock: Stock, navigator: NavHostController) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable {
                val json: String = Gson().toJson(stock)
                navigator.navigate(Routes.quotationDetail + "/$json")
           },
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
        ) {
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

            Column {
                Text(
                    modifier = Modifier
                        .padding(start = 10.dp),
                    text = stock.name,
                    style = MaterialTheme.typography.bodySmall.copy(
                        fontWeight = FontWeight.Bold,
                        fontSize = 12.sp,
                    ),
                )

                Text(
                    modifier = Modifier
                        .padding(start = 10.dp),
                    text = stock.stock,
                    style = MaterialTheme.typography.bodySmall.copy(
                        fontSize = 10.sp,
                    ),
                )
            }
        }

        Column(
            horizontalAlignment = Alignment.End,
        ) {
            Text(
                text = stock.close.toReal(),
                style = MaterialTheme.typography.bodyLarge.copy(
                    color = Color.Gray,
                    fontWeight = FontWeight.Bold,
                ),
            )

            Text(
                text = stock.change.toReal(),
                style = MaterialTheme.typography.bodySmall.copy(
                    color = if(stock.change < 0) Color.Red else Color.AppGreen,
                    fontSize = 12.sp,
                ),
            )
        }
    }
}

@Composable
fun QuotationItemShimmer() {
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Box(
                modifier = Modifier
                    .size(50.dp)
                    .shimmer()
                    .background(Color.Gray, shape = CircleShape),
            )

            Box(
                modifier = Modifier
                    .width(100.dp)
                    .height(20.dp)
                    .padding(start = 10.dp, end = 10.dp)
                    .shimmer()
                    .clip(RoundedCornerShape(10.dp))
                    .background(Color.Gray),
            )
        }

        Column(
            horizontalAlignment = Alignment.End,
            verticalArrangement = Arrangement.Center
        ) {
            Box(
                modifier = Modifier
                    .width(50.dp)
                    .height(5.dp)
                    .shimmer()
                    .clip(RoundedCornerShape(10.dp))
                    .background(Color.Gray),
            )

            Box(
                modifier = Modifier
                    .width(40.dp)
                    .height(5.dp)
                    .shimmer()
                    .clip(RoundedCornerShape(10.dp))
                    .background(Color.Gray),
            )
        }
    }
}