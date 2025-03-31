// MainActivity.kt
// Definição do pacote do meu projeto
package br.com.ibm.authexemplo

// Importação de bibliotecas
// Importações padrão do Android e Jetpack Compose
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

// Importação do tema do projeto
import br.com.ibm.authexemplo.ui.theme.AuthExemploTheme

// Importações do Firebase Auth
import com.google.firebase.ktx.Firebase
import com.google.firebase.auth.ktx.auth

/**
 * Criando a class MainActivity
 * Tela principal do aplicativo.
 * Aqui é onde a interface inicial é montada.
 */
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Permite que o conteúdo ocupe a tela inteira, inclusive atrás da barra de status
        enableEdgeToEdge()

        // Define o conteúdo da tela usando Jetpack Compose
        setContent {
            // Aplica o tema visual do app
            AuthExemploTheme {
                // Estrutura básica para a tela com preenchimento automático
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    // Componente personalizado que mostra o botão de login
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

/**
 * Criando a createNewAccount
 * Cria uma nova conta de usuário no Firebase com e-mail e senha fornecidos.
 * @param email E-mail do novo usuário
 * @param password Senha do novo usuário
 */
fun createNewAccount(email: String, password: String) {
    val auth = Firebase.auth

    auth.createUserWithEmailAndPassword(email, password)
        .addOnCompleteListener { task ->
            if (task.isSuccessful) {
                val user = auth.currentUser
                Log.i("AUTH-TESTE", "Usuário criado com sucesso. UID: ${user!!.uid}")
            } else {
                Log.i("AUTH-TESTE", "Falha ao criar o usuário.")
            }
        }
}

/**
 *  Criando a função loginTestAuth
 * Realiza login com Firebase utilizando um e-mail e senha pré-definidos.
 */
fun loginTestAuth() {
    val auth = Firebase.auth

    auth.signInWithEmailAndPassword("sophia@exemplo.com", "743274")
        .addOnCompleteListener { task ->
            if (task.isSuccessful) {
                val user = task.result.user
                Log.i("AUTH-TESTE", "Login realizado com sucesso. UID: ${user!!.uid}")
            } else {
                Log.i("AUTH-TESTE", "Falha no login.")
            }
        }
}

/**
 * Criando a função Greeting
 * Componente visual com um botão para testar login ou criação de conta.
 * Por padrão, chama a função de login ao ser clicado.
 */
@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Button(
        onClick = {
            // Para testar criação de conta, descomente a linha abaixo:
            // createNewAccount("novousuario@exemplo.com", "123456")

            // Testa o login com credenciais fixas
            loginTestAuth()
        },
        modifier = modifier
    ) {
        Text(text = "Testar login")
    }
}

/**
 * Criando a função GreetingPreview
 * Permite visualizar o componente Greeting no modo preview do Android Studio.
 */
@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    AuthExemploTheme {
        Greeting("Android")
    }
}
