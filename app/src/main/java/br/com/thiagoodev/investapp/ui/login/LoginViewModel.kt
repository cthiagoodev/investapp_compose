package br.com.thiagoodev.investapp.ui.login

import androidx.lifecycle.ViewModel
import br.com.thiagoodev.investapp.domain.services.AuthService
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(private val service: AuthService) : ViewModel() {

}