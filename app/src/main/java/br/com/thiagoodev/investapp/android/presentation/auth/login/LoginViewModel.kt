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
import com.google.firebase.auth.FirebaseAuthException
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

@HiltViewModel
class LoginViewModel(private val authService: AuthService) : ViewModel() {
    var emailValue: TextFieldValue = TextFieldValue()
    var passwordValue: TextFieldValue = TextFieldValue()
    val userState: MutableState<AsyncState<User>> = mutableStateOf(AsyncState())

    fun onChangeEmail(value: TextFieldValue) {
        emailValue = value
    }

    fun onChangePassword(value: TextFieldValue) {
        passwordValue = value
    }

    fun onPressedLogin() {
        userState.value = AsyncState(null, AsyncState.State.Loading)
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val dto = AuthDTO(emailValue.text, passwordValue.text)
                val result = authService.auth(dto)
                withContext(Dispatchers.Main) {
                    userState.value = AsyncState(result, AsyncState.State.Success)
                }
            } catch (error: FirebaseAuthException) {
                Log.i("error", error.toString())
                withContext(Dispatchers.Main) {
                    userState.value = AsyncState(null, AsyncState.State.Error, error.toString())
                }
            } catch (error: Exception) {
                Log.i("error", error.toString())
                withContext(Dispatchers.Main) {
                    userState.value = AsyncState(
                        null,
                        AsyncState.State.Error,
                        "Ocorreu um erro ao fazer login",
                    )
                }
            }
        }
    }
}

