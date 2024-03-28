package br.com.thiagoodev.investapp.android.presentation.auth.login

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.text.input.TextFieldValue
import androidx.lifecycle.ViewModel
import br.com.thiagoodev.investapp.android.core.models.AsyncState
import br.com.thiagoodev.investapp.android.domain.dtos.AuthDTO
import br.com.thiagoodev.investapp.android.domain.models.User
import br.com.thiagoodev.investapp.android.domain.services.AuthService
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException
import dagger.hilt.android.lifecycle.HiltViewModel

@HiltViewModel
class LoginViewModel(private val authService: AuthService) : ViewModel() {
    var emailValue: TextFieldValue = TextFieldValue()
    var passwordValue: TextFieldValue = TextFieldValue()
    val userState: MutableState<AsyncState<User>> = mutableStateOf(AsyncState())

    fun onChangeEmail(value: TextFieldValue) {
        this.emailValue = value;
    }

    fun onChangePassword(value: TextFieldValue) {
        this.passwordValue = value
    }

    suspend fun onPressedLogin() {
        userState.value = AsyncState(status = AsyncState.State.Loading)
        try {
            val userResult: User = authService.auth(AuthDTO(emailValue.text, passwordValue.text))
            userState.value = AsyncState(userResult, AsyncState.State.Success)
        } catch (error: FirebaseAuthInvalidCredentialsException) {
            Log.i(error.toString(), error.toString())
            userState.value = AsyncState(null, AsyncState.State.Error)
        } catch (error: Exception) {
            userState.value = AsyncState(null, AsyncState.State.Error)
        }
    }
}

