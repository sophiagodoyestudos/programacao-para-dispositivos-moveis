// Declaração do pacote do app
package br.com.ibm.aulatema.ui.theme

// Importações necessárias para criar estilos de texto
import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

/*
1) O QUE É TIPOGRAFIA?
- È o conjunto de escolhas sobre como o texto vai aparecer em um projeto
a) Que tipo de letra vai usar
b) Tamanho das letras
c) Espaçamento entre as letras

2) O QUE O ARQUIVO TYPE.KT FAZ?
-  Este arquivo é dedicado à “tipografia” do app, ou seja, ao conjunto de estilos de fonte (família, peso, tamanho etc.) que você vai usar no seu app
- Junta todas as configurações de tema (cores, tipografia, formas).
- Defino o estilo visual que o app vai mostrar para o usuário
- Nesse arquivo especificamos os padrões de fontes, ou seja, o que será usado por padrão em todo o aplicativo, sem você precisar configurar toda hora

3) FONTFAMILY = ROBOTO (FONTE TRADICIONAL DO ANDROID SEM SERIFA)
a) O QUE É ROBOTO?
- Roboto é a fonte oficial usada pela maioria dos aplicativos Android
- Ela é uma fonte sem serifa

b) O QUE É SERIFA?
- Serifa é um detalhezinho que aparece nas pontas das letras

Exemplos:
- Fonte com serifa: Times New Roman (É uma fonte que tem “pés” ou “rabichos” nas pontas das letras)
- Fonte sem serifa: Arial, Roboto

- Quando você lê um texto impresso, esses rabichos ajudam o seu olho a seguir uma linha imaginária entre uma palavra e outra.

Então:
a) Em livros, jornais impressos → fontes com serifa ajudam na leitura longa
- seu olho é guiado automaticamente pelas linhas
- Isso facilita muito a leitura de grandes blocos de texto, porque você “escorrega” de uma palavra para outra.
- É como se o design da letra criasse uma linha invisível para ajudar sua visão.

b) Em celular/computador → fontes sem serifa são melhores (porque a tela é diferente do papel).
- Em telas (celular, tablet, computador), a qualidade da imagem é diferente do papel.
- Os pequenos detalhes das letras (como as serifas) podem ficar: borrados, distorcidos ou feios em telas pequenas ou de baixa resolução
- Por isso, em interfaces de apps e sites, normalmente usamos fontes sem serifa — para o texto ficar mais limpo e fácil de ler.

4) O QUE É ESTILO VISUAL?
- Um estilo de texto é o conjunto de características que define como o texto vai parecer

Quando você cria um estilo visual de texto no app, você escolhe:
a) Qual fonte usar
b) O tamanho da fonte
c) A altura da linha (espaço entre uma linha de texto e outra)
d) O peso da fonte (normal, negrito, etc.)
e) O espaçamento entre letras

- No Compose, cada "TextStyle" é como uma roupa que o seu texto veste: muda a aparência sem mudar o conteúdo
Exemplo:
    titleLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 22.sp,
        lineHeight = 28.sp,
    )

5) LER O THEMING IN COMPOSABLE DO: https://m3.material.io/develop/android/jetpack-compose
*/

val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = FontFamily.Default, // FONTFAMILY = ROBOTO (fonte tradicional do android sem serifa)
        // fontFamily = FontFamily.Serif, // com serif
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
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
