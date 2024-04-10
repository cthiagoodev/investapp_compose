package br.com.thiagoodev.investapp.ui.login.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@Composable
fun SignInButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    @DrawableRes icon: Int,
    text: String,
) {
    OutlinedButton(
        modifier = modifier,
        onClick = onClick,
        contentPadding = PaddingValues(20.dp),
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                modifier = Modifier.height(20.dp).padding(end = 10.dp),
                painter = painterResource(icon),
                contentDescription = "",
                tint = Color.White,
            )

            Text(
                text = text,
                style = MaterialTheme.typography.bodySmall.copy(
                    color = Color.White,
                ),
            )
        }
    }
}
