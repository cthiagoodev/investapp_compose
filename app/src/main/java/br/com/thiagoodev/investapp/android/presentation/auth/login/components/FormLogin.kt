package br.com.thiagoodev.investapp.android.presentation.auth.login.components

import androidx.compose.runtime.Composable
import br.com.thiagoodev.investapp.android.presentation.auth.login.LoginViewModel
import br.com.thiagoodev.investapp.android.presentation.components.CustomOutlinedTextField

@Composable
fun FormLogin(viewModel: LoginViewModel) {
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
}