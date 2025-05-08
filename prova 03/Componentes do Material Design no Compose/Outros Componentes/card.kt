/*
Site de estudo: https://developer.android.com/develop/ui/compose/components/card?hl=pt-br

CARD 
- È o contêiner do Material Design para a interface 
- Apresentam geralmente um único conteúdo coerente 

Por exemplo: 
a) Um produto em um app de compras.
b) Uma notícia em um app de notícias.
c) Uma mensagem em um app de comunicação.

- O fato dele retratar um único conteúdo é o que diferencia o Card de outros contêineres 
- È geralmente um elemento de interface menor dentro de um layout maior 

Exemplo:
a) Scaffold: fornece a estrutura geral de uma tela inteira 

IMPLEMENTAÇÃO BÁSICA 
*/

@Composable
fun CardMinimalExample() {
    Card() {
        Text(text = "Hello, world!")
    }
}

/*
IMPLEMENTAÇÕES AVANÇADAS 
a) elevation: adiciona uma sombra ao componente que faz com que ele apareça acima do plano de fundo.
b) colors: usa o tipo CardColors para definir a cor padrão do contêiner e de todos os filhos.
c) enabled: se você transmitir false para esse parâmetro, o card vai aparecer como desativado e não vai responder à entrada do usuário.
d) onClick: normalmente, um Card não aceita eventos de clique. Dessa forma, a sobrecarga principal que você quer observar é aquela que define 
um parâmetro onClick. Use essa sobrecarga se quiser que a implementação de Card responda às pressões do usuário.

Existe, diferentes tipos de card:
1) CARD PREENCHIDO 
*/

@Composable
fun FilledCardExample() {
    Card(
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant,
        ),
        modifier = Modifier
            .size(width = 240.dp, height = 100.dp)
    ) {
        Text(
            text = "Filled",
            modifier = Modifier
                .padding(16.dp),
            textAlign = TextAlign.Center,
        )
    }
}

/*
CARD ELEVADO 
- Use o elemento combinável ElevatedCard
- È possível usar a propriedade elevation para controlar a aparência da elevação e a sombra resultante
*/

@Composable
fun ElevatedCardExample() {
    ElevatedCard(
        elevation = CardDefaults.cardElevation(
            defaultElevation = 6.dp
        ),
        modifier = Modifier
            .size(width = 240.dp, height = 100.dp)
    ) {
        Text(
            text = "Elevated",
            modifier = Modifier
                .padding(16.dp),
            textAlign = TextAlign.Center,
        )
    }
}

/*
CARTÃO COM CONTORNO 
- Use o elemento combinável OutlinedCard
*/

@Composable
fun OutlinedCardExample() {
    OutlinedCard(
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface,
        ),
        border = BorderStroke(1.dp, Color.Black),
        modifier = Modifier
            .size(width = 240.dp, height = 100.dp)
    ) {
        Text(
            text = "Outlined",
            modifier = Modifier
                .padding(16.dp),
            textAlign = TextAlign.Center,
        )
    }
}

/*
LIMITAÇÕES
- Os cards não vêm com ações inerentes de rolagem ou dispensar, mas podem se integrar a elementos combináveis que oferecem esses recursos
- para implementar o gesto de deslizar para dispensar em um card, integre-o ao elemento combinável SwipeToDismiss
- Para integrar com a rolagem, use modificadores de rolagem, como verticalScroll
*/
