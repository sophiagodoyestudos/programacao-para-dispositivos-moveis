package br.com.ibm.experimentofirebase

// Importações padrão do Android e Jetpack Compose
import android.content.Intent
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
import androidx.compose.ui.graphics.vector.RootGroupName
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.ibm.experimentofirebase.ui.theme.ExperimentoFirebaseTheme
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import android.app.Activity
import android.content.Context

// Activity que exibe a tela de cadastro
class SignUpActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Habilita layout que pode ocupar a área da barra de status e barra de navegação
        enableEdgeToEdge()

        // Define o conteúdo da tela usando Jetpack Compose e aplica o tema padrão da aplicação
        setContent {
            ExperimentoFirebaseTheme {
                // Scaffold é um layout estruturado que permite adicionar topo, rodapé, conteúdo, etc.
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    // Chama o composable que contém o formulário de cadastro
                    SignUp(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

// Função que cria o usuário no Firebase Auth e salva os dados no Firestore
fun createUserAndSaveInFirestore(
    context: Context,
    name: String,
    email: String,
    password: String,
    RG: String,
    CPF: String
) {
    // Cria usuário no Firebase Auth usando email e senha fornecidos
    Firebase.auth.createUserWithEmailAndPassword(email, password)
        .addOnCompleteListener { task ->
            if (task.isSuccessful) {
                // Recupera o usuário recém-criado e seu UID único
                val user = task.result?.user
                val uid = user?.uid

                Log.i("SIGN UP", "Cadastro realizado com sucesso. UID: $uid")

                // Se o UID for válido, continua com o salvamento no Firestore
                uid?.let { userId ->
                    // Instância do banco de dados Firestore
                    val db = Firebase.firestore

                    // Cria um mapa com os dados complementares do usuário
                    val userData = hashMapOf(
                        "name" to name,
                        "email" to email,
                        "RG" to RG,
                        "CPF" to CPF
                    )

                    // Cria um documento com o UID do usuário na coleção "users"
                    db.collection("users")
                        .document(userId)
                        .set(userData) // Salva os dados no Firestore
                        .addOnSuccessListener {
                            // Loga sucesso e redireciona para a tela de login
                            Log.i("FIRESTORE", "Dados salvos no Firestore com sucesso!")

                            // Redireciona o usuário para a tela de login
                            val intent = Intent(context, SignInActivity::class.java)
                            context.startActivity(intent)

                            // Finaliza a Activity atual para evitar retorno ao cadastro
                            if (context is Activity) {
                                context.finish()
                            }
                        }
                        .addOnFailureListener { e ->
                            // Loga erro caso falhe ao salvar no Firestore
                            Log.e("FIRESTORE", "Erro ao salvar dados no Firestore", e)
                        }
                }
            } else {
                // Loga erro caso o cadastro no Firebase Auth falhe
                Log.e("SIGN UP", "Falha ao fazer cadastro.", task.exception)
            }
        }
}

// Composable que representa a tela visual do formulário de cadastro
@Composable
fun SignUp(modifier: Modifier = Modifier) {
    // Recupera o contexto atual da Activity (usado para navegação e funções auxiliares)
    val context = LocalContext.current

    // Estados que armazenam os valores digitados pelo usuário em cada campo do formulário
    var name by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var RG by remember { mutableStateOf("") }
    var CPF by remember { mutableStateOf("") }

    // Coluna centralizada com todos os elementos da tela
    Column(
        modifier = modifier.padding(16.dp), // Margem geral
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Título da tela
        Text(
            text = "Criar Conta",
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold
        )

        // Campo: Nome
        OutlinedTextField(
            modifier = Modifier.padding(vertical = 8.dp),
            value = name,
            onValueChange = { name = it },
            label = { Text("Nome") }
        )

        // Campo: Email
        OutlinedTextField(
            modifier = Modifier.padding(vertical = 8.dp),
            value = email,
            onValueChange = { email = it },
            label = { Text("Email") }
        )

        // Campo: Senha
        OutlinedTextField(
            modifier = Modifier.padding(vertical = 8.dp),
            value = password,
            onValueChange = { password = it },
            label = { Text("Senha") }
        )

        // Campo: RG
        OutlinedTextField(
            modifier = Modifier.padding(vertical = 8.dp),
            value = RG,
            onValueChange = { RG = it },
            label = { Text("RG") }
        )

        // Campo: CPF
        OutlinedTextField(
            modifier = Modifier.padding(vertical = 8.dp),
            value = CPF,
            onValueChange = { CPF = it },
            label = { Text("CPF") }
        )

        // Botão para envio dos dados e criação de conta
        Button(
            modifier = Modifier.padding(top = 16.dp),
            onClick = {
                // Ao clicar no botão, chama a função que cria o usuário e salva os dados
                createUserAndSaveInFirestore(
                    context = context,
                    name = name,
                    email = email,
                    password = password,
                    RG = RG,
                    CPF = CPF
                )
            }
        ) {
            // Texto exibido no botão
            Text(text = "Criar minha conta")
        }
    }
}



