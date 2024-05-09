package br.com.thiagoodev.investapp.ui.home.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import br.com.thiagoodev.investapp.R

@Composable
fun AppBar() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(90.dp)
            .padding(20.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Text(
            "Olá, Thiago!",
            style = MaterialTheme.typography.titleSmall,
        )


        Icon(
            modifier = Modifier
                .size(25.dp),
            painter = painterResource(R.drawable.bell_regular),
            contentDescription = null,
        )
    }
}