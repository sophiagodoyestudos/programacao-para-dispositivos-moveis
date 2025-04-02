// MAINACTIVIT QUANDO EU CRIO O PROGRAMA NO ANDROID STUDIO 

// DEFININDO O PACOTE DO MEU PROGRAMA
/*
O QUE É UM PACOTE?
- Pacotes são como pastas onde o código é organizado 
- O nome do pacote é br.com.ibm.prova_02, que é o identificador único do seu aplicativo dentro do projeto.
*/
package br.com.ibm.prova_02

// DEFININDO OS IMPORTS DO MEU PROJETO 
/*
O QUE SÃO ESSES IMPORTS?
- São usadas para incluir funcionalidades externas no seu código. 
- Sem essas importações, você não teria acesso às bibliotecas e classes necessárias para fazer o app funcionar. 
*/
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import br.com.ibm.prova_02.ui.theme.Prova02Theme

// DEFININDO A MINHA CLASS MAINACTIVITY 
/*
O QUE É ESSA CLASSE MAINACTIVITY?
- MainActivity é a classe principal que define a tela principal do aplicativo. 
- Toda vez que você abre o aplicativo, o Android inicia essa atividade. 
- Ela herda da classe ComponentActivity, que oferece funcionalidades essenciais para que você possa criar uma tela no seu aplicativo.

ONDE ESTÁ A CLASSE COMPONENTACTIVITY NO MEU PROJETO?
- A classe ComponentActivity não está explicitamente definida no seu projeto porque ela é parte da biblioteca do Android 
(import androidx.activity.ComponentActivity), especificamente da Jetpack.
- A ComponentActivity é uma classe base do Android usada para criar atividades (ou telas) em seu aplicativo.
*/
class MainActivity : ComponentActivity() {
    
    // Definindo o método onCreate para a minha class MainActivity
    /*
    O QUE SÃO ESSES MÉTODOS?
    - São como funções em programação. 
    - Eles executam um conjunto de instruções específicas.
    
    O QUE É O MÉTODO ONCREATE?
    - È o método que é chamado quando a minha atividade é criada 
    - Dentro desse método você vai configurar a interface e os componentes do seu aplicativo 
    */
    override fun onCreate(savedInstanceState: Bundle?) {
        
        // Chama o método onCreate da classe ComponentActivity (a classe de onde a MainActivity herda), para garantir que as configurações 
        // básicas da atividade sejam feita
        super.onCreate(savedInstanceState)
        
        // Ativando o modo de tela cheia, permitindo que o conteúdo ocupe toda a tela, sem as barras de navegação ou status 
        enableEdgeToEdge()
        
        // Definindo o conteúdo da tela 
        // Aqui, você vai criar toda a interface do aplicativo usando o Jetpack Compose.
        /*
        O QUE FAZ O SETCONTENT?
        - Onde você define o conteúdo da tela 
        - Em vez de usar XML (como era feito antigamente no Android), com o Jetpack Compose, você define tudo diretamente no código Kotlin. 
        - Dentro de setContent, você especifica a estrutura da tela e os componentes visuais (como Text, Button, etc.).
        */
        setContent {
            
            // Prova02Theme é um tema personalizado para o seu aplicativo. 
            // É como um conjunto de estilos e cores que vão ser aplicados a todos os componentes do seu app.
            Prova02Theme { // Nome que dei para o meu projeto quando eu criei ele 
                
                // O Scaffold é uma estrutura de layout que vai organizar a tela. 
                // O modifier = Modifier.fillMaxSize() faz com que o layout ocupe toda a tela. 
                // O innerPadding é um espaço extra que será adicionado ao redor do conteúdo da tela.
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    
                    // Chamando a função Greeting, passando o texto "Android" e aplicando o padding (espaço extra) no componente.
                    Greeting( // Nome da minha função que eu criei para construir o conteúdo principal do meu aplicativo 
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

// A anotação @Composable marca a função Greeting como um componente de interface do usuário. 
// Isso significa que ela vai ser mostrada na tela.
/*
O QUE É O @COMPOSABLE? 
- È uma anotação que você coloca em funções para indicar que ela cria um componente visual. 
- Ou seja, ela vai desenhar algo na tela, como um texto, botão ou imagem. 
- Em vez de escrever a interface com XML (que era usada antigamente), você usa funções @Composable para construir a UI.
*/
@Composable

// Definindo a função Greeting 
// Essa função vai criar um componente de texto na tela. 
// Ela recebe o nome (que será exibido na tela) e um modificador (para definir propriedades como tamanho e posição).
fun Greeting(name: String, modifier: Modifier = Modifier) {
    
    // A função Text é usada para exibir o texto na tela. 
    // O texto exibido será "Hello Android!", onde name vai ser o valor passado para a função. 
    // O modifier permite aplicar ajustes no estilo.
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

// não estendi essaa parte 
// A anotação @Preview indica que a função que vem em seguida deve ser mostrada como uma visualização no Android Studio. 
// O parâmetro showBackground = true faz a visualização ter um fundo para facilitar a visualização do layout.

/*
O QUE É O @PREVIEW?
- È uma anotação usada para mostrar uma pré-visualização da interface do seu aplicativo diretamente no Android Studio, 
sem precisar rodar o aplicativo no dispositivo. 
- Você pode ver como a interface vai ficar enquanto desenvolve. 
*/
@Preview(showBackground = true)

// Define uma função chamada GreetingPreview, que é uma versão de visualização da função Greeting para exibir na interface do Android Studio.
@Composable
fun GreetingPreview() {
    
    // Aplica o tema do aplicativo na visualização.
    Prova02Theme {
        /
        // / Chama a função Greeting, passando o nome "Android", para a visualização.
        Greeting("Android")
    }
}

/*
QUAL A DIFERENÇA DO @COMPOSABLE PARA O XML? 
1) @Composable
- È um framework moderno para criar interfaces de usuário (UI) de forma declarativa no Android.
- Quando você usa o Jetpack Compose, você descreve como a interface deve se comportar e se ajustar com base no estado da aplicação. Ou seja, você define o que a interface vai mostrar em vez de como ela deve ser organizada.

Exemplo:
@Composable
fun Greeting(name: String) {
    Text(text = "Hello, $name!")
}
- Aqui, você simplesmente declara que a interface vai exibir um texto com a saudação. O Compose cuida de renderizar e atualizar a interface quando o estado mudar.package

2) XML
- Aqui, você simplesmente declara que a interface vai exibir um texto com a saudação. O Compose cuida de renderizar e atualizar a interface quando o estado mudar.

Exemplo:
<TextView
    android:id="@+id/greetingText"
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    android:text="Hello, Android!" />
- Aqui, você define explicitamente a estrutura da interface no XML (neste caso, um TextView). Em seguida, no código Kotlin, você acessa esse TextView e define seu comportamento.

Principais Difrenças:
1) Abordagem:
- @Composable (Jetpack Compose) é declarativo. 
Você define o que a interface deve mostrar com base no estado, e o sistema cuida do layout e das atualizações.
- XML é imperativo. Você define como o layout será, e depois aplica a lógica de interação no código Kotlin.

2) Sintaxe:
- @Composable usa Kotlin para escrever a interface de usuário, permitindo mais flexibilidade e integração com o código.
- XML usa uma linguagem separada (XML) para definir o layout e depois a lógica em Kotlin ou Java.

Reatividade:
- Jetpack Compose é reativo. A interface se atualiza automaticamente quando o estado muda.
- XML requer que você manipule a interface manualmente com código Kotlin/Java, como usando findViewById() e depois alterando o conteúdo do layout.

Flexibilidade:
- @Composable permite um design mais dinâmico e modular. Você pode facilmente combinar funções composable e ter um código mais limpo e reutilizável.
- XML é mais fixo e requer mais código para manipulação dinâmica da UI.

Resumindo:
- @Composable (Jetpack Compose) é declarativo e usa Kotlin para definir a interface diretamente no código, com reatividade automática. 
Ele facilita a construção e manutenção de interfaces.
- XML é imperativo e envolve definir a interface separadamente em arquivos XML e a lógica da UI em Kotlin/Java, exigindo mais manipulação 
manual e mais código.
*/
