package br.com.thiagoodev.investapp.android.presentation.auth.login

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.text.input.TextFieldValue
import androidx.lifecycle.ViewModel
import br.com.thiagoodev.investapp.android.domain.dtos.AuthDTO
import br.com.thiagoodev.investapp.android.domain.models.User
import br.com.thiagoodev.investapp.android.domain.services.AuthService
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async

@HiltViewModel
class LoginViewModel(private val authService: AuthService) : ViewModel() {
    var emailValue: TextFieldValue = TextFieldValue()
    var passwordValue: TextFieldValue = TextFieldValue()
    val user: MutableState<User?> = mutableStateOf(null)

    fun onChangeEmail(value: TextFieldValue) {
        this.emailValue = value;
    }

    fun onChangePassword(value: TextFieldValue) {
        this.passwordValue = value
    }

    suspend fun onPressedLogin() {
        try {
           val userResult: User = CoroutineScope(Dispatchers.IO).async {
                authService.auth(AuthDTO(emailValue.text, passwordValue.text))
            }.await()
            user.value = userResult
        } catch (error: FirebaseAuthInvalidCredentialsException) {

        } catch (error: Exception) {

        }
    }
}

