package br.com.thiagoodev.investapp.ui.quotation.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import br.com.thiagoodev.investapp.domain.models.Quotation
import br.com.thiagoodev.investapp.domain.models.Stock
import br.com.thiagoodev.investapp.ui.common.empty.EmptyState
import br.com.thiagoodev.investapp.ui.common.empty.ErrorState
import br.com.thiagoodev.investapp.ui.quotation.QuotationViewModel
import br.com.thiagoodev.investapp.ui.quotation.state.QuotationState

@Composable
fun QuotationList(viewModel: QuotationViewModel = hiltViewModel()) {
    val state: State<QuotationState?> = viewModel.uiState.observeAsState()

    when(state.value) {
        is QuotationState.Loading -> Loading()
        is QuotationState.Success -> Success()
        is QuotationState.Error -> ErrorState(
            (state.value as QuotationState.Error).error.message ?: "")
        is QuotationState.Empty -> EmptyState("Não há nenhuma informação por enquanto")
        else -> EmptyState("Não há nenhuma informação por enquanto")
    }
}

@Composable
private fun Success(viewModel: QuotationViewModel = hiltViewModel()) {
    val state: State<QuotationState?> = viewModel.uiState.observeAsState()
    val success: QuotationState.Success = state.value as QuotationState.Success
    val quotation: Quotation = success.quotation
    val stocks: List<Stock> = quotation.stocks

    Column {
        Text(
            modifier = Modifier.padding(bottom = 10.dp),
            text = "Cotações disponíveis",
            style = MaterialTheme.typography.titleSmall,
        )

        LazyColumn {
            items(stocks) {
                Box(
                    modifier = Modifier.padding(bottom = 10.dp)
                ) { QuotationItem(it) }
            }
        }
    }
}

@Composable
private fun Loading() {
    LazyColumn {
        items(5) {
            Box(
                modifier = Modifier.padding(bottom = 10.dp)
            ) {
                QuotationItemShimmer()
            } }
    }
}
