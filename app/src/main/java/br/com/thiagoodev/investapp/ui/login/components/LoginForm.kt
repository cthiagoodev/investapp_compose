package br.com.thiagoodev.investapp.ui.login.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
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
            InputLogin(
                value = emailState.value!!,
                placeholder = "E-mail",
                onValueChange = { viewModel.onEmailChange(it) },
            )
        }

        Box(
            modifier = Modifier.padding(bottom = 10.dp),
        ) {
            val passwordState = viewModel.password.observeAsState()
            InputLogin(
                value = passwordState.value!!,
                placeholder = "Senha",
                onValueChange = { viewModel.onPasswordChange(it) },
            )
        }

        val allowLoginState = viewModel.allowLogin.observeAsState()
        ElevatedButton(
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp),
            enabled = allowLoginState.value!!,
            elevation = ButtonDefaults.elevatedButtonElevation(defaultElevation = 0.dp),
            shape = RoundedCornerShape(10.dp),
            onClick = { /*TODO*/ },
        ) {
            Text(
                text = "Entrar",
                style = MaterialTheme.typography.bodySmall,
            )
        }
    }
}