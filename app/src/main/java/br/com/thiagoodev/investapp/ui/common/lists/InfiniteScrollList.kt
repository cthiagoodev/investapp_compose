package br.com.thiagoodev.investapp.ui.common.lists

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import br.com.thiagoodev.investapp.core.extensions.isScrolledToTheEnd

@Composable
fun <T> InfiniteScrollList(
    items: List<T>,
    isLoading: Boolean = false,
    endReached: Boolean = false,
    error: String?,
    loadMore: suspend () -> Unit,
    loading: @Composable () -> Unit,
    content: @Composable (T) -> Unit,
) {
    val lazyListState: LazyListState = rememberLazyListState()

    LaunchedEffect(lazyListState.isScrollInProgress) {
        val isScrolledToTheEnd: Boolean = lazyListState.isScrolledToTheEnd()
        if(items.isEmpty() || (isScrolledToTheEnd && !isLoading && !endReached)) {
            loadMore()
        }
    }

    LazyColumn(
        state = lazyListState,
        modifier = Modifier.fillMaxSize(),
    ) {
        items(items) {
            content(it)
        }

        if (isLoading) {
            items(5) {
                loading()
            }
        }

        if (error != null) {
            item {
                Text(
                    modifier = Modifier.padding(bottom = 10.dp),
                    text = error,
                    style = MaterialTheme.typography.bodySmall,
                )
            }
        }
    }
}