// Arquivo para definir a tipografia do meu aplicativo (fontes e estilos de textos)

// Definindo o pacote
package br.pro.mateus.galaxyweather.ui.theme

// Importação necessárias para definir os estilos de texto
import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

// Criando a tipografia padrão do meu aplicativo
// A tipografia é armazenada na variável Typography
// Esse Typography depois é usado no Theme.kt para aplicar os estilos de texto no app inteiro.
val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = FontFamily.Default, // usa a fonte padrão do sistema.
        fontWeight = FontWeight.Normal, // peso normal (nem negrito nem fino).
        fontSize = 16.sp, // tamanho da fonte 16.
        lineHeight = 24.sp, // altura da linha (espaçamento entre linhas).
        letterSpacing = 0.5.sp // espaço extra entre as letras.
    )
    /* Other default text styles to override
    titleLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 22.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.sp
    ),
    labelSmall = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Medium,
        fontSize = 11.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp
    )
    */
)
/*
- Os tipos que estão comentados é um lembrete para você que poderia definir outros estilos, como:
a) titleLarge: para títulos grandes
b) labelSmall: para legendas pequenas
c) bodyLarge: Texto principal do conteúdo, como textos de artigos, descrições

Por que definir a tipografia em um único lugar?
- Permite que o app tenha consistência visual, ou seja:
a) Todos os textos principais terão o mesmo tamanho e estilo.
b) Se quiser mudar o estilo de todos os títulos ou textos de uma vez, é só alterar no Typography.
- Deixa o app todo padronizado

- Esse arquivo cria o Typography → um conjunto de estilos de texto que define como o texto vai parecer no app inteiro (tamanho, fonte, peso, espaçamento...).
*/
