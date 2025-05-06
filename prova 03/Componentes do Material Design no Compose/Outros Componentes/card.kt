/*
Site de estudo: https://developer.android.com/develop/ui/compose/components/card?hl=pt-br

CARD 
- Um Card serve para apresentar informações relacionadas a um único assunto ou elemento
- O Card é feito para ser visualmente destacado e isolado, chamando atenção para um bloco de conteúdo específico.

Você pode usar cards em: 
a) Um produto em um app de compras.
b) Uma notícia em um app de notícias.
c) Uma mensagem em um app de comunicação.

Ele é usado para:
a) Organizar e exibir informações de maneira limpa e elegante.
b) Destacar conteúdos específicos (exemplos: perfil de usuário, produto, notícia, etc).
c) Tornar a interface mais clara e fácil de ler.

SCAFFOLD x COLUMN / ROW x CARD 
1) Scaffold
- Montar a tela inteira
- É como o esqueleto de uma tela inteira
- Ele estrutura coisas grandes como AppBar (barra superior), Drawer (menu lateral), corpo da tela e botões flutuantes.

Exemplo: 
- "Esta é a página do perfil do usuário". 
- Toda a página é responsabilidade do Scaffold.

2) Column / Row 
- Organizar elementos simples
- São layouts simples e genéricos
- Eles servem só para organizar elementos um do lado do outro ou empilhados.

Exemplo: 
- "Preciso colocar uma imagem em cima e o texto embaixo." 
- Isso é trabalho da Column.

3) Card 
- Destacar uma única informação em um bloco bonito
- É um contêiner específico para destacar um único conteúdo ou bloco de informação
- Ele já vem com margens, bordas arredondadas, sombra e uma aparência que diz: "este pedaço de informação é importante".

Exemplo:
- "Quero mostrar um produto com foto, preço e descrição." 
- Isso fica legal dentro de um Card.

IMPLEMENTAÇÃO BÁSICA 
- Declara o conteúdo dentro dele chamando outros elementos combináveis 

Exemplo:
*/

@Composable
fun CardMinimalExample() {
    Card() {
        Text(text = "Hello, world!")
    }
}

/*
IMPLEMENTAÇÃO AVANÇADAS 
- Dentro dos Cards utilizamos: 
a) elevation: adiciona uma sombra ao componente que faz com que ele apareça acima do plano de fundo.
- O que é: Define a altura do Card em relação ao fundo (e quanto maior a altura, mais sombra ele projeta).
- Pra que serve: Faz o Card parecer que está "flutuando" ou se destacando no layout.

Exemplo visual:
- elevation = 0.dp → Sem sombra, grudado no fundo.
- elevation = 8.dp → Com sombra, parece que está acima de outros elementos.

b) colors: usa o tipo CardColors para definir a cor padrão do contêiner e de todos os filhos.
- O que é: Permite configurar as cores do Card, incluindo o fundo e o conteúdo.
- Pra que serve: Para personalizar a aparência do Card conforme seu design.

Exemplo:
- Fundo branco, texto preto → Card normal.
- Fundo cinza claro → Card de conteúdo desativado.

c) enabled: se você transmitir false para esse parâmetro, o card vai aparecer como desativado e não vai responder à entrada do usuário.
- O que é: Define se o Card está ativo ou desativado.
- Pra que serve: Quando false, ele fica com aparência desativada (normalmente esmaecido) e não responde a cliques ou toques.

Exemplo:
- enabled = true → Card interativo.
- enabled = false → Card desativado (por exemplo, para mostrar que está indisponível).

d) onClick: normalmente, um Card não aceita eventos de clique. Dessa forma, a sobrecarga principal que você quer observar é aquela que 
define um parâmetro onClick. Use essa sobrecarga se quiser que a implementação de Card responda às pressões do usuário.
- O que é: Faz o Card responder a toques/clicks.
- Pra que serve: Normalmente um Card é só informativo.
- Mas se você colocar onClick, ele vira interativo → como um botão bonito e personalizado.

CARD PREENCHIDO
- A chave aqui é o uso da propriedade colors para mudar a cor preenchida.

Exemplo:
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
- Use o elemento combinável ElevatedCard dedicado.
- É possível usar a propriedade elevation para controlar a aparência da elevação e a sombra resultante.

Exemplo:
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
- Use o elemento combinável OutlinedCard dedicado

Exemplo:
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
- Os Cards não têm comportamento de rolagem ou deslizar por padrão.
- Isso significa que eles só exibem conteúdo estático a menos que você combine com outros componentes.

Exemplo:
- Se voce queiser fazer rolagem com os cards, você vai precisar envolver elees em um componente que suporte rolagem, como: Modifier.verticalScroll()
- Se você quiser que o card possa deslizar para o lado para ser remolvido da lista, precisa utilizar junto com ele o componente SwipeToDismiss

Resumindo:
- O Card não sabe rolar ou ser dispensado sozinho, mas o Jetpack Compose é flexível → você consegue dar esses comportamentos combinando com 
outros elementos.
*/
