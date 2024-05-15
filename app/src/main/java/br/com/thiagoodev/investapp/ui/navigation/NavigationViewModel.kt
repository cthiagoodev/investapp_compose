package br.com.thiagoodev.investapp.ui.navigation

import android.content.Context
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavOptions
import androidx.navigation.Navigator
import androidx.navigation.compose.ComposeNavigator
import androidx.navigation.compose.DialogNavigator
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

@HiltViewModel
class NavigationViewModel @Inject constructor(@ApplicationContext context: Context) : ViewModel() {
    val controller: NavHostController = NavHostController(context).apply {
        navigatorProvider.addNavigator(ComposeNavigator())
        navigatorProvider.addNavigator(DialogNavigator())
    }

    fun navigate(
        route: String, navOptions: NavOptions? = null, navigatorExtras: Navigator.Extras? = null) {
        try {
            controller.navigate(route, navOptions, navigatorExtras)
        } catch(error: Exception) {
            Log.i("error", error.message ?: "")
        }
    }
}