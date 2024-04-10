package br.com.thiagoodev.investapp.config

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import br.com.thiagoodev.investapp.ui.login.LoginView

@Composable
fun NavigationConfig() {
    val navController: NavHostController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Routes.login,
    ) {
        composable(Routes.login) { LoginView() }
    }
}