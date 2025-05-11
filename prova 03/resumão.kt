/*
BOX
- Sobreposição de elementos: ícones sobre imagens, badges sobre cards, etc.
- Layout “camadas”: colocar um texto centralizado sobre um fundo.
*/

Box(
    modifier = Modifier
       .size(100.dp)
    ) {
        Text("Hi")
    }
}

/*
COLUMN 
- Organiza os elementos verticalmente
*/

@Composable
fun ExemploColumnPequeno() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        verticalArrangement = Arrangement.spacedBy(4.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Item 1")
        Text("Item 2")
        Text("Item 3")
    }
}

/*
ROW
- Organiza os elementos horizontalmente 

FLOWROW x ROW
- Row: empilha todos os elementos em uma única linha horizontal, sem “quebrar” para outra linha — se não couber, fica cortado ou requer 
horizontalScroll.
FlowRow: também empilha na horizontal, mas quebra automaticamente para a próxima linha quando não há mais espaço, distribuindo os itens em 
múltiplas linhas sem necessidade de scroll.
*/

@Composable
fun ExemploRowPequeno() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text("Pesquisar")
    }
}

/*
LINEAR PROGRESS INDICATOR 
- Indica o status de uma operação 
- Usado para chamar a atenção do usuário para o quanto o processo está próximo da conclusão
*/

LinearProgressIndicator(
    modifier = Modifier.padding(10.dp).size(4.dp)
)

/*
CARD
1) O que é?
- È um contêiner visual que agrupa conteúdo relacionado (textos, imagens, botões), sobre uma “fatia” de material que se destaca do fundo por meio de 
elevação (sombra) e bordas arredondadas

2) Como fazer um Card
*/

@Composable
fun FilledCardExample() {
    Card(
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant,
        ),
    ) {
        Text(
            text = "Card 3",
            modifier = Modifier
                .padding(16.dp),
            textAlign = TextAlign.Center,
        )
    }
}

/*
O que é o Context?
- Representa o ambiente que o seu código está rodando 
- Muito utilizado para mudança de tela 

O que é o Modifier? 
- È um forma declarativa de se descrever como um Composable deve ser
a) Colocado na tela
b) Estilizado 
c) Interagir
d) layout 
*/

/*
1) Suponha que você tenha duas Activities em seu projeto Android, chamadas ActivityA e ActivityB. 
Na ActivityB, implemente uma tela em Compose que contenha um botão “Abrir A”. Ao clicar nesse botão, sua aplicação deve:
- Iniciar a ActivityA.
- Finalizar a própria ActivityB.
*/

@Composable
fun ActivityBScreen() {
    val context = LocalContext.current
    
    Button(
        onClick = {
            val intent = Intent(context, MainActivity::class.java)
            context.startActivity(intent)
            finish()
        }
    ) {
        Text(text = "Abrir A")
    }
}

/*
2) Escreva, em apenas uma frase, qual é a principal desvantagem de um projeto Android em Jetpack Compose que não aproveita a criação de componentes 
personalizados (Custom Composables).
- Ao não criar componentes personalizados em Compose, o código fica duplicado, menos modular e mais difícil de manter e testar.

3) O que são esses componentes personalizados (Custom Views)
- È uma função que define um bloco de UI reutilizável, assim você não precisa ficar criando ele várias vezes 

4) Crie uma tela de login em Jetpack Compose que atenda aos seguintes requisitos:
- Utilize um Column como contêiner principal, ocupando toda a tela e com 16 dp de padding ao redor.

- No topo da coluna, inclua dois campos de texto (OutlinedTextField), um para E-mail e outro para Senha:
a) Ambos devem ser de linha única (singleLine = true).
b) O campo de senha deve usar PasswordVisualTransformation() para ocultar os caracteres.
c) Separe verticalmente os campos com 8 dp de espaçamento.

- Abaixo dos campos, crie uma linha (Row) que ocupe toda a largura disponível e distribua dois botões lado a lado, com espaçamento uniforme entre 
eles (Arrangement.SpaceEvenly):
a) Botão “Criar conta”
b) Botão “Entrar”
*/

@Composable 
fun Login(modifier: modifier = Modifier) {
    var email by remember { mutableStateOf("") }
    var senha by remember { mutableStateOf("") }
    
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        
        OutlinedTextField(
            value = email,
            onValueChange = email = it,
            label = { Text("E-mail") },
        )

        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = senha,
            onValueChange = {senha = it},
            label = { Text ("Senha") },
            visualTransformation = PasswordVisualTransformation(),
        )

        Spacer(modifier = Modifier.height(16.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Button(onClick = { /* TODO: criar conta */ }) {
                Text("Criar conta")
            }
            Button(onClick = { /* TODO: entrar */ }) {
                Text("Entrar")
            }
        }
    }
}

/*
COLOR.KT
- Arquivo para definir as cores do tema do meu aplicativo
- Cor mais clara 
*/

val Purple80 = Color(0xFFD0BCFF)

// - Cor mais escura
val Purple40 = Color(0xFF6650a4)

/*
THEME.KT 
- Arquivo que configura o tema do meu aplicativo 

Esse arquivo define:
- Quais cores o app inteiro vai usar (tema claro e tema escuro)
- Quais fontes/estilos de texto o app inteiro vai usar (Tipografia → Typography)
- Isso faz com que o app inteiro fique padronizado e automático → não precisa ficar escolhendo cores ou fontes toda vez que usa Text ou Button, por exemplo
*/

// Criando as cores para o tema escuro
private val DarkColorScheme = darkColorScheme(
    primary = Purple80,
    secondary = PurpleGrey80,
    tertiary = Pink80,
    background = Color.White
)

// Criando as cores para o tema claro
private val LightColorScheme = lightColorScheme(
    primary = Purple40,
    secondary = PurpleGrey40,
    tertiary = Pink40,
    background = Color.White
)

// Controlo o tema que eu quero
darkTheme: Boolean = isSystemInDarkTheme()

/*
TYPE.KT
- Arquivo para definir a tipografia do meu aplicativo (fontes e estilos de textos)
*/

val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    )
