package br.com.thiagoodev.investapp.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import br.com.thiagoodev.investapp.android.presentation.auth.register.RegisterView

class RegisterActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { RegisterView() }
    }
}

