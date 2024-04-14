package br.com.thiagoodev.investapp.ui.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.thiagoodev.investapp.domain.services.AuthService
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(private val service: AuthService) : ViewModel() {
    private val emailState = MutableLiveData("")
    val email: LiveData<String> = emailState

    private val passwordState = MutableLiveData("")
    val password: LiveData<String> = passwordState

    private val allowLoginState = MutableLiveData(false)
    val allowLogin: LiveData<Boolean> = allowLoginState

    fun onEmailChange(value: String) {
        emailState.value = value
        enableLoginButton()
    }

    fun onPasswordChange(value: String) {
        passwordState.value = value
        enableLoginButton()
    }

    private fun enableLoginButton() {
        allowLoginState.value =
            email.value!!.isNotEmpty() &&
            passwordState.value!!.isNotEmpty()
    }
}