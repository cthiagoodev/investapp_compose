package br.com.thiagoodev.investapp.ui.home.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import br.com.thiagoodev.investapp.ui.home.HomeViewModel
import com.patrykandpatrick.vico.compose.cartesian.CartesianChartHost
import com.patrykandpatrick.vico.compose.cartesian.rememberCartesianChart
import com.patrykandpatrick.vico.core.cartesian.CartesianChart
import com.patrykandpatrick.vico.core.cartesian.data.CartesianChartModel

@Composable
fun Chart(viewModel: HomeViewModel = hiltViewModel()) {
    val chart = rememberCartesianChart(

    )

    CartesianChartHost(
        modifier = Modifier
            .fillMaxWidth()
            .height(80.dp),
        chart = chart,
        model = CartesianChartModel(),
    )
}