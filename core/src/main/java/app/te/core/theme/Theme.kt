package app.te.core.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.*
import androidx.compose.runtime.Composable

private val DarkColorPalette = darkColorScheme(
    primary = colorPrimary,
    secondary = secondary,
    background = background,
    onBackground = onBackground,
    outline = outLine
)

private val LightColorPalette = lightColorScheme(
    primary = colorPrimary,
    secondary = secondary,
    background = background,
    onBackground = onBackground,
    outline = outLine
)

@Composable
fun AppArchitectureTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colorScheme = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}