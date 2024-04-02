package br.com.thiagoodev.investapp.android.presentation.auth.login.components

import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import br.com.thiagoodev.investapp.android.presentation.auth.login.LoginViewModel
import br.com.thiagoodev.investapp.android.presentation.components.CustomOutlinedTextField

@Composable
fun FormLogin(viewModel: LoginViewModel = hiltViewModel<LoginViewModel>()) {
    CustomOutlinedTextField(
        value = viewModel.emailValue,
        label = "E-mail",
        placeholder = "Informe seu e-email",
        onValueChange = { viewModel.onChangeEmail(it) },
    )

    CustomOutlinedTextField(
        value = viewModel.passwordValue,
        onValueChange = { viewModel.onChangePassword(it) },
    )

    ElevatedButton(
        onClick = { viewModel.onPressedLogin() },
    ) {
        Text(
            "Entrar",
            style = MaterialTheme.typography.bodySmall,
        )
    }
}