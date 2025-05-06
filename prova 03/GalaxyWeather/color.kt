// Arquivo para definir as cores do tema do meu aplicativo

// Define o pacote do meu aplicativo
package br.pro.mateus.galaxyweather.ui.theme

// Importa a classe color que permite você definir as cores em um formato hexadecimal
import androidx.compose.ui.graphics.Color

// Criando as variáveis cores
val Purple80 = Color(0xFFD0BCFF)
val PurpleGrey80 = Color(0xFFCCC2DC)
val Pink80 = Color(0xFFEFB8C8)

val Purple40 = Color(0xFF6650a4)
val PurpleGrey40 = Color(0xFF625b71)
val Pink40 = Color(0xFF7D5260)

/*
Como ele funiona?
 - Purple80 → nome da cor (você que define o nome) e o numero se refere ao brilho da cor
- Color(0xFFD0BCFF) → valor da cor no formato hexadecimal.
- Essas cores depois são usadas para montar o tema claro (Light Theme) e tema escuro (Dark Theme) do app.

Porque usa o formato hexadecimal?
- È um formato padrão para definir cores no desenvolvimento, pois permite representar a combinação de vermelho (R), verde (G) e azul (B) + opacidade (alpha) em um único valor.

Como as cores são organizadas?
- Purple80 → cor mais clara (claro → tema claro → fundo ou elementos menos destacados).
- Purple40 → cor mais escura (escuro → tema escuro → elementos mais destacados).

- Ter várias tonalidades permite criar uma hierarquia visual no app.
Por exemplo:
- no tema escuro, tons mais escuros evitam brilho excessivo e no tema claro, tons mais claros dão leveza.

- Quanto maior o número mais claro é a cor e quanto menor mais escuro

Para que essas cores vão ser usadas?
Temos diferentes tipos de cores:
a) Primary: Cor principal do app (botoes, ícones, destaques)
b) Secondary: Cor secundária para elementos menos importantes
c) Background: Fundo da tela
d) Surface: Fundo de componentes (cards, menus)
e) OnPrimary: Cor do texto que vai aparecer em cima da Primary
f) OnBackground: Cor do texto que vai aparecer em cima do Background

- No arquivo theme.kt que vamos montar onde estás cores vão ser usaas (tema claro ou escuro)
*/
