package br.com.thiagoodev.investapp.ui.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.thiagoodev.investapp.domain.models.User
import br.com.thiagoodev.investapp.domain.services.AuthService
import br.com.thiagoodev.investapp.ui.login.state.UserLoginState
import com.google.firebase.FirebaseException
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(private val service: AuthService) : ViewModel() {
    private val _uiState = MutableStateFlow<UserLoginState>(UserLoginState.Initial(null))
    val uiState: StateFlow<UserLoginState> = _uiState

    private val _email = MutableLiveData("")
    val email: LiveData<String> = _email

    private val _password = MutableLiveData("")
    val password: LiveData<String> = _password

    private val _allowLogin = MutableLiveData(false)
    val allowLogin: LiveData<Boolean> = _allowLogin

    fun onEmailChange(value: String) {
        _email.value = value
        enableLoginButton()
    }

    fun onPasswordChange(value: String) {
        _password.value = value
        enableLoginButton()
    }

    private fun enableLoginButton() {
        _allowLogin.value =
            _email.value!!.isNotEmpty() &&
            _password.value!!.isNotEmpty()
    }

    fun login() {
        _uiState.value = UserLoginState.Process(null)
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val response: User = service.login(_email.value!!.trim(), _password.value!!.trim())
                withContext(Dispatchers.Main) {
                    _uiState.value = UserLoginState.Success(response)
                }
            } catch (error: FirebaseException) {
                withContext(Dispatchers.Main) {
                    _uiState.value = UserLoginState.Error(error)
                }
            } catch (error: Exception) {
                withContext(Dispatchers.Main) {
                    _uiState.value = UserLoginState.Error(Exception("Ocorreu um erro"))
                }
            }
        }
    }

    fun closeErrorDialog() {
        _uiState.value = UserLoginState.Initial(null)
    }
}