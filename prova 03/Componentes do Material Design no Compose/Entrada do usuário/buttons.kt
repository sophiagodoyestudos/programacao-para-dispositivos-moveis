/*
Site utilizado: https://developer.android.com/develop/ui/compose/components/button?hl=pt-br

1) BOTÃO COMUNS 
BUTTON 
- Componentes que permitem ao usuário acionar uma ação 
- Botões de alta ênfase. São para ações principais em um aplicativo, como "enviar" e "salvar". O efeito de sombra enfatiza a importância do botão.

A) SÓLIDO - Botão preenchido 
- Plano de fundo sólido com texto em contraste
- São para ações principais em um aplicativo, como "enviar" e "salvar"
- O efeito de sombra enfatiza a importância do botão
- Para produzir ele usamos o elemento combinável Button 
*/

@Composable
fun FilledButtonExample(onClick: () -> Unit) {
    Button(onClick = { onClick() }) {
        Text("Filled")
    }
}

/*
b) TONALIDADE PREENCHIDA - Botão tonal preenchido 
- A cor de fundo varia para combinar com a superfície
- Também para ações principais ou significativas. Os botões preenchidos têm mais peso visual e são adequados para funções como "Adicionar ao carrinho" e "Fazer login".
- Para produzir ele usamos o elemento combinável FilledTonalButton 
*/

@Composable
fun FilledTonalButtonExample(onClick: () -> Unit) {
    FilledTonalButton(onClick = { onClick() }) {
        Text("Tonal")
    }
}

/*
C) ELEVADA - Botão circunscrito
- Destaca-se por ter uma sombra
- Ajusta uma função semelhante aos botões tonais. Aumente a elevação para que o botão apareça ainda mais.
- Para produzir ele usamos o elemento combinável OutlinedButton
*/

@Composable
fun OutlinedButtonExample(onClick: () -> Unit) {
    OutlinedButton(onClick = { onClick() }) {
        Text("Outlined")
    }
}

/*
D) DELINEADO - Botão elevado 
- Apresenta uma borda sem preenchimento
- Botões de ênfase média, contendo ações que são importantes, mas não principais. Eles funcionam bem com outros botões para indicar ações secundárias e alternativas, como "Cancelar". ou "Voltar".
- Para produzir ele usamos o elemento combinável ElevatedButton 
*/ 

@Composable
fun ElevatedButtonExample(onClick: () -> Unit) {
    ElevatedButton(onClick = { onClick() }) {
        Text("Elevated")
    }
}

/*
E) TEXTO - Botão de texto
- Mostra texto sem plano de fundo ou borda
- Botões de baixa ênfase, ideais para ações menos críticas, como links de navegação, ou funções secundárias como "Saiba mais" ou em "Mais detalhes".
- Para produzir ele usamos o elemento combinável TextButton
*/

@Composable
fun TextButtonExample(onClick: () -> Unit) {
    TextButton(
        onClick = { onClick() }
    ) {
        Text("Text Button")
    }
}

/*
SUPERFÍCIE DA API 
- onClick: a função chamada quando o usuário pressiona o botão.
- enabled: quando "false", este parâmetro faz com que o botão apareça. indisponível ou inativo.
- colors: uma instância de ButtonColors que determina as cores usadas em o botão.
- contentPadding: o padding dentro do botão
*/
