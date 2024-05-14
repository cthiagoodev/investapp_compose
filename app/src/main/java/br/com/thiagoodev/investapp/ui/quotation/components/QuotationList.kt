package br.com.thiagoodev.investapp.ui.quotation.components

import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.State
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import br.com.thiagoodev.investapp.domain.models.Stock
import br.com.thiagoodev.investapp.ui.quotation.QuotationViewModel
import br.com.thiagoodev.investapp.ui.quotation.state.QuotationPaginationState

@Composable
fun QuotationList(viewModel: QuotationViewModel = hiltViewModel()) {
    val lazyListState: LazyListState = rememberLazyListState()
    val state: State<QuotationPaginationState?> = viewModel.uiState.observeAsState()
    val items: List<Stock> = viewModel.uiState.value!!.items

    LaunchedEffect(lazyListState.isScrollInProgress) {
        val isScrolledToTheEnd: Boolean =
            lazyListState.layoutInfo.visibleItemsInfo.lastOrNull()?.index ==
                    lazyListState.layoutInfo.totalItemsCount - 1

        if(state.value!!.items.isEmpty() ||
            (isScrolledToTheEnd && !state.value!!.isLoading && !state.value!!.endReached)) {
            viewModel.fetch()
        }
    }

    Column {
        Text(
            modifier = Modifier.padding(bottom = 10.dp),
            text = "Cotações disponiveis",
            style = MaterialTheme.typography.titleSmall,
        )

        LazyColumn(
            state = lazyListState,
            modifier = Modifier.fillMaxSize(),
        ) {
            items(items) {
                Box(
                    modifier = Modifier.padding(bottom = 10.dp)
                ) { QuotationItem(it) }
            }

            if (state.value!!.isLoading) {
                items(5) {
                    Box(
                        modifier = Modifier.padding(bottom = 10.dp)
                    ) {
                        QuotationItemShimmer()
                    }
                }
            }

            if (state.value!!.error != null) {
                item {
                    Text(
                        modifier = Modifier.padding(bottom = 10.dp),
                        text = state.value!!.error!!.message ?: "Ocorreu um erro",
                        style = MaterialTheme.typography.bodySmall,
                    )
                }
            }
        }
    }
}
