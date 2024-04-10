package br.com.thiagoodev.investapp.ui.login

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun LoginView() {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
    ) {
        TextField(
            value = "",
            placeholder = {
              Text(
                  text = "E-mail",
                  style = MaterialTheme.typography.bodySmall,
              )
            },
            onValueChange = {},
        )
    }
}