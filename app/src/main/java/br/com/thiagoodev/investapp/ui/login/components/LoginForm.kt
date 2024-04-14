package br.com.thiagoodev.investapp.ui.login.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import br.com.thiagoodev.investapp.ui.common.buttons.DefaultButton
import br.com.thiagoodev.investapp.ui.common.inputs.DefaultInput
import br.com.thiagoodev.investapp.ui.login.LoginViewModel

@Composable
fun LoginForm(viewModel: LoginViewModel = hiltViewModel()) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp),
    ) {
        Box(
            modifier = Modifier.padding(bottom = 10.dp)
        ) {
            val emailState = viewModel.email.observeAsState()
            DefaultInput(
                value = emailState.value!!,
                placeholder = "E-mail",
                onValueChange = { viewModel.onEmailChange(it) },
            )
        }

        Box(
            modifier = Modifier.padding(bottom = 10.dp),
        ) {
            val passwordState = viewModel.password.observeAsState()
            DefaultInput(
                value = passwordState.value!!,
                placeholder = "Senha",
                onValueChange = { viewModel.onPasswordChange(it) },
            )
        }

        val allowLoginState = viewModel.allowLogin.observeAsState()
        DefaultButton(
            text = "Entrar",
            onClick = {},
            enable = allowLoginState.value!!,
        )
    }
}