package br.com.thiagoodev.investapp.ui.quotation.components

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.livedata.observeAsState
import androidx.hilt.navigation.compose.hiltViewModel
import br.com.thiagoodev.investapp.ui.quotation.QuotationViewModel
import br.com.thiagoodev.investapp.ui.quotation.state.QuotationState

@Composable
fun QuotationList(viewModel: QuotationViewModel = hiltViewModel()) {
    val state: State<QuotationState?> = viewModel.uiState.observeAsState()
}

@Composable
private fun Success(viewModel: QuotationViewModel = hiltViewModel()) {
    LazyColumn {

    }
}

@Composable
private fun Loading(viewModel: QuotationViewModel = hiltViewModel()) {
    LazyColumn {

    }
}

