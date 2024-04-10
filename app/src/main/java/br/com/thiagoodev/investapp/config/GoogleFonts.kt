package br.com.thiagoodev.investapp.config

import androidx.compose.ui.text.googlefonts.GoogleFont
import br.com.thiagoodev.investapp.R

val googleFontProvider = GoogleFont.Provider(
    providerAuthority = "com.google.android.gms.fonts",
    providerPackage = "com.google.android.gms",
    certificates = R.array.com_google_android_gms_fonts_certs
)