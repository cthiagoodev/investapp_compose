package br.com.thiagoodev.investapp.ui.home.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
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
import com.patrykandpatrick.vico.compose.cartesian.axis.rememberBottomAxis
import com.patrykandpatrick.vico.compose.cartesian.axis.rememberStartAxis
import com.patrykandpatrick.vico.compose.cartesian.layer.rememberLineCartesianLayer
import com.patrykandpatrick.vico.compose.cartesian.rememberCartesianChart
import com.patrykandpatrick.vico.core.cartesian.data.CartesianChartModelProducer
import com.patrykandpatrick.vico.core.cartesian.data.CartesianValueFormatter
import com.patrykandpatrick.vico.core.cartesian.data.columnSeries
import com.patrykandpatrick.vico.core.cartesian.data.lineSeries
import com.patrykandpatrick.vico.core.common.data.ExtraStore
import com.patrykandpatrick.vico.core.common.shape.Shape

@Composable
fun Chart(
    modifier: Modifier = Modifier,
    viewModel: HomeViewModel = hiltViewModel(),
) {
    val modelProducer = remember { CartesianChartModelProducer.build() }
    val labelListKey = ExtraStore.Key<List<String>>()

    LaunchedEffect(Unit) {
        val bottomData: Map<String, Float> = mapOf(
            "1D" to 1f,
            "6M" to 2f,
            "1A" to 3f,
            "5A" to 4f,
            "10A" to 5f,
            "15A" to 6f,
        )

        modelProducer.tryRunTransaction {
            columnSeries {
                series(bottomData.values)
            }
            lineSeries {
                series(50, 250, 456.76, 1234.76, 834.76, 934.76)
            }

            updateExtras { it[labelListKey] = bottomData.keys.toList() }
        }
    }

    val formatter = CartesianValueFormatter {
        x, chartValues, _ -> chartValues.model.extraStore[labelListKey][x.toInt()] }

    Box(
        modifier = modifier,
    ) {
        CartesianChartHost(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp),
            chart = rememberCartesianChart(
                rememberLineCartesianLayer(),
                startAxis = rememberStartAxis(
                    label = null,
                    tick = null,
                    axis = null,
                    guideline = rememberAxisGuidelineComponent(
                        shape = Shape.Pill,
                        thickness = .5f.dp,
                        color = Color.Gray.copy(
                            alpha = .1f,
                        )
                    ),
                ),
                bottomAxis = rememberBottomAxis(
                    label = rememberAxisLabelComponent(
                        color = Color.Gray,
                    ),
                    valueFormatter = formatter,
                    guideline = null,
                    tick = null,
                    axis = null,
                ),
            ),
            modelProducer = modelProducer
        )
    }
}