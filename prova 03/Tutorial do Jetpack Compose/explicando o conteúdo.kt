/*
Site de estudos: https://developer.android.com/develop/ui/compose/tutorial?_gl=1*1j5sqal*_ga*MTY1MDc5NjkxLjE3NDU4NjU4NTM.*_ga_QPQ2NRV856*MTc0NTg2NTg1My4xLjEuMTc0NTg2NTg2MS4wLjAuMA.&hl=pt-br

TUTORIAL DO JETPACK COMPOSE 
1) O que é o Jetpack Compose?
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

LIÇÃO 01: FUNÇÕES DE COMPOSIÇÃO 
- Funções composables são blocos de construção de UI no Jetpack Compose
- Cada função anotada com @Composable descreve o que deve aparecer na tela, e não como inserir

ADICIONAR UM ELEMENTO DE TEXTO 
1.1) O que é o método onCreate?
- Método do ciclo de vida da Activity, chamado antes de montar qualquer IU.

1.2) O que é a função de composição Text?
- Ela vem da biblioteca Material e é usada para exibir um texto dentro
- Dentro dela podemos usar style(tipografia), color, modifier, etc...

1.3) O que é o bloco setContent? 
- Esse blovo define que tudo ali é construção de UI via funções composables
- Só funções marcadas com @Composable podem ser chamadas dentro dele
- Ele substitui setContentView do XML 
- No Compose existe um mecanismo de recomposição, onde se a variável mudar ela será reimpressa na tela automaticamente da forma correta
- Tudo o que está dentro desse bloco é executado quando ocorre uma recomposição 

1.4) qual é a importancia do sistema de estado do Compose? 
- È o que torna possível a recomposição automática da UI sempre que alguma informação muda
- Ela mantém a UI sempre atualizada, semesforço extra do programador

1.5) O que é um plugin do compilador Kotlin? 
- O Jetpack Compose inclui um plugin no compilador Kotlin, que:
a) Reconhece funções anotadas com @Composable
b) Gera, em tempo de compilação, o código necessário para criar, anexar e atualizar de fato cada elemento de UI no Android (equivalente ao que você faria manualmente com TextView, ViewGroup, etc.)
- Em outras palavras, você declara a interface em Kotlin puro, e o compilador traduz isso em chamadas imperativas de criação de views, tornando o desenvolvimento muito mais simples e seguro.

DEFINIR UMA FUNÇÃO QUE POSSA SER COMPOSTA 
- Para tornar uma função composta passa adicionar a anotação @Composable 
- Essas funções funções sempre retornam Unit, ou seja, não "retornam" views, apenas descrevem a UI

VIZUALIZAR A FUNÇÃO NO ANDROID STUDIO 
- A anotção @Preview nas funções permite vizualizar as funções de composição sem precisar de um emulador ou dispositivo 
- Ela só pode ser usadas em funções de composição que não recebam nenhum parâmetro 

LIÇÃO 02: LAYOUTS 
- Os elementos de UI são hierarquicos (posso colocar um dentro do outro)

ADICIONAR VÁRIOS TEXTOS
*/

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MessageCard(Message("Android", "Jetpack Compose"))
        }
    }
}

data class Message(val author: String, val body: String)

@Composable
fun MessageCard(msg: Message) {
    Text(text = msg.author)
    Text(text = msg.body)
}

@Preview
@Composable
fun PreviewMessageCard() {
    MessageCard(
        msg = Message("Lexi", "Hey, take a look at Jetpack Compose, it's great!")
    )
}

/*
- Se eu tenho um código assim os meus textos (Text) vão ser mostrados no emulador um em cima do outro, pois eu não disse como eles devem se posicionar (modifier, column, row,...)
*/

/*
COMO USAR UMA COLUNA
2.1) O que é uma coluna? 
- Permite organizar os elementos verticalmentes 

2.2) O que é uma Row?
 Organiza os elementos horizontalmente
 
2.3) O que é uma Box?
- Organiza os elementos empilhados (um sobre o outro)

ADICIONAR UM ELEMENTO DE IMAGEM 
- Site de estudo para adicionar uma imagem em algum lugar: https://developer.android.com/studio/write/resource-manager#import

Para adicionar a foto:
a) Vá em view -> tool windows -> resource manager
b) Clique no sinal de "+" e dps em "import drawables"
c) Sua imagem irá aparecer em app/res/drawables no modo de visualização do Android 

- Para utilizar uma imagem em seu código deve usar o elemento "Image"

CONFIGURAR O LAYOUT 
2.1) O que são modifier? 
- Para decorar ou configurar uma função de composição, o Compose usa modificadores
- Eles permitem alterar o tamanho, o layout e a aparência dos elementos 

LIÇÃO 03: MATERIAL DESIGN 
3.1) O que é o Material Design?
- O Jetpack Compose oferece uma implementação do Material Design 3 e elementos de IU prontos para uso.
- O Material Design foi criado com base em três pilares: Color (cor), Typography (tipografia) e Shape (forma). 

COR
- È a "tinta" que o elemento será pintado 

TIPOGRAFIA
- São os estilos de fonte
- Só é utilizado dentro de Text, porque só faz sentido para textos 

FORMA
3.2) O que é o recurso Shape (forma)? 
- È o controno do seu componente (cantos arredondados, quadrados, cortados, etc...)

3.3) O que é um Surface
- Ele define a cor de fundo, a elevação para criar sombra

3.4) O que é um padding?
- È o espaço que você deixa entre a borda do seu componente e o seu conteúdo

Ex:
*/

Modifier.padding(16.dp)  // 16dp de espaçamento entre os componentes

/*
ATIVAR O MODO ESCURO 
Site de estudo de como implementar o modo escuro: https://developer.android.com/develop/ui/views/theming/darktheme?hl=pt-br

- No arquivo Theme.kt existe essa linha: darkTheme: Boolean = isSystemInDarkTheme()
- Do jeito que está ele vai mudaro programa automaticamende de acordo com o que o usuário definiu nas suas configurações do celular (se ele deseja claro ou escuro)
- Essa função faz parte de uma biblioteca

3.5) Quero deixar sempre no modo escuro 
- Nessa mesma linha altere para: darkTheme: Boolean = true
- Sempre usa o DarkColorScheme, mesmo que o sistema esteja em modo claro

3.6) Quero deixar sempre no modo escuro  
- Nessa mesma linha altere para: darkTheme: Boolean = false
- Sempre usa o LightColorScheme, mesmo que o sistema esteja em modo escuro.
*/

/*
LIÇÃO 04: LISTAS E ANIMAÇÕES
CRIAR UMA LISTA DE MENSAGENS 
4.1) O que é LazyColumn 
- É uma função composable que cria automaticamente uma lista rolável na vertical, mas só compõe (e mede/layout) os itens que estão visíveis na tela naquele momento.
- Isso torna seu uso ideal para listas longas, pois evita desenhar todo o conteúdo de uma vez.

4.2) O que é LazyRow?
- Mesma ideia do LazyColumn, só que orientada na horizontal.
- Ela monta uma linha rolável, compondo apenas os itens visíveis e reaproveitando-os conforme o usuário desliza para os lados.

4.3) Qual é a diferença do LazyColumn e do LazyRow para Column e Row?
LazyColumn/LazyRow
- Só compõe, mede e exibe os itens visíveis 
- É rolável nativamente
- Escala bem para listas longas, pois carrega sob demanda
- A função de composição LazyColumn e LazyRow são funções que processam apenas os elementos visuais na tela (são muito eficientes para listas longas)

Column/Row
- Todos os filhos são imediatamente compostos e medidos, mesmo fora da área visível
- Não é rolável por padrão 
- Pode travar com muitas views, já que monta tudo de uma vez.

ANIMAR MENSAGENS AO ABRIR 
- Para monitorar a mudança de estado das variáveis devemos usar:
a) remember
b) mutableStateOf 

4.4) O que o remember faz?
- Armazena (“lembra”) um valor entre recomposições de uma composable.
- Sem remember, toda vez que a composable for reexecutada, suas variáveis internas seriam reinicializadas, perdendo o estado.

4.5) O que o mutableStateOf faz? 
- Cria um objeto MutableState<T> que guarda um valor (value) e notifica o Compose sempre que esse valor mudar.
- Essa notificação dispara recomposição em todas as composables que leram esse MutableState.
- Torna um valor observável, disparando recomposição quando for alterado.

- As funções de composição que usam esse estado serão redesenhadas automaticamente quando o valor for atualizado. 
- Isso é chamado de recomposição.
