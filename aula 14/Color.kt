// Declaração do pacote do app
package br.com.ibm.aulatema.ui.theme

// Importações necessárias para funcionalidades de cor do Composable
import androidx.compose.ui.graphics.Color

/*
1) O QUE É O ARQUIVO COLOR.KT?
- Define as cores principais do seu aplicativo
- Este arquivo (Colors.kt) não monta o tema todo
- Ele apenas cria as cores — cada cor é declarada como uma variável (val) com um valor hexadecimal (0xFF...).
- Essas cores depois são usadas em outros lugares (como no Theme.kt) para construir o tema completo.

2) O QUE SÃO TONALIDADES?
- È a variação da mesma cor, só que mais clara ou mais escuras

Exemplo:
- val Pink80 = Color(0xFFEFB8C8)
- val Purple40 = Color(0xFF6650a4)

- O número 80 ou 40 normalmente indica uma intensidade, brilho ou opacidade relativa.
- Em muitos projetos, 80 é usado para cores mais claras (ex: para tema claro), e 40 para tons mais escuros (ex: para tema escuro).
- Você cria várias versões da mesma cor para poder ajustar seu app para ficar bonito tanto no modo claro quanto no escuro.

- Você precisa ajustar (acertar) quais cores o aplicativo vai usar no tema claro e no tema escuro.
a) Tema claro → cores mais vivas, claras, de fundo branco.
b) Tema escuro → cores mais fortes, fundo preto/cinza, letras mais suaves para o contraste.
- Ter duas versões das cores (clara e escura) permite que seu app funcione bonito e confortável para os olhos em qualquer modo.

3) PORQUE TEM GENTE QUE PREFERE O TEMA CLARO E GENTE QUE PREFERE O TEMA ESCURO?
- Por questões de acessibilidade
- Pessoas com sensibilidade à luz preferem o modo escuro.
- Pessoas que passam muito tempo olhando para telas precisam de modos que cansem menos a vista.
- Por isso, seu app precisa se adaptar às escolhas do usuário

4) A CADA ELEMENTO VISUAL VOCÊ DEVE OFERECER UM TEXTUAL (por conta dos leitores de tela)
- Quando você cria, por exemplo, um botão só com ícone, uma imagem ou qualquer elemento visual, você precisa dar uma descrição de texto para ele.

Exemplo:
- Um ícone de "lixo" (deletar) precisa de um texto "Excluir item" para que leitores de tela possam ler.

- Isso é essencial para usuários cegos ou com deficiência visual, que usam leitores de tela para navegar pelo app.

5) UM DEFICIENTE VISUAL / CEGO QUE SER INCLUÍDO E NÃO ADAPTADO
- Incluir é fazer o app já nascer preparado para todos os tipos de usuários, sem precisar adaptações especiais.
- Adaptar é tentar mudar algo depois que foi feito pensando só em pessoas que enxergam.
*/

// Declarando três cores fixas
val Purple80 = Color(0xFFD0BCFF)
val PurpleGrey80 = Color(0xFFCCC2DC)
val Pink80 = Color(0xFFEFB8C8)

val Purple40 = Color(0xFF6650a4)
val PurpleGrey40 = Color(0xFF625b71)
val Pink40 = Color(0xFF7D5260)
