package br.com.ibm.experimentofirebase

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.ibm.experimentofirebase.ui.theme.ExperimentoFirebaseTheme
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import android.content.Context
import android.content.Intent
import android.app.Activity
import androidx.compose.ui.platform.LocalContext

// Tela de autenticação (login)
class SignInActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Habilita que a UI ocupe as áreas da barra de status e barra de navegação
        enableEdgeToEdge()

        // Define o conteúdo da tela com Jetpack Compose e aplica o tema visual
        setContent {
            ExperimentoFirebaseTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    // Chama o Composable que desenha o formulário de login
                    SignIn(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

// Função que autentica o usuário com Firebase Auth
fun signInWithFirebase(context: Context, email: String, password: String) {
    val auth = Firebase.auth // Obtém a instância atual da autenticação

    // Tenta fazer login com email e senha informados
    auth.signInWithEmailAndPassword(email, password)
        .addOnCompleteListener { task ->
            if (task.isSuccessful) {
                val user = task.result?.user // Usuário autenticado com sucesso
                Log.i("SIGN IN", "Login realizado com sucesso. UID: ${user?.uid}")

                // Redireciona para a tela principal (MainActivity) após login
                val intent = Intent(context, MainActivity::class.java)
                context.startActivity(intent)

                // Finaliza a SignInActivity para que o usuário não volte ao login ao clicar em "voltar"
                if (context is Activity) {
                    context.finish()
                }

            } else {
                // Loga o erro, útil para debug
                Log.e("SIGN IN", "Falha ao fazer login.", task.exception)
            }
        }
}

// Composable que representa o formulário de login
@Composable
fun SignIn(modifier: Modifier = Modifier) {
    // Acesso ao contexto da tela atual (Activity), necessário para navegação
    val context = LocalContext.current

    // Estados reativos que armazenam o conteúdo digitado pelo usuário
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    // Interface visual (UI)
    Column(
        modifier = modifier.padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Título da tela
        Text(
            text = "Login",
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold
        )

        // Campo de entrada para o e-mail
        OutlinedTextField(
            modifier = Modifier.padding(10.dp),
            value = email,
            onValueChange = { email = it },
            label = { Text(text = "Email") }
        )

        // Campo de entrada para a senha
        OutlinedTextField(
            modifier = Modifier.padding(10.dp),
            value = password,
            onValueChange = { password = it },
            label = { Text(text = "Senha") }
        )

        // Botão que realiza o login
        Button(
            onClick = {
                // Chama a função de autenticação usando os valores digitados
                signInWithFirebase(context, email, password)
            }
        ) {
            // Texto exibido dentro do botão
            Text(text = "Entrar")
        }
    }
}
