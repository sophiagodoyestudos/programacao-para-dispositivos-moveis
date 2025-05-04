/*
Site utilizado para estudo: https://developer.android.com/develop/ui/compose/tutorial?_gl=1*1j5sqal*_ga*MTY1MDc5NjkxLjE3NDU4NjU4NTM.*_ga_QPQ2NRV856*MTc0NTg2NTg1My4xLjEuMTc0NTg2NTg2MS4wLjAuMA.&hl=pt-br

TUTORIAL DO JETPACK COMPOSE 
1) O que é?
- É um toolkit (conjunto de ferramentas) fornecido pelo Google para criar interfaces nativas no Android.
- É “moderno” porque adota um modelo declarativo de UI, em vez do modelo imperativo tradicional.

2) Por que ele simplifica e acelera o desenvolvimento
- Menos código: você não precisa definir arquivos XML separados, nem ficar chamando findViewById() ou manipulando View diretamente.

3) Declarativo vs Imperativo 
- Imperativo (XML + código): você descreve como montar a tela passo a passo (inflar XML, atribuir listeners, atualizar View).
- Declarativo (Compose): você descreve o que a UI deve mostrar, em função dos dados/estado. O Compose cuida de como renderizar e atualizar tudo.

4) O papel do compilador do Compose
- O plugin do Compose no compilador Kotlin analisa suas funções anotadas com @Composable e gera, nos bastidores, todo o código necessário para criar,
atualizar e descartar componentes de UI.
- Ele lida com a recomposição: quando seu estado mudar, o Compose verifica quais partes da UI precisam ser redesenhadas — sem você ter que gerenciar 
isso manualmente.

5) O que o tutorial propõe
- Criar um componente simples: você vai escrever uma função @Composable.
- Sem XML: nada de arquivos de layout separados.
- Sem Layout Editor: você não arrasta botões na interface; tudo é escrito em código Kotlin.
- Funções de composição: cada função @Composable define um pedaço da UI, e você pode combinar várias para montar telas completas.

Resumindo:
- Jetpack Compose moderniza o desenvolvimento Android ao permitir que você declare sua interface diretamente em Kotlin, com menos código, previews 
imediatos e um motor de recomposição que atualiza só o que mudou. No tutorial, você vai experimentar isso na prática, criando componentes sem mexer 
em XML, apenas chamando funções de composição.
*/

/*
LIÇÃO 01 - FUNÇÕES DE COMPOSIÇÃO 
- O Jetpack Compose foi criado com base em funções que podem ser compostas
- Essas funções permitem que você defina a interface do app de maneira programática, descrevendo as dependências de dados e de formas dela, em vez 
de se concentrar no processo de construção da interface (inicializando um elemento, anexando esse elemento a um pai etc.)
- Para criar uma função que pode ser composta, basta adicionar a anotação @Composable ao nome da função.

No composable:
- Você declara “quero um botão com este texto e esta ação”, e o framework cuida de criar, posicionar e atualizar automaticamente.
- Seu código foca o que a UI deve mostrar, e não como montar cada View

Resumindo:
- anotar uma função com @Composable faz dela uma peça da interface do seu app. Você descreve o que quer ver (dados e layout) – o Compose cuida do 
como tudo será construído e atualizado em tela.

1) COMO ADICIONAR UM ELEMENTO DE TEXTO? 
O que é o setContent? 
- É uma extensão de ComponentActivity (ou AppCompatActivity) que recebe um lambda composable.
- Tudo o que você colocar dentro desse lambda será interpretado como UI do Compose.
- Substitui o sistema imperativo de findViewById/ViewGroup por chamadas diretas a funções declarativas.
- Dentro do bloco setContent, você só pode chamar outras funções composable

O que seria a recomposição de tela nesse exemplo? 
- Se o parâmetro text mudar, o Compose redesenha só esse elemento.

Qual é o papel do plugin do compilador Kotlin?
- O Jetpack Compose usa um plug-in do compilador Kotlin para transformar essas funções de composição nos elementos de IU do app
- Detecta as funções anotadas com @Composable e as transformam em uma UI
- Sem esse plugin, chamar Text("…") seria apenas uma função normal, sem nenhum vínculo com o sistema de UI.
- O plugin Kotlin converte essas chamadas em código que cria e atualiza os widgets de verdade, cuidando de toda a parte pesada de renderização e 
gerenciamento de estado.
*/

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Text // Text é anotado com @Composable aqui 

// Definição da Activity
class MainActivity : ComponentActivity() { // Aqui estamos criando a Activity principal do app, nesse caso a MainActivity
    override fun onCreate(savedInstanceState: Bundle?) { // Estamos definindo o ciclo de vida da nossa Activity, nesse caso é o onCreate que é 
        chamado quando a Activity é criada 
        super.onCreate(savedInstanceState) // executa a lógica base (como restaurar o estado, inicializar componentes do framework).
        /*
        Bloco de composição
        - Substitui o setContentView(R.layout.algo) do modelo XML.
		- O lambda passado a setContent só pode chamar funções composable.
		- Tudo que estiver dentro desse bloco vira a árvore de composição do Compose — seu layout em código Kotlin.
        */
        setContent {
            /*
			O composable Text
            - Text é anotada com @Composable (na biblioteca), então o compilador sabe que ela desenha um elemento de UI
            - Você declara “quero este texto” e não se preocupa em criar nem adicionar TextView manualmente.
            - Se depois você mudar o parâmetro (por exemplo, Text(contador.toString())), o Compose recomporá apenas esse nó.
            */
            Text("Hello world!") // Função composable que exibe um texto na tela 
        }
    }
}

/*
O papel do plugin do compilador 
- O plugin Kotlin do Compose intercepta calls como Text(...) dentro de setContent.
- Gera o código necessário para criar, atualizar e descartar widgets Android nativos por trás das cenas.
- Gerencia a recomposição, garantindo desempenho ao redesenhar só o que mudou
*/ 
 
/*
2) COMO DEFINIR UMA FUNÇÃO QUE POSSA SER COMPOSTA?
- Para tornar uma função composta, adicione a anotação @Composable
*/

import androidx.compose.runtime.Composable // Biblioteca para criar funções composables

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MessageCard("Android") // Estou chamando a função composable aqui 
        }
    }
}

// Estou criando uma função composable
@Composable
fun MessageCard(name: String) {
    Text(text = "Hello $name!")
}

/*
3) COMO VISUALIZAR A FUNÇÃO ANDROID NO STUDIO? 
- A anotação @Preview permite visualizar as funções de composição no Android Studio sem precisar criar e instalar o app em um emulador ou 
dispositivo Android. 
- A anotação precisa ser usada em uma função de composição que não use parâmetros.
*/

import androidx.compose.ui.tooling.preview.Preview // Biblioteca para poder usar o Preview

// Essa função recebe parâmetros então não consigo usar o Preview nela 
@Composable
fun MessageCard(name: String) {
    Text(text = "Hello $name!")
}

// Essa função não recebe parâmetros então posso usar o Preview nela 
@Preview
@Composable
fun PreviewMessageCard() {
    MessageCard("Android")
}

/*
LIÇÃO 02 - LAYOUTS 
- Os elementos da IU são hierárquicos, com elementos contidos em outros
- No Compose, você cria uma hierarquia de interface chamando funções combináveis usando outras funções desse tipo.

1) COMO ADICIONO VÁRIOS TEXTOS? 
- Para ter mais de um Text na sua UI, você precisa usar um composable de layout que agrupe filhos — por exemplo um Column (vertical) ou Row 
(horizontal).
-  Assim sua hierarquia fica clara e o Compose sabe onde posicionar cada elemento

2) COMO USAR UMA COLUNA? 
- A função Column permite organizar os elementos verticalmente.
- Você pode usar a Row para organizar os itens horizontalmente e a Box para empilhar os elementos.

3) COMO ADICIONAR UM ELEMENTO IMAGEM? 
- Site utilizado: https://developer.android.com/studio/write/resource-manager#import
- No Android Studio vá em View -> Tool -> Resource Manager 
- Clique em "+" e arraste a foto que deseja caso não encontre ela lá 

4) COMO CONFIGURAR O LAYOUT? 
- Para arrumar os layouts o Composable utiliza modificadores 
- Eles permitem alterar o tamanho, o layout e a aparência dos elementos que podem ser compostos ou adicionar interações de alto nível, 
como tornar um elemento clicável.
*/

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp

@Composable
fun MessageCard(msg: Message) {
    // Add padding around our message
    Row(modifier = Modifier.padding(all = 8.dp)) {
        Image(
            painter = painterResource(R.drawable.profile_picture),
            contentDescription = "Contact profile picture",
            modifier = Modifier
                // Set image size to 40 dp
                .size(40.dp)
                // Clip image to be shaped as a circle
                .clip(CircleShape)
        )

        // Add a horizontal space between the image and the column
        Spacer(modifier = Modifier.width(8.dp))

        Column {
            Text(text = msg.author)
            // Add a vertical space between the author and message texts
            Spacer(modifier = Modifier.height(4.dp))
            Text(text = msg.body)
        }
    }
}

/*
LIÇÃO 03 - MATERIAL DESIGN 
- O Compose foi criado para oferecer suporte aos princípios do Material Design.
- Muitos dos elementos de IU dele implementam o Material Design por padrão.

1) COMO USAR O MATERIAL DESIGN? 
- O Jetpack Compose oferece uma implementação do Material Design 3 e elementos de IU prontos para uso
- O Material Design foi criado com base em três pilares: Color (cor), Typography (tipografia) e Shape (forma)
- Quando você envolve o seu conteúdo no tema do app (no caso, ComposeTutorialTheme) e num Surface, tudo o que estiver dentro desse bloco 
automaticamente passa a usar as cores, a tipografia e os cantos (shapes) que você definiu naquele tema. Em vez de você ter que especificar 
em cada Text, Button, Card ou Surface “use tal cor” ou “use tal tamanho de fonte”, esses componentes já “herdam” as configurações do tema, 
mantendo tudo visualmente uniforme.

2) O QUE É A COR?
- Use MaterialTheme.colorScheme para definir o estilo com as cores do tema envolvido.
-  Você pode usar esses valores do tema em qualquer lugar em que uma cor seja necessária

3) O QUE É TIPOGRAFIA?
- È o conhunto de estilos de textos padronizados — ou seja, as famílias de fontes, tamanhos, pesos, alturas de linha e espaçamentos que o seu app 
vai usar para todos os textos.

4) O QUE É FORMA? 
O que é o Surface composable? 
- Surface é um container básico no Compose que já respeita o tema do Material Design.
- O Surface já usa a cor de fundo correta e respeita light/dark mode sem que você precise configurar nada extra.

Ele expõe propriedades como:
- shape: define a forma do container (cantinhos arredondados, quadrados, etc.).
- elevation: controla a sombra/profundidade, dando “camadas” à UI.
- color: fundo, que por padrão vem de MaterialTheme.colorScheme.surface.

5) COMO ATIVAR O TEMA ESCURO? - VER MELHOR COMO FUNCIONA 
VERRRRRRRRRRRRRRRRRRRRRRRRR - FAZER RESUMO SITE 
*/

/*
LIÇÃO 04: LISTAS E ANIMAÇÕES 
1) CRIAR UMA LISTA DE MENSAGENS 
a) O que é o LazyColumn e LazyRow do Composable?
- Essas funções de composição processam apenas os elementos visíveis na tela
- Portanto, elas são muito eficientes para listas longas
- Elas mostram só itens que cabem na tela e vai puxando mais itens conforme você vai rolando para cima/baixo (coluna) ou para os lados (linhas)
- você vê só o que está passando diante de você; o resto só aparece quando chega no seu campo de visão.
- Então, sempre que você tiver uma lista grande — uma conversa de chat, um carrossel de fotos, uma lista de produtos — use LazyColumn (vertical) ou LazyRow (horizontal) para que o app carregue apenas o que você está vendo.

b) Qual a diferença deles para o Column e Row normal?
Column:
- “Não preguiçoso”: o Compose vai compor (criar) todos os elementos filhos de uma vez só, mesmo os que estão lá embaixo e você ainda não rolou para ver.
- Se você colocar 1.000 textos dentro de uma Column(modifier = Modifier.verticalScroll(...)), o app vai gerar 1.000 composições imediatamente, gastando memória e CPU.

LazyColumn: 
- “Preguiçoso”: só compõe os itens que cabem na tela (mais alguns de buffer à frente e atrás).
- Conforme você vai rolando, ele “descompoõe” itens que saíram de vista e “compõe” novos que estão chegando.
- Isso mantém o uso de memória e processamento baixo mesmo em listas longas.

- Row e LazyRow é a mesma coisa

2) ANIMAR MENSAGEM AO ABRIR
O que é recomposição (remember e mutableStateOf)?

*/
 
  
