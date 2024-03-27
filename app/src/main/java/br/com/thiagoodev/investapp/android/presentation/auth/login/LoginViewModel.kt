package br.com.thiagoodev.investapp.android.presentation.auth.login

import androidx.compose.ui.text.input.TextFieldValue
import androidx.lifecycle.ViewModel
import br.com.thiagoodev.investapp.android.domain.services.AuthService
import dagger.hilt.android.lifecycle.HiltViewModel

@HiltViewModel
class LoginViewModel(private val authService: AuthService) : ViewModel() {
    var emailValue: TextFieldValue = TextFieldValue()
    var passwordValue: TextFieldValue = TextFieldValue()

    fun onChangeEmail(value: TextFieldValue) {
        this.emailValue = value;
    }

    fun onChangePassword(value: TextFieldValue) {
        this.passwordValue = value
    }
}