package br.com.ibm.experimentofirebase

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.ibm.experimentofirebase.ui.theme.ExperimentoFirebaseTheme

// Tela inicial do app
class WelcomeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Habilita uso da tela completa (inclusive por baixo da status/navigation bar)
        enableEdgeToEdge()

        // Define o conteúdo da Activity com Jetpack Compose e tema do app
        setContent {
            ExperimentoFirebaseTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    // Chama o Composable da tela de boas-vindas
                    Welcome(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

// Composable que mostra os botões de navegação para cadastro e login
@Composable
fun Welcome(modifier: Modifier = Modifier) {
    val context = LocalContext.current // Contexto da Activity, necessário para navegação

    Column(
        modifier = modifier
            .fillMaxSize()           // Ocupa todo o espaço disponível da tela
            .padding(24.dp),         // Margem interna padrão
        verticalArrangement = Arrangement.Center,        // Alinha os elementos verticalmente ao centro
        horizontalAlignment = Alignment.CenterHorizontally // Centraliza os elementos horizontalmente
    ) {
        // Título da tela com estilo do tema
        Text(
            text = "Bem‑vindo ao programa experimental Firebase!",
            style = MaterialTheme.typography.headlineSmall
        )

        // Espaçamento entre o texto e o botão
        Spacer(Modifier.height(32.dp))

        // Botão para redirecionar o usuário à tela de cadastro
        Button(
            onClick = {
                val signUpIntent = Intent(context, SignUpActivity::class.java)
                context.startActivity(signUpIntent)
            }
        ) {
            Text("Faça seu cadastro")
        }

        // Espaçamento entre os botões
        Spacer(Modifier.height(16.dp))

        // Botão para redirecionar o usuário à tela de login
        Button(
            onClick = {
                val signInIntent = Intent(context, SignInActivity::class.java)
                context.startActivity(signInIntent)
            }
        ) {
            Text("Login")
        }
    }
}

