package br.com.thiagoodev.investapp.ui.home.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import br.com.thiagoodev.investapp.ui.home.HomeViewModel
import com.patrykandpatrick.vico.compose.cartesian.CartesianChartHost
import com.patrykandpatrick.vico.compose.cartesian.axis.rememberAxisGuidelineComponent
import com.patrykandpatrick.vico.compose.cartesian.axis.rememberAxisLabelComponent
import com.patrykandpatrick.vico.compose.cartesian.axis.rememberAxisLineComponent
import com.patrykandpatrick.vico.compose.cartesian.axis.rememberAxisTickComponent
import com.patrykandpatrick.vico.compose.cartesian.axis.rememberBottomAxis
import com.patrykandpatrick.vico.compose.cartesian.axis.rememberStartAxis
import com.patrykandpatrick.vico.compose.cartesian.layer.rememberLineCartesianLayer
import com.patrykandpatrick.vico.compose.cartesian.rememberCartesianChart
import com.patrykandpatrick.vico.compose.common.component.rememberLineComponent
import com.patrykandpatrick.vico.compose.common.component.rememberTextComponent
import com.patrykandpatrick.vico.compose.common.rememberHorizontalLegend
import com.patrykandpatrick.vico.compose.common.rememberLegendItem
import com.patrykandpatrick.vico.compose.common.rememberVerticalLegend
import com.patrykandpatrick.vico.core.cartesian.data.CartesianChartModelProducer
import com.patrykandpatrick.vico.core.cartesian.data.lineSeries
import com.patrykandpatrick.vico.core.common.component.TextComponent
import com.patrykandpatrick.vico.core.common.shape.Shape

@Composable
fun Chart(viewModel: HomeViewModel = hiltViewModel()) {
    val modelProducer = remember { CartesianChartModelProducer.build() }

    LaunchedEffect(Unit) {
        modelProducer.tryRunTransaction {
            lineSeries {
                series(50, 250, 456.76, 1234.76)
            }
        }
    }

    CartesianChartHost(
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp),
        chart = rememberCartesianChart(
            rememberLineCartesianLayer(),
            legend = rememberVerticalLegend(
                items = arrayOf(
                    rememberLegendItem(
                        icon = rememberLineComponent(),
                        label = rememberTextComponent(),
                        labelText = ,
                    ),
                ),
                iconSize = ,
                iconPadding = ,
            ),
            startAxis = rememberStartAxis(
                label = null,
                tick = null,
                axis = null,
                guideline = rememberAxisGuidelineComponent(
                    shape = Shape.Pill,
                    thickness = 2.dp,
                    color = Color.Gray.copy(
                        alpha = .1f,
                    )
                ),

            ),
            bottomAxis = rememberBottomAxis(
                label = rememberAxisLabelComponent(
                    color = Color.Gray,
                ),
                guideline = null,
                tick = null,
                axis = null,
            ),
        ),
        modelProducer = modelProducer
    )
}