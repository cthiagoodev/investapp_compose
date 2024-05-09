package br.com.thiagoodev.investapp.ui.quotation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import br.com.thiagoodev.investapp.core.extensions.AppGreen
import br.com.thiagoodev.investapp.core.extensions.toReal
import br.com.thiagoodev.investapp.domain.models.Stock
import coil.compose.AsyncImage
import com.valentinilk.shimmer.shimmer

@Composable
fun QuotationItem(stock: Stock) {
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Box(
                modifier = Modifier
                    .size(50.dp)
                    .background(MaterialTheme.colorScheme.primary, shape = CircleShape),
                contentAlignment = Alignment.Center,
            ) {
                AsyncImage(
                    modifier = Modifier.size(40.dp),
                    model = stock.logo,
                    contentDescription = null,
                )
            }

            Text(
                modifier = Modifier
                    .padding(start = 10.dp),
                text = stock.name,
                style = MaterialTheme.typography.bodySmall.copy(
                    fontWeight = FontWeight.Bold,
                ),
            )
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
                    color = if(stock.change < 0) Color.Red else Color.AppGreen
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
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Box(
                modifier = Modifier
                    .size(50.dp)
                    .background(Color.Gray, shape = CircleShape)
                    .shimmer(),
            )

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 10.dp)
                    .shimmer(),
            )
        }

        Column(
            horizontalAlignment = Alignment.End,
        ) {
            Box(
                modifier = Modifier
                    .width(50.dp)
                    .padding(start = 10.dp)
                    .shimmer(),
            )

            Box(
                modifier = Modifier
                    .width(50.dp)
                    .padding(start = 10.dp)
                    .shimmer(),
            )
        }
    }
}