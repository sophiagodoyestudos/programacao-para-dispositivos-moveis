// Arquivo que configura o tema do meu aplicativo
/*
Esse arquivo define:
- Quais cores o app inteiro vai usar (tema claro e tema escuro)
- Quais fontes/estilos de texto o app inteiro vai usar (Tipografia → Typography)
- Isso faz com que o app inteiro fique padronizado e automático → não precisa ficar escolhendo cores ou fontes toda vez que usa Text ou Button, por exemplo
 */

// Definindo o pacote
package br.pro.mateus.galaxyweather.ui.theme

// Importações para configurar tema, cores, detecção de modo escuro...
import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

// Definindo as cores do tema (claro e escuro)
/*
Aqui você está definindo:
a) Quais cores serão usadas no modo escuro → DarkColorScheme.
b) Quais cores serão usadas no modo claro → LightColorScheme.
- Essas cores foram definidas lá no seu arquivo Colors.kt

As cores principais são:
- primary (cor principal → botoes, destaques)
- secondary (cor secundária → complementos)
- tertiary (opcional → outras ações ou destaques)
- background (cor do fundo do app)
 */
private val DarkColorScheme = darkColorScheme(
    primary = Purple80,
    secondary = PurpleGrey80,
    tertiary = Pink80,
    background = Color.White

)

private val LightColorScheme = lightColorScheme(
    primary = Purple40,
    secondary = PurpleGrey40,
    tertiary = Pink40,
    background = Color.White

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

// Função do tema do app
/*
- Esta é a função que aplica o tema no app inteiro.
- É ela que você chama no seu setContent da MainActivity

Tudo que você colocar dentro dela vai herdar:
a) As cores do tema (claro, escuro ou dinâmico)
b) As fontes do tema (Typography)
 */
@Composable
fun GalaxyWeatherTheme(
    // diz se o app está no modo escuro (automático, detecta pelo sistema com isSystemInDarkTheme()
    darkTheme: Boolean = isSystemInDarkTheme(),
    /*
    - dynamicColor é uma opção que permite que o app use as cores do sistema (wallpaper do usuário) caso esteja no Android 12+.
    a) Se for true, o app tenta usar as cores do sistema.
    b) Se for false, usa as cores definidas no Colors.kt.
     */
    dynamicColor: Boolean = true,
    // O que vai ser mostrado na tela (os componentes que o usuário criou)
    content: @Composable () -> Unit
) {
    // Definindo qual esquema de cores usar
    /*
    - É a lógica que escolhe qual esquema de cores o app vai usar agora
    a) Vamos usar cores dinâmicas?
    b) Ou vamos usar o tema escuro?
    c) Ou vamos usar o tema claro?
     */
    val colorScheme = when {
        /*
        - Se dynamicColor for true E o celular for Android 12+ (S ou superior) → podemos usar as cores dinâmicas do sistema.
        - (Exemplo: o usuário colocou um papel de parede azul → o sistema sugere cores que combinam com esse azul para o app ficar com a cara do celular).
         */
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            // Pega o Contexto da tela atual → é necessário para pegar as cores dinâmicas.
            val context = LocalContext.current
            /*
            - Verifica se o tema atual é escuro:
            a) Se for escuro → pega as cores dinâmicas para o tema escuro.
            b) Se for claro → pega as cores dinâmicas para o tema claro.
             */
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }
        // É modo escuro: Usa DarkColorScheme definido no Colors.kt
        darkTheme -> DarkColorScheme
        // É modo claro:	Usa LightColorScheme definido no Colors.kt
        else -> LightColorScheme
    }

    val view = LocalView.current
    /*
    - Isso verifica se o app está rodando de verdade ou está só no Preview do Android Studio.
    a) isInEditMode = true → está no Preview → não pode mudar a barra de status, então ignora.
    b) isInEditMode = false → app real rodando → pode mudar a barra de status.
     */
    if (!view.isInEditMode) {
        /*
        - No Compose, você só pode alterar coisas fora da UI (como status bar) dentro de um SideEffect.

         - SideEffect é um bloco especial no Jetpack Compose usado para executar ações que afetam ou interagem com elementos fora da UI do Compose, como mudar a cor da barra de status, enviar logs ou atualizar algo no sistema.
         - Ele é necessário porque o Compose reconstrói a interface várias vezes (recomposition), e fazer essas ações diretamente dentro da UI pode causar problemas ou executar múltiplas vezes sem necessidade.
         - SideEffect garante que essas ações "fora da tela" sejam executadas apenas depois que a composição da interface estiver concluída, de forma segura e controlada.
         */
        SideEffect {
            //  Pega a janela da atividade atual (ou seja, da tela que está aberta no app).
            val window = (view.context as Activity).window
            // Muda a cor da barra de status (lá em cima → relógio, sinal, bateria) para a cor de fundo do tema.
            window.statusBarColor = colorScheme.background.toArgb()
            //  Muda a cor da barra de navegação (lá embaixo → botões virtuais ou gestos) para a cor de fundo do tema.
            window.navigationBarColor = colorScheme.background.toArgb()

            /*
            - Define a cor dos ícones da barra de status:
            a) false → ícones brancos (útil quando o fundo é escuro → ícones precisam ser claros).
            b) true → ícones pretos (útil quando o fundo é claro → ícones precisam ser escuros)
             */
            WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = false
        }
    }

    // Aplicando o MaterialTheme
    /*
    - Aqui é onde aplica o tema no app inteiro

    a) colorScheme → cores que foram decididas (dinâmicas, light ou dark).
    b) typography → as fontes definidas no Typography.kt.
    c) content → os componentes visuais do app.

    - Tudo que você desenhar no app agora vai usar essas cores e fontes.
     */
    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}
