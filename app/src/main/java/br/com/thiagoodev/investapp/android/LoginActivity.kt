package br.com.thiagoodev.investapp.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import br.com.thiagoodev.investapp.android.presentation.auth.login.LoginView
import br.com.thiagoodev.investapp.android.presentation.auth.login.LoginViewModel

class LoginActivity : ComponentActivity() {
    val viewModel: LoginViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { LoginView() }
    }
}
