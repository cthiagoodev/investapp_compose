package br.com.thiagoodev.investapp.ui.app

import androidx.compose.runtime.Composable
import br.com.thiagoodev.investapp.config.AppTheme
import br.com.thiagoodev.investapp.config.NavigationConfig

@Composable
fun AppView() {
    AppTheme { NavigationConfig() }
}