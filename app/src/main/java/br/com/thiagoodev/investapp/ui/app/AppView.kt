package br.com.thiagoodev.investapp.ui.app

import androidx.compose.runtime.Composable
import br.com.thiagoodev.investapp.config.AppTheme
import br.com.thiagoodev.investapp.config.CustomVicoTheme
import br.com.thiagoodev.investapp.ui.navigation.NavigationView

@Composable
fun AppView() {
    AppTheme { CustomVicoTheme { NavigationView() } }
}