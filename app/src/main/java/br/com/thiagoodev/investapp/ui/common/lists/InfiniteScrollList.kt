package br.com.thiagoodev.investapp.ui.common.lists

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier

@Composable
fun <T> InfiniteScrollList(
    items: List<T>,
    isLoading: Boolean = false,
    endReached: Boolean = false,
    loadMore: suspend () -> Unit,
    loading: @Composable () -> Unit,
    error: (@Composable () -> Unit)?,
    content: @Composable (T) -> Unit,
) {
    val lazyListState: LazyListState = rememberLazyListState()

    LaunchedEffect(lazyListState.isScrollInProgress) {
        val isScrolledToTheEnd: Boolean =
            lazyListState.layoutInfo.visibleItemsInfo.lastOrNull()?.index ==
                    lazyListState.layoutInfo.totalItemsCount - 1

        if(items.isEmpty() || (isScrolledToTheEnd && isLoading && endReached)) {
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
                error()
            }
        }
    }
}