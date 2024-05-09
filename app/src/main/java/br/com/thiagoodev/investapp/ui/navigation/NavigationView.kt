package br.com.thiagoodev.investapp.ui.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import br.com.thiagoodev.investapp.config.Routes
import br.com.thiagoodev.investapp.ui.home.HomeView

@Composable
fun NavigationView(viewModel: NavigationViewModel = hiltViewModel()) {
    viewModel.controller = rememberNavController()

    NavHost(
        navController = viewModel.controller,
        startDestination = Routes.home,
    ) {
        composable(Routes.home) { HomeView() }
    }
}