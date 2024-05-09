package br.com.thiagoodev.investapp.ui.home.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.thiagoodev.investapp.core.extensions.AppGreen

@Composable
fun Capital(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
    ) {
        Text(
            text = "Seu capítal",
            style = MaterialTheme.typography.titleSmall,
        )

        Text(
            text = "R$ 200.000,00",
            style = MaterialTheme.typography.titleLarge.copy(
                fontWeight = FontWeight.Bold,
                fontSize = 34.sp,
            ),
        )

        Row {
            Text(
                modifier = Modifier.padding(end = 5.dp),
                text = "+R$1456,78(+12%)",
                style = MaterialTheme.typography.bodySmall.copy(
                    color = Color.AppGreen,
                )
            )

            Text(
                text = "Ultímos 3 meses",
                style = MaterialTheme.typography.bodySmall,
            )
        }
    }
}