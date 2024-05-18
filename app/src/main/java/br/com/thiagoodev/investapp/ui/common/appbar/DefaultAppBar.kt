package br.com.thiagoodev.investapp.ui.common.appbar

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.guru.fontawesomecomposelib.FaIcon
import com.guru.fontawesomecomposelib.FaIcons

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DefaultAppBar(navigator: NavHostController) {
    TopAppBar(
        modifier = Modifier.padding(20.dp),
        title = { },
        colors = TopAppBarColors(
            containerColor = Color.Transparent,
            titleContentColor = Color.White,
            actionIconContentColor = Color.White,
            scrolledContainerColor = Color.White,
            navigationIconContentColor = Color.White,
        ),

        navigationIcon = {
            FaIcon(
                modifier = Modifier
                    .clickable(
                        interactionSource = remember { MutableInteractionSource() },
                        indication = null,
                    ) { navigator.popBackStack() },
                faIcon = FaIcons.ArrowLeft,
                size = 25.dp,
                tint = Color.White,
            )
        },

        actions = {
            FaIcon(
                modifier = Modifier
                    .clickable(
                        interactionSource = remember { MutableInteractionSource() },
                        indication = null,
                    ) { navigator.popBackStack() },
                faIcon = FaIcons.DotCircle,
                size = 25.dp,
                tint = Color.White,
            )
        }
    )
}