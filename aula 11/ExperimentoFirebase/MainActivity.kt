package br.com.ibm.experimentofirebase

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import br.com.ibm.experimentofirebase.ui.theme.ExperimentoFirebaseTheme
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

// Tela principal exibida após login
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Permite que o layout ocupe as bordas (área da barra de status e navegação)
        enableEdgeToEdge()

        // Define a interface usando Jetpack Compose com o tema do app
        setContent {
            ExperimentoFirebaseTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    // Composable principal da tela
                    MainScreen(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

// Composable que busca e exibe os dados do usuário logado
@Composable
fun MainScreen(modifier: Modifier = Modifier) {
    // Obtém o UID do usuário atualmente autenticado (ou null se não estiver logado)
    val uid = Firebase.auth.currentUser?.uid

    // Estados que armazenam os dados do usuário recuperados do Firestore
    var nome by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var rg by remember { mutableStateOf("") }
    var cpf by remember { mutableStateOf("") }

    // Acesso à coleção "users" no Firestore e busca do documento pelo UID
    Firebase.firestore.collection("users").document(uid ?: "")
        .get()
        .addOnCompleteListener { task ->
            if (task.isSuccessful) {
                val document = task.result

                // Recupera os dados do Firestore ou usa fallback se não existir
                nome = document.getString("name") ?: "Nome não encontrado"
                email = document.getString("email") ?: "Email não encontrado"
                rg = document.getString("RG") ?: "RG não encontrado"
                cpf = document.getString("CPF") ?: "CPF não encontrado"

                // Registra os dados no log para debug
                Log.i("FIRESTORE", "Nome: $nome")
                Log.i("FIRESTORE", "Email: $email")
                Log.i("FIRESTORE", "RG: $rg")
                Log.i("FIRESTORE", "CPF: $cpf")
            } else {
                // Tratamento de erro ao buscar dados
                nome = "Erro ao carregar"
                Log.e("FIRESTORE", "Erro ao buscar dados", task.exception)
            }
        }

    // Interface que exibe os dados do usuário em uma coluna centralizada
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // Saudação com o nome do usuário
        Text(
            text = "Bem-vindo(a), $nome",
            style = MaterialTheme.typography.headlineSmall
        )

        // Espaçamentos e exibição dos dados
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "Email: $email")
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = "RG: $rg")
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = "CPF: $cpf")
    }
}

