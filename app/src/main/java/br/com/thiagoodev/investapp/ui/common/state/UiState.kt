package br.com.thiagoodev.investapp.ui.common.state

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import br.com.thiagoodev.investapp.core.state.BaseUiState

@Composable
fun UiState(state: State<BaseUiState?>) {
    when(state.value) {
        is BaseUiState.Loading -> Loading()
        else -> Empty()
    }
}

@Composable
private fun Success() {
    LazyColumn {

    }
}

@Composable
private fun Loading() {
    LazyColumn {

    }
}

@Composable
private fun Empty() {
    LazyColumn {

    }
}