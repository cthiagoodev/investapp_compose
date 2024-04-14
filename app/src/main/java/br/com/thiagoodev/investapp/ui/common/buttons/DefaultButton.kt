package br.com.thiagoodev.investapp.ui.common.buttons

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun DefaultButton(
    modifier: Modifier = Modifier
        .fillMaxWidth()
        .height(50.dp),
    enable: Boolean = true,
    onClick: () -> Unit,
    text: String,
    textColor: Color = Color.White,
    disabledTextColor: Color = Color.White.copy(alpha = .2f),
    backgroundColor: Color = MaterialTheme.colorScheme.primary,
    disabledBackgroundColor: Color = MaterialTheme.colorScheme.primary.copy(alpha = .2f),
) {
    ElevatedButton(
        modifier = modifier,
        enabled = enable,
        colors = ButtonDefaults.elevatedButtonColors(
            containerColor = backgroundColor,
            disabledContainerColor = disabledBackgroundColor,
        ),
        elevation = ButtonDefaults.elevatedButtonElevation(defaultElevation = 0.dp),
        shape = RoundedCornerShape(10.dp),
        onClick = onClick,
    ) {
        Text(
            text = text,
            style = MaterialTheme.typography.bodySmall.copy(
                color = if(enable) textColor else disabledTextColor
            ),
        )
    }
}