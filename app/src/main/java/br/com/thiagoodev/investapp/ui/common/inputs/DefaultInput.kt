package br.com.thiagoodev.investapp.ui.common.inputs

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun DefaultInput(
    placeholder: String,
    value: String,
    onValueChange: (String) -> Unit,
) {
    TextField(
        modifier = Modifier.fillMaxWidth(),
        value = value,
        onValueChange = onValueChange,
        shape = RoundedCornerShape(10.dp),
        textStyle = MaterialTheme.typography.bodySmall,
        colors = TextFieldDefaults.colors(
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            focusedContainerColor = Color.White.copy(
                alpha = .3f,
            ),
            unfocusedContainerColor = Color.White.copy(
                alpha = .3f,
            ),
        ),
        placeholder = {
            Text(
                text = placeholder,
                style = MaterialTheme.typography.bodySmall.copy(
                    color = Color.White,
                ),
            )
        },
    )
}