package br.com.thiagoodev.investapp.ui.login

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import br.com.thiagoodev.investapp.R
import br.com.thiagoodev.investapp.ui.login.components.SignInButton

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun LoginView() {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        containerColor = Color.Black,
    ) {
        Image(
            modifier = Modifier.fillMaxHeight(),
            contentScale = ContentScale.Crop,
            alignment = Alignment.Center,
            painter = painterResource(R.drawable.login_background),
            contentDescription = "Background Login",
            alpha = .3f,
            colorFilter = ColorFilter.tint(
                color = Color.Black.copy(
                    alpha = .5f,
                ),
                blendMode = BlendMode.Overlay,
            )
        )

        Column(
             modifier = Modifier
                 .fillMaxSize()
                 .padding(20.dp),
             horizontalAlignment = Alignment.CenterHorizontally,
             verticalArrangement = Arrangement.Center,
         ) {
            Image(
                painter = painterResource(R.drawable.logo),
                contentDescription = "Logo",
            )

            Box(
                modifier = Modifier.padding(bottom = 10.dp),
            ) {
                SignInButton(
                    modifier = Modifier.fillMaxWidth(),
                    icon = R.drawable.right_to_bracket_solid,
                    text = "Entrar usando email e senha",
                    onClick = {},
                )
            }

            Box(
                modifier = Modifier.padding(bottom = 10.dp),
            ) {
                SignInButton(
                    modifier = Modifier.fillMaxWidth(),
                    icon = R.drawable.google,
                    text = "Entrar usando o Google",
                    onClick = {},
                )
            }

            SignInButton(
                modifier = Modifier.fillMaxWidth(),
                icon = R.drawable.apple,
                text = "Entrar usando a Apple",
                onClick = {},
            )
         }
    }
}