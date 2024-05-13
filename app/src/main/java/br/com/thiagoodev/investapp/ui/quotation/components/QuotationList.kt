package br.com.thiagoodev.investapp.ui.quotation.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import br.com.thiagoodev.investapp.domain.models.Stock
import br.com.thiagoodev.investapp.ui.common.empty.EmptyState
import br.com.thiagoodev.investapp.ui.quotation.QuotationViewModel

@Composable
fun QuotationList(viewModel: QuotationViewModel = hiltViewModel()) {
    val state: LazyPagingItems<Stock> = viewModel.quotations.collectAsLazyPagingItems()
    when(state.loadState.source.append) {
        is LoadState.Loading -> Loading()
        is LoadState.NotLoading -> Success()
        else -> {
            if (state.loadState.append is LoadState.NotLoading &&
                state.itemSnapshotList.isEmpty()) {
                EmptyState("Não há nenhuma informação por enquanto")
            }
        }
    }
}

@Composable
private fun Success(viewModel: QuotationViewModel = hiltViewModel()) {
    val state: LazyPagingItems<Stock> = viewModel.quotations.collectAsLazyPagingItems()

    Column {
        Text(
            modifier = Modifier.padding(bottom = 10.dp),
            text = "Cotações disponíveis",
            style = MaterialTheme.typography.titleSmall,
        )

        LazyColumn {
            items(state.itemSnapshotList) {
                Box(
                    modifier = Modifier.padding(bottom = 10.dp)
                ) { QuotationItem(it!!) }
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
