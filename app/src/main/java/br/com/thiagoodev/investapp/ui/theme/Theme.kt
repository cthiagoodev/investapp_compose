package br.com.thiagoodev.investapp.ui.theme

import androidx.compose.material3.ColorScheme
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.googlefonts.Font
import androidx.compose.ui.text.googlefonts.GoogleFont
import androidx.compose.ui.unit.sp
import br.com.thiagoodev.investapp.config.googleFontProvider

val defaultFont: FontFamily = FontFamily(Font(
    googleFont = GoogleFont("Montserrat"),
    fontProvider = googleFontProvider,
))

@Composable
fun AppTheme(content: @Composable () -> Unit) {
    val colorScheme = ColorScheme(
        primary = Color(0xFF6200EE),
        secondary = Color(0xFF03DAC5),
        background = Color.White,
        surface = Color.White,
        onPrimary = Color.White,
        onSecondary = Color.Black,
        onBackground = Color.Black,
        onSurface = Color.Black,
        error = Color(0xFFB00020),
        errorContainer = Color.Red,
        inverseOnSurface = Color.White,
        inversePrimary = Color.White,
        inverseSurface = Color.Black,
        onError = Color.White,
        onErrorContainer = Color.Black,
        onPrimaryContainer = Color.White,
        onSecondaryContainer = Color.Black,
        onSurfaceVariant = Color.Black,
        onTertiary = Color.Black,
        onTertiaryContainer = Color.Black,
        outline = Color(0xFFCCCCCC),
        outlineVariant = Color(0xFF999999),
        scrim = Color(0x99000000),
        primaryContainer = Color(0xFFEDE7F6),
        secondaryContainer = Color(0xFFB2DFDB),
        surfaceTint = Color(0x1F000000),
        surfaceVariant = Color(0xFFFAFAFA),
        tertiary = Color(0xFF9E9E9E),
        tertiaryContainer = Color(0xFFE0E0E0),
    )

    val typography = Typography(
        headlineLarge = TextStyle(
            fontFamily = defaultFont,
            fontWeight = FontWeight.Bold,
            fontSize = 30.sp,
            letterSpacing = 0.sp,
        ),
        headlineMedium = TextStyle(
            fontFamily = defaultFont,
            fontWeight = FontWeight.Bold,
            fontSize = 24.sp,
            letterSpacing = 0.sp,
        ),
        headlineSmall = TextStyle(
            fontFamily = defaultFont,
            fontSize = 20.sp,
            letterSpacing = 0.sp,
        ),
        titleLarge = TextStyle(
            fontFamily = defaultFont,
            fontWeight = FontWeight.Bold,
            fontSize = 18.sp,
            letterSpacing = 0.sp,
        ),
        titleMedium = TextStyle(
            fontFamily = defaultFont,
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp,
            letterSpacing = 0.sp,
        ),
        titleSmall = TextStyle(
            fontFamily = defaultFont,
            fontWeight = FontWeight.Bold,
            fontSize = 14.sp,
            letterSpacing = 0.sp,
        ),
        displayLarge = TextStyle(
            fontFamily = defaultFont,
            fontWeight = FontWeight.Normal,
            fontSize = 16.sp,
            letterSpacing = 0.sp,
        ),
        displayMedium = TextStyle(
            fontFamily = defaultFont,
            fontWeight = FontWeight.Normal,
            fontSize = 14.sp,
            letterSpacing = 0.sp,
        ),
        bodyLarge = TextStyle(
            fontFamily = defaultFont,
            fontWeight = FontWeight.Normal,
            fontSize = 16.sp,
            letterSpacing = 0.sp,
        ),
        bodySmall = TextStyle(
            fontFamily = defaultFont,
            fontWeight = FontWeight.Normal,
            fontSize = 14.sp,
            letterSpacing = 0.sp,
        ),
    )

    MaterialTheme(
        colorScheme = colorScheme,
        typography = typography,
        content = content,
    )
}