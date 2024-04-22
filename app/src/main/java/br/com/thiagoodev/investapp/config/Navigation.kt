package br.com.thiagoodev.investapp.config

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import br.com.thiagoodev.investapp.ui.home.HomeView

@Composable
fun NavigationConfig(
    navController: NavHostController = rememberNavController()
) {
    NavHost(
        navController = navController,
        startDestination = Routes.home,
    ) {
        composable(Routes.home) { HomeView() }
    }
}
