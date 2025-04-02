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
            Prova02Theme {
                
                // O Scaffold é uma estrutura de layout que vai organizar a tela. 
                // O modifier = Modifier.fillMaxSize() faz com que o layout ocupe toda a tela. 
                // O innerPadding é um espaço extra que será adicionado ao redor do conteúdo da tela.
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    
                    // Chamando a função Greeting, passando o texto "Android" e aplicando o padding (espaço extra) no componente.
                    Greeting(
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
