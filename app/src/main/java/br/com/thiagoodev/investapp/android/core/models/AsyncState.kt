package br.com.thiagoodev.investapp.android.core.models

class AsyncState<T>(
    var state: T? = null,
    var status: State = State.Loading,
    var error: String? = null
) {
    enum class State {
        Loading,
        Success,
        Error,
        Empty,
    }
}