package br.com.thiagoodev.investapp.android.presentation.auth.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import br.com.thiagoodev.investapp.android.R
import br.com.thiagoodev.investapp.android.presentation.theme.Theme

@Composable
fun LoginView() {
    Theme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background,
        ) {
            Image(
                painter = painterResource(id = R.drawable.login_background),
                contentDescription = "background image",
                alignment = Alignment.Center,
                modifier = Modifier.fillMaxHeight(),
                colorFilter = ColorFilter.tint(
                    MaterialTheme.colorScheme.primary,
                    blendMode = BlendMode.Color,
                )
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Theme {
    }
}