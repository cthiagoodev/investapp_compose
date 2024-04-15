package br.com.thiagoodev.investapp.ui.login.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import br.com.thiagoodev.investapp.ui.common.buttons.DefaultButton
import br.com.thiagoodev.investapp.ui.common.inputs.DefaultInput
import br.com.thiagoodev.investapp.ui.login.LoginViewModel
import br.com.thiagoodev.investapp.ui.login.state.UserLoginState

@Composable
fun LoginForm(viewModel: LoginViewModel = hiltViewModel()) {
    Column(
        modifier = Modifier
            .padding(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
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

        val uiState = viewModel.uiState.collectAsState()
        if(uiState.value.inProcess()) {
            CircularProgressIndicator(
                modifier = Modifier.height(50.dp),
                color = Color.White,
                strokeWidth = 3.dp
            )
        } else {
            val allowLoginState = viewModel.allowLogin.observeAsState()
            DefaultButton(
                text = "Entrar",
                onClick = { viewModel.login() },
                enable = allowLoginState.value!!,
                textColor = MaterialTheme.colorScheme.primary,
                backgroundColor = Color.White,
                disabledBackgroundColor = Color.White.copy(alpha = .2f),
            )
        }
        
        if(uiState.value.inError()) {
            AlertDialog(
                onDismissRequest = { viewModel.closeErrorDialog() },
                confirmButton = {
                    TextButton(
                        onClick = { viewModel.closeErrorDialog() },
                    ) {
                        Text(
                            text = "Tentar novamente",
                            style = MaterialTheme.typography.bodySmall,
                        )
                    }
                },
                title = {
                    Text(
                        text = "Ocorreu um erro",
                        style = MaterialTheme.typography.bodyMedium,
                    )
                },
                text = {
                    Text(
                        text = "${(uiState.value as UserLoginState.Error).error.message}",
                        style = MaterialTheme.typography.bodySmall,
                    )
                }
            )
        }
    }
}