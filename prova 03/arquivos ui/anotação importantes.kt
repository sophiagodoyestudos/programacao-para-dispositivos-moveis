/*
1) O QUE SÃO OS MODIFICADORES?
- Objetos que alteram aparência, comportamento ou posição de um Composable
- No Compose, modificadores são encadeáveis → você pode ir colocando vários juntos.package
- A ordem que você coloca os modificadores afeta o resultado visual

Exemplo: 
a) Mudar aparência → tamanho, cor, opacidade
b) Mudar comportamento → clique, rolagem
c) Mudar posicionamento → alinhamento, margem, padding
*/

Modifier.fillMaxSize() // Faz o componente ocupar a tela inteira
Modifier.padding(16.dp) // Dá um espaço interno de 16dp em volta do componente

/*
2) O QUE SÃO AS FONTES CUSTUMIZADAS (arquivo .ttf em res/font)
- O Android já tem fontes padrão (exemplo → Roboto, Sans Serif).
- Mas você pode colocar uma fonte diferente (.ttf) na pasta res/font para personalizar o app e referenciá-lo em FontFamily.
- Assim, o app garante que essa fonte vai aparecer igual em qualquer celular.

Exemplo:
*/

val helvetica = FontFamily(Font(R.font.helvetica_neue_thin))
Text("Texto", fontFamily = helvetica)

/*
3) BOX E SOBREPOSIÇÃO DE FILHOS
- Box → é um contêiner que empilha elementos (um em cima do outro) na ordem que são declarados.
- Muito útil para fazer imagens de fundo + textos, botões e ícones sobrepostos.
- Nele os elementos podem se sobrepor 

- Box permite que você use contentAlignment para alinhar o conteúdo inteiro.
- Isso é útil para centralizar coisas sem precisar colocar Modifier.align em cada filho.
*/

// Exemplo de Box
Box {
    Image(...) // Fica embaixo (fundo)
    Text("Em cima da imagem") // Fica em cima
}

// Exemplo de box com Alignment
Box(contentAlignment = Alignment.Center) {
    Text("Centralizado")
}

/*
4) O QUE É AGREGAÇÃO DE COMPOSABLE?
- Dividir uma tela em várias funções Composable menores e reutilizáveis.

- Podemos e devemos dividir uma UI complexa em várias funções pequenas (Composable functions), cada uma responsável por uma parte específica da tela, pois:
a) Facilitar a leitura e manutenção do código.
b) Reaproveitar componentes em outras telas.
c) Permitir teste e depuração isolados.

5) O QUE É O ALPHA 
- È a transparência 
- Valor de 0.0 (totalmente transparente) a 1.0 (totalmente opaco) que define a opacidade de um componente.
- Ajustar o destaque visual ou criar efeitos de translucidez
- Quanto mais eu diminuo a cor do Alpha mais transparente fica

Exemplo:
*/

Color.Black.copy(alpha = 0.5f) // Metade transparente
Color.White.copy(alpha = 1.0f) // Totalmente visível
Color.White.copy(alpha = 0.0f) // Invisível

/*
6) ROW E DEFINIÇÃO DE PESO (WEIGHT)
- Row → organiza itens lado a lado (horizontalmente).

O que é o weight?
- O weight é um modificador que distribui o espaço disponível entre os elementos de forma proporcional.
- Diz quanto espaço cada item vai ocupar dentro de um Row ou Column.
- Qualquer elemento dentro da Row pode usar weight.

Exemplo:
*/

Row {
    Text("A", Modifier.weight(1f)) // 1 parte
    Text("B", Modifier.weight(2f)) // 2 partes → ocupa o dobro
}

/*
7) PORQUE TEM QUE TER A LETRA F QUANDO É FLOAT? 
Exemplo:
- 1f, 2f

- f é obrigatório para indicar que o número é Float e não Int.
- Indicar que o valor é do tipo Float, exigido pelo parâmetro weight

Exemplo:
*/

Modifier.weight(1) // ERRO
Modifier.weight(1f) // OK

/*
8) O QUE É FLOWROW E ROW?
Row:
- Organiza tudo em 1 linha.
- Se não couber → o conteúdo vaza para fora da tela → precisa colocar Scroll se quiser que veja tudo.

FlowRow:
- Organiza os itens em múltiplas linhas automaticamente → quando enche a linha, ele quebra para a próxima.
- Ele possui o maxLines para limitar até onde pode quebrar.

Exemplo:
*/

FlowRow(maxLines = 2) {
    // Ele só permite no máximo 2 linhas, depois para de adicionar
}

/*
9) O QUE É @DRAWABLERES?
- Anotação que garante que o parâmetro é um recurso de imagem (R.drawable.*).
- Ajudar o compilador a checar tipos e prevenir erros de recurso inválido.

Exemplo:
*/

fun ImagemClima(@DrawableRes res: Int) {
    Image(painter = painterResource(id = res), ...)
}

/*
10) O QUE ACONTECE QUANTO MENOR FOR O PESO E QUANTO MAIOR ELE FOR?
- Menor peso → ocupa menos espaço proporcional.
- Maior peso → ocupa mais espaço proporcional.

Exemplo:
*/

Row {
    Box(Modifier.weight(1f)) // 1 parte
    Box(Modifier.weight(3f)) // 3 partes → ocupa mais espaço
}
