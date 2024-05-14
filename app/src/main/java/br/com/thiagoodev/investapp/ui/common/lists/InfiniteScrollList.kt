package br.com.thiagoodev.investapp.ui.common.lists

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable

@Composable
fun <T> InfiniteScrollList(
    items: List<T>,
    content: @Composable () -> Unit,
    loading: @Composable () -> Unit,
    empty: @Composable () -> Unit?,
    error: @Composable () -> Unit?,
) {
    LazyColumn {

    }
}