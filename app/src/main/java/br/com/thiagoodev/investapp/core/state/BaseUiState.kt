package br.com.thiagoodev.investapp.core.state

abstract class BaseUiState {
    data class Loading<T>(val data: T?) : BaseUiState()
    data class Success<T>(val data: T) : BaseUiState()
    data class Empty<T>(val data: T) : BaseUiState()
    data class Error(val error: Throwable) : BaseUiState()
}