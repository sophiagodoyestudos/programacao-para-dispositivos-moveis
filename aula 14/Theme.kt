package br.com.ibm.aulatema.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext

/*
O QUE É O ARQUIVO THEME.KT?
- Configura toda a aparência do aplicativo:
a) As cores usadas no fundo, nos botões, nos textos.
b) A tipografia (estilos de letras).
c) As formas (se os botões são quadrados ou arredondados, por exemplo).

- Ou seja: Tema = a identidade visual do seu app inteira, centralizada num único lugar.
*/

// Configuração para o modo escuro
/*
- Define o conjunto de cores que o app usa quando o sistema está no modo escuro

As três cores principais são:
a) primary: a cor mais importante (ex: cor de botões principais).
b) secondary: cor de apoio (ex: botões secundários, barras).
c) tertiary: cor terciária, usada em detalhes.
*/

// Essa função faz referência a três cores
private val DarkColorScheme = darkColorScheme(
    primary = Purple80,
    secondary = PurpleGrey80,
    tertiary = Pink80
)

// Configuração para o modo claro
/*
- Se o celular estiver configurado para tema claro, o app vai usar essas cores.
- Se estiver no modo escuro, usa o DarkColorScheme
 */
private val LightColorScheme = lightColorScheme(
    primary = Purple40,
    secondary = PurpleGrey40,
    tertiary = Pink40

    /* Other default colors to override
    background = Color(0xFFFFFBFE),
    surface = Color(0xFFFFFBFE),
    onPrimary = Color.White,
    onSecondary = Color.White,
    onTertiary = Color.White,
    onBackground = Color(0xFF1C1B1F),
    onSurface = Color(0xFF1C1B1F),
    */
)

// Função para definir se o app vai usar o tema claro ou escuro automaticamente (detectando as configurações do celular)
@Composable
fun AulaTemaTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}
