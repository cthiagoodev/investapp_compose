package br.com.thiagoodev.investapp.ui.login.state

import br.com.thiagoodev.investapp.domain.models.User

sealed class UserLoginState() {
    data class Initial(val user: User?) : UserLoginState()
    data class Process(val user: User?) : UserLoginState()
    data class Success(val user: User?) : UserLoginState()
    data class Error(val error: Throwable) : UserLoginState()

    fun inProcess() = this is Process

    fun inSuccess() = this is Success

    fun inError() = this is Error
}