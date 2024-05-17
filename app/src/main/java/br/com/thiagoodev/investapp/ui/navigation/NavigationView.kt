package br.com.thiagoodev.investapp.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import br.com.thiagoodev.investapp.config.Routes
import br.com.thiagoodev.investapp.domain.models.Stock
import br.com.thiagoodev.investapp.ui.home.HomeView
import br.com.thiagoodev.investapp.ui.quotation_detail.QuotationDetailView

@Composable
fun NavigationView(controller: NavHostController = rememberNavController()) {
    NavHost(
        navController = controller,
        startDestination = Routes.home,
    ) {
        composable(Routes.home) { HomeView(controller) }
        composable(Routes.quotationDetail) {
            val stock: Stock =
                controller.currentBackStackEntry?.savedStateHandle?.get<Stock>("stock") ?: return@composable
            QuotationDetailView(controller, stock)
        }
    }
}