package br.com.thiagoodev.investapp.android.presentation.components

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue

@Composable
fun CustomOutlinedTextField(
    value: TextFieldValue,
    onValueChange: (TextFieldValue) -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    readOnly: Boolean = false,
    label: String = "",
    placeholder: String = "",
) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        modifier = modifier,
        enabled = enabled,
        textStyle = MaterialTheme.typography.bodySmall,
        readOnly = readOnly,
        label = {
            Text(
                text = label,
                style = MaterialTheme.typography.bodySmall,
            )
        },
        placeholder = {
            Text(
                text = placeholder,
                style = MaterialTheme.typography.bodySmall,
            )
        },
    )
}