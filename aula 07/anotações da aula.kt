/*
O que é o @Composable? 
- O @Composable é uma anotação usada em funções no Jetpack Compose para indicar que essa função pode ser usada para construir a interface gráfica de um aplicativo
- Permite criar interfaces de forma declarativa e reativa.
- Facilita a composição de elementos de UI reutilizáveis.
- Substitui os layouts XML do Android tradicional.
*/

@Composable
fun Saudacao() {
    Text(text = "Olá, Jetpack Compose!")
}

/*
O que é o setContent {} (Jetpack Compose)
- O setContent {} é um método usado para definir a interface de uma Activity quando se usa o Jetpack Compose.
- Substitui setContentView() no Compose.
- Permite definir a interface de forma programática usando funções @Composable.
- Garante que o Compose gerencie a interface de forma eficiente e reativa.
*/

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Saudacao() // Chamando a função @Composable
        }
    }
}

/*
O que é o setContentView() (Android Tradicional - XML)
- O setContentView() é um método da Activity usado no Android tradicional para definir um layout XML como a interface da tela.
- Carrega um layout XML e o exibe na tela.
- Utilizado no Android antes do Jetpack Compose.
- Depende da estrutura de Views tradicionais como TextView, Button, RecyclerView, etc.
*/

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main) // Define o layout da tela a partir de um XML
    }
}

/*
1) Para criar telas com @Composable, precisamos definir setContent {} dentro do método onCreate() da Activity, garantindo que a interface seja renderizada corretamente pelo Jetpack Compose.
- As telas são construídas usando funções anotadas com @Composable
- No entanto, para exibir uma interface construída com Compose dentro de uma Activity no Android, é necessário definir essa interface dentro do método onCreate, chamando setContent {}
*/

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MinhaTela() // Chamando a função @Composable
        }
    }
}

@Composable
fun MinhaTela() {
    Text(text = "Olá, Jetpack Compose!")
}

/*
Por que usamos setContent dentro de onCreate?

a) Substitui setContentView(R.layout.activity_main)
- No Android tradicional (XML), usávamos setContentView() para definir o layout da Activity.
- No Jetpack Compose, usamos setContent {} para definir a interface baseada em Composable.

b) Define a interface da tela no ciclo de vida correto
- onCreate() é chamado quando a Activity é criada. É o momento ideal para definir o conteúdo da UI.

c) Garante que o Compose gerencie o ciclo de vida corretamente
- Como Compose é declarativo e reativo, o setContent informa ao Android que a UI será gerenciada pelo Compose, garantindo recomposições corretas.
*/

/*
2) Fora da classe MainActivity, definimos uma função @Composable que representa o layout da tela, tornando o código mais modular, organizado e reutilizável.

Como funciona?
- No Android tradicional (com XML), o layout era definido em arquivos XML, e a Activity carregava esse layout com setContentView(R.layout.activity_main).
- No Jetpack Compose, criamos uma função @Composable fora da MainActivity para representar a tela, e dentro da Activity apenas chamamos essa função.

Por que definimos a função fora da MainActivity?
- Separar a Activity da UI torna o código mais limpo e modular.
- A Activity cuida apenas da configuração inicial e do ciclo de vida
- A função @Composable pode ser reutilizada em várias telas ou até mesmo em diferentes aplicativos.
- Se precisar modificar a interface, você altera apenas a função @Composable, sem mexer na Activity.
*/

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TelaPrincipal() // Chamando a função que representa a tela
        }
    }
}

// Definimos a função que representa o layout da tela fora da MainActivity
@Composable
fun TelaPrincipal() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(text = "Bem-vindo ao App!", fontSize = 24.sp)
        Button(onClick = { /* Ação ao clicar */ }) {
            Text(text = "Clique aqui")
        }
    }
}

/*
3) Dentro da função @Composable, chamamos outras funções @Composable responsáveis por desenhar diferentes partes do layout, organizando a interface de forma modular e reutilizável.
- Dentro de uma função @Composable, podemos chamar outras funções @Composable para compor a interface de forma organizada. Isso torna o código mais legível, reutilizável e fácil de manter.
*/

@Composable
fun TelaPrincipal() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Saudacao() // Chamando outra função @Composable
        BotaoDeAcao() // Chamando outra função @Composable
    }
}

// Função que exibe um texto na tela
@Composable
fun Saudacao() {
    Text(text = "Bem-vindo ao App!", fontSize = 24.sp)
}

// Função que exibe um botão
@Composable
fun BotaoDeAcao() {
    Button(onClick = { /* Ação ao clicar */ }) {
        Text(text = "Clique aqui")
    }
}

/*
a) Divisão do código em funções menores
- TelaPrincipal() organiza a estrutura geral da tela.
- Saudacao() exibe um texto de boas-vindas.
- BotaoDeAcao() cria um botão clicável.

b) Facilidade de manutenção e reutilização
- Se quisermos reutilizar o botão ou o texto em outra tela, basta chamar Saudacao() ou BotaoDeAcao() sem precisar reescrever o código.

c) Melhora a organização e a modularidade
- O layout fica mais limpo e fácil de entender, pois cada função tem uma responsabilidade clara.
*/

/*
4) @Composable é uma anotação usada para indicar que a função pertence à interface gráfica (layout). Ao anotarmos uma função com @Composable, estamos informando à Activity que ela será responsável por desenhar elementos da tela no Jetpack Compose.
- No Jetpack Compose, @Composable é uma anotação usada para marcar funções que fazem parte da interface do usuário. Essas funções não retornam valores tradicionais, como String ou Int, mas sim elementos visuais que compõem a tela.
- Quando anotamos uma função com @Composable, estamos dizendo que essa função deve ser usada para desenhar um componente da interface gráfica. Isso significa que ela pode ser chamada dentro de outras funções @Composable para montar a tela de forma modular.
*/

@Composable
fun MinhaTela() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(text = "Olá, Jetpack Compose!")
        MeuBotao()
    }
}

// Função que cria um botão
@Composable
fun MeuBotao() {
    Button(onClick = { /* Ação ao clicar */ }) {
        Text(text = "Clique aqui")
    }
}

/*
a) O que acontece ao usar @Composable?
- O Compose entende que MinhaTela() e MeuBotao() são funções responsáveis por desenhar elementos visuais.
- A Activity pode chamar setContent { MinhaTela() } para exibir essa interface.

b) O que significa "anotação"?
- No Kotlin, anotações são usadas para fornecer informações extras ao compilador.
- A anotação @Composable informa que a função faz parte da construção da UI.

c) Por que precisamos de @Composable?
- No Compose, toda interface é baseada em funções que são chamadas dinamicamente.
- Se não adicionarmos @Composable, a função não poderá ser usada dentro de setContent {} e não será reconhecida pelo Compose.
*/

/*
5) Métodos (ou funções) são blocos de código que executam tarefas específicas, tornando o código mais organizado, reutilizável e modular
- No Kotlin, métodos (ou funções) são blocos de código reutilizáveis que executam uma tarefa específica. Eles ajudam a organizar o código, evitando repetições e tornando a lógica mais clara e modular.
- Uma função pode receber parâmetros, executar uma operação e retornar um resultado. No Jetpack Compose, as funções @Composable são usadas para desenhar a interface gráfica.
*/

// Função comum que soma dois números e retorna o resultado
fun somar(a: Int, b: Int): Int {
    return a + b
}

// Função @Composable que exibe um botão na tela
@Composable
fun MeuBotao() {
    Button(onClick = { /* Ação ao clicar */ }) {
        Text(text = "Clique aqui")
    }
}

/*
a) O que são métodos (funções)?
- São blocos de código reutilizáveis que podem executar ações e retornar valores.
- No exemplo acima, somar() recebe dois números e retorna a soma deles.

b) Diferença entre funções comuns e funções @Composable
- Funções comuns: Executam lógica de programação, como cálculos e manipulação de dados.
- Funções @Composable: Criam e desenham componentes da interface gráfica.

c) Por que usar funções?
- Reutilização: Evita código duplicado.
- Organização: Facilita a leitura e manutenção do código.
- Modularidade: Permite dividir a lógica em partes menores e reutilizáveis.
*/

/*
6) Quando uma variável no layout é usada para controlar mudanças na interface, ela não pode ser uma variável comum. Em vez disso, precisa ser armazenada com remember para preservar seu estado durante as recomposições da tela
- No Jetpack Compose, quando a interface da tela muda (por exemplo, um botão é pressionado ou um texto é digitado), o Compose recompoõe a UI para refletir essas mudanças.
- Se uma variável for declarada como uma variável comum dentro de uma função @Composable, ela será recriada do zero a cada recomposição, perdendo seu valor anterior. Para evitar isso, usamos remember.

Como funciona remember?
- O remember armazena o estado de uma variável mesmo quando a tela for recomposta, garantindo que seu valor não seja perdido.
*/

// Exemplo sem remember (não funciona corretamente)
@Composable
fun ContadorErrado() {
    var contador = 0 // Variável comum (perde o valor na recomposição)

    Column {
        Text(text = "Contador: $contador")
        Button(onClick = { contador++ }) {
            Text("Aumentar")
        }
    }
}
// Sempre que o botão for clicado, a tela será recomposta, e contador será redefinido para 0, nunca aumentando.

// Exemplo correto com remember 
@Composable
fun ContadorCorreto() {
    var contador by remember { mutableStateOf(0) } // Mantém o estado após recomposição

    Column {
        Text(text = "Contador: $contador")
        Button(onClick = { contador++ }) {
            Text("Aumentar")
        }
    }
}
// remember { mutableStateOf(0) } faz com que contador mantenha seu valor entre recomposições.
// O Compose sabe que precisa recompor apenas o necessário, sem redefinir a variável.

/*
Quando usar remember?
- Use remember sempre que precisar armazenar e preservar valores dentro de uma função @Composable, como: 
✔ Estados de botões, checkboxes ou inputs.
✔ Controle de visibilidade de elementos.
✔ Lógica condicional baseada em ações do usuário.
*/

/*
7) Um objeto comum em um layout linear é organizado verticalmente, onde os elementos são posicionados um abaixo do outro de forma sequencial
- No Jetpack Compose, quando organizamos elementos na tela, podemos escolher diferentes tipos de layouts. Um layout linear vertical significa que os componentes são posicionados um abaixo do outro, criando uma estrutura em coluna.
- No Jetpack Compose, usamos o Column para organizar elementos de cima para baixo de maneira sequencial.
*/

@Composable
fun LayoutVertical() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(text = "Texto 1")
        Text(text = "Texto 2")
        Button(onClick = { /* Ação */ }) {
            Text("Botão")
        }
    }
}

/*
O que acontece nesse código?
- O Column empilha os elementos verticalmente.
- Text("Texto 1") fica no topo, Text("Texto 2") logo abaixo, e o Button abaixo dos textos.

Por que usar um layout linear vertical?
a) Organização natural
- Para criar formulários, listas ou qualquer interface que precise de uma disposição de elementos empilhados.

b) Facilidade de leitura e manutenção
- O código fica mais claro e previsível.

c) Controle de alinhamento
- Podemos centralizar ou alinhar os elementos à esquerda/direita facilmente.
*/

/*
8) Hierarquia de Componentes no Jetpack Compose
- No Jetpack Compose, um componente visual pode conter outro dentro dele, formando uma estrutura hierárquica.
- No exemplo abaixo, temos um Button, que contém um Text dentro dele. Isso significa que o texto pertence ao botão, e o botão, por sua vez, é um componente independente que pode reagir a interações do usuário.
*/

Button(
    onClick = {
        (1 <..< 6), random()
    },  
) {
    Text(
        text = stringResource(R.string.roll),
        fontSize = 24.sp
    )
}

/*
Explicação por partes
a) Hierarquia de Componentes
- O Button {} é o componente pai.
- Dentro dele, temos um Text {} que exibe um rótulo no botão.
- Como o Text está dentro do Button, ele faz parte da estrutura do botão e será exibido dentro dele.

b) onClick (evento do botão)
- O onClick é acionado quando o usuário clica no botão.
- A linha (1 <..< 6), random() parece estar incorreta. O correto seria usar (1..6).random() para sortear um número entre 1 e 6.
- Esse número poderia ser armazenado em uma variável para controle de estado.

c) Uso de Text dentro do Button
- O Text exibe o texto do botão, que neste caso está sendo carregado de stringResource(R.string.roll), garantindo suporte a múltiplos idiomas.
*/
