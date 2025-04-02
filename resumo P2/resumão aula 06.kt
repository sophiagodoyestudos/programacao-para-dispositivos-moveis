// RESUMÃO AULA 06 PARA A PROVA

package br.com.ibm.activitylifeacycle

import android.os.Bundle
import android.util.Log
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
import br.com.ibm.activitylifeacycle.ui.theme.ActivityLifeacycleTheme

// CRIANDO UMA CLASSE QUE GERENCIA O CICLO DE UMA ACTIVITY
/*
QUANTOS MÉTODOS E QUANTOS ATRIBUTOS TEM A MAINACTIVITY?
- Atributos: 2 atributos (TAG e estado).
- Métodos: 7 métodos (onCreate(), onStart(), onResume(), onRestart(), onPause(), onStop(), onDestroy()).

- Atributos (variáveis) estão no topo, logo após a declaração da classe. Elas armazenam dados ou informações relacionados a um objeto daquela classe
- Métodos (funções) vêm abaixo dos atributos. Eles definem o comportamento daquele objeto 
*/

class MainActivity : ComponentActivity() {
    val TAG = "MainActivity" // constante que armazena o nome da Activity
    var estado = "" // guarda o estado da tela durante a utilização do aplicativo (STARTED, PAUSED, STOPPED, etc.)
	
    // MÉTODO ONCREATE()
    /*
    O QUE É O MÉTODO ONCREATE?
    - è chamado quando a Activity (tela) é criada
    - Ele é usado para inicializar a tela, configurar a interface do usuário e definir o layout da tel
    - No Android, "criada" não significa que a tela está visível. A tela é apenas inicializada nesse ponto.
    - ou seja, "Criada não significa Aparente", isso quer dizer que a Activity está apenas configurada, mas pode não estar visível ainda.
    */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ActivityLifeacycleTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
        
        /*
		O que é o LogCat?
		- LogCat é uma ferramenta que o Android Studio fornece para exibir mensagens durante a execução do seu aplicativo.
		- Ele mostra mensagens em tempo real no console (a área de logs) enquanto o aplicativo está rodando. 
		- Essas mensagens podem ser de várias fontes, como o sistema Android, o seu próprio código ou bibliotecas de terceiros.
		Exemplo: Se o aplicativo encontra um erro ou você quer saber se uma função foi chamada, você pode usar o LogCat para registrar essas mensagens.
		- È uma ferramenta de depuração do Android Studio que exibe mensagens de log do sistema e dos aplicativos em tempo real
		*/

        // DEFININDO O ESTADO DA ACTIVITY
        estado = "CREATED" // Atualiza a variável estado para indicar que a tela foi criada
        Log.i(TAG, estado) // Essa é uma função usada para registrar uma mensagem no LogCat
    	// O i significa que o nível de log é "Informativo", ou seja, uma mensagem que serve para informar o estado do programa, sem ser um erro.
        // TAG: É uma identificação que você coloca no log para saber de onde a mensagem está vindo (val TAG = "MainActivity")
    }

    // TIPOS DE MÉTODOS
    /*
    Existem dois tipos de métodos:
    1) Métodos Criados pelo Programador: São métodos que você, como desenvolvedor, cria para realizar uma tarefa específica, como 
    calcularAreaQuadrada().
	
    2) Métodos Sobrescritos (Override): São métodos que já existem em classes do Android, como onCreate(), onStart(), onResume(), etc. 
    Você pode sobrescrever esses métodos para adicionar comportamentos personalizados ao seu aplicativo.
    */

    fun calcularAreaQuadrada(l: Int): Int {
        return l * l;
    }

    /*
    O QUE É O MÉTODO ONSTART()?
    - é chamado quando a Activity está prestes a se tornar visível para o usuário.
    - Isso significa que a tela está sendo exibida, mas o usuário ainda não pode interagir com ela completamente (a interação começa no onResume()).
    - Este método é importante para registrar quando a Activity começa a ser visível.
    */
    override fun onStart() {
        super.onStart() // onStart() é chamado quando a Activity se torna visível, mas o usuário ainda pode não interagir com ela
        estado = "STARTED" 
        Log.i(TAG, estado) 
    }
    
    /*
    O QUE É O MÉTODO ONRESUME()? 
    - é chamado quando a Activity está completamente visível e interativa.
    - O usuário pode começar a interagir com a tela, tocar nela, digitar, etc.
    - Esse método é chamado quando a Activity está visível e totalmente interativa. O usuário já pode interagir com ela.
    */
    override fun onResume() {
        super.onResume()
        estado = "Tela Aparente para o usuário"
        Log.i(TAG, estado)
    }

    /*
    O QUE É O MÉTODO ONRESTART()?
    - é chamado quando a Activity volta a ser exibida, após ter sido parada (com o método onStop()).
    - Isso ocorre quando o usuário volta para a Activity depois de ela ter sido escondida, por exemplo, ao navegar para outro aplicativo ou para a tela inicial do dispositivo.
    Exemplo:
    - Quando o usuário sai do aplicativo (vai para a tela inicial ou troca de app) e depois volta ao aplicativo, o Android chama o onRestart() antes de chamar onStart() novamente.
    - Esse método é útil para quando você deseja realizar alguma ação antes de a Activity ser visível novamente.
    */
    override fun onRestart() {
        super.onRestart()
        estado = "RESTARTED"
        Log.i(TAG, estado)
    }

    /*
    O QUE É O MÉTODO ONPAUSE()?
    - é chamado quando a Activity perde o foco
    -  Isso acontece quando outra tela (ou aplicativo) aparece sobre a tela atual. 
    - A Activity ainda existe na memória, mas o usuário não pode interagir com ela.
    - Exemplo: quando o usuário recebe uma ligação e o app fica em segundo plano.
    - Esse método é chamado quando a Activity perde o foco, mas ainda não foi destruída
    */
    override fun onPause() {
        super.onPause()
        estado = "PAUSED"
        Log.i(TAG, estado)
    }

    /*
    O QUE É O MÉTODO ONSTOP()?
    - é chamado quando a Activity não está mais visível para o usuário.
    - Isso pode acontecer quando o usuário sai do app ou quando outro aplicativo é aberto.
    - O app ainda pode estar em segundo plano, mas não está mais visível
    - Esse método é chamado quando a Activity não está mais visível. O app pode estar em segundo plano, mas ainda está na memória.
    */
    override fun onStop() {
        super.onStop()
        estado = "STOPPED"
        Log.i(TAG, estado)
    }

    /*
    O QUE É O MÉTODO ONDESTROY()?
    - é chamado quando a Activity é finalizada e removida da memória
    - Isso pode acontecer quando o usuário fecha o aplicativo ou quando o sistema precisa liberar recursos e mata o processo da Activity.
    - Esse método é chamado quando a Activity é destruída e removida da memória do dispositivo
    */
    override fun onDestroy() {
        super.onDestroy()
        estado = "DESTROYED"
        Log.i(TAG, estado)
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ActivityLifeacycleTheme {
        Greeting("Android")
    }
}

/*
Como diferenciar uma classe de uma função de uma anotação?
1) Classe
- As classes começam com letras maiúsculas e são estruturas principais no código. 
- Elas são usadas para definir tipos de objetos no código, como ComponentActivity, Text, Log, etc.
Exemplo: ComponentActivity é uma classe usada para definir uma Activity no Android.

2) Funções
- As funções começam com letras minúsculas e executam ações específicas. 
- Elas são usadas para realizar tarefas, como setContent, que define o conteúdo da tela, ou fillMaxSize, que faz o layout preencher toda a tela.
Exemplo: setContent é uma função usada para definir o conteúdo da Activity.

3) Anotações
- As anotações começam com letras maiúsculas e são usadas para fornecer informações extras ao código ou ao compilador. 
- Elas não alteram diretamente o comportamento do código, mas podem modificar como ele é processado.
Exemplo: @Composable e @Preview são anotações que dizem ao Android que a função deve ser usada para criar componentes visuais ou mostrar uma prévia da interface.
*/
