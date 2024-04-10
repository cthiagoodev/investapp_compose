package br.com.thiagoodev.investapp.ui.login

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import br.com.thiagoodev.investapp.R
import br.com.thiagoodev.investapp.ui.login.components.InputLogin

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun LoginView() {
    val configuration = LocalConfiguration.current

    Scaffold(
        modifier = Modifier.fillMaxSize(),
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height((configuration.screenHeightDp * .7f).dp)
                .background(MaterialTheme.colorScheme.primary)
                .clip(RoundedCornerShape(bottomEnd = 50.dp))
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(20.dp),
                horizontalAlignment = Alignment.Start
            ) {
                Image(
                    modifier = Modifier.height(100.dp),
                    painter = painterResource(R.drawable.logo),
                    contentDescription = "Logo",
                )

                Text(
                    text = "Faça login na sua plataforma de investimentos online",
                    style = MaterialTheme.typography.titleLarge.copy(
                        color = Color.White,
                    ),
                )

                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(10.dp),
                    verticalArrangement = Arrangement.Bottom,
                ) {
                    Box(
                        modifier = Modifier.padding(bottom = 10.dp)
                    ) {
                        InputLogin(
                            value = "",
                            placeholder = "E-mail",
                            onValueChange = {},
                        )
                    }

                    InputLogin(
                        value = "",
                        placeholder = "Senha",
                        onValueChange = {},
                    )
                }
            }
        }

    }
}