package br.com.thiagoodev.investapp.ui.quotation.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import br.com.thiagoodev.investapp.domain.models.Stock
import br.com.thiagoodev.investapp.ui.common.lists.InfiniteScrollList
import br.com.thiagoodev.investapp.ui.common.lists.state.PaginationState
import br.com.thiagoodev.investapp.ui.quotation.QuotationViewModel

@Composable
fun QuotationList(navigator: NavHostController, viewModel: QuotationViewModel = hiltViewModel()) {
    Column {
        Text(
            modifier = Modifier.padding(bottom = 20.dp),
            text = "Cotações disponiveis",
            style = MaterialTheme.typography.titleSmall,
        )

        val state: State<PaginationState<Stock>?> = viewModel.uiState.observeAsState()
        val items: List<Stock> = viewModel.uiState.value!!.items

        InfiniteScrollList(
            items = items,
            loadMore = viewModel::fetch,
            isLoading = state.value?.isLoading ?: false,
            endReached = state.value?.endReached ?: false,
            error = state.value?.error?.message,
            loading = {
                Box(
                    modifier = Modifier.padding(bottom = 10.dp)
                ) {
                    QuotationItemShimmer()
                }
            }
        ) {
            Box(
                modifier = Modifier.padding(bottom = 10.dp)
            ) { QuotationItem(it, navigator) }
        }
    }
}
