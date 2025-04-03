package br.com.ibm.experimentofirebase

import android.os.Bundle
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
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class SignUpActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ExperimentoFirebaseTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    SignUp(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

fun realizarCadastro(name: String, email: String, senha: String, RG: String, CPF: String) {

    // Obtendo a instância do banco de dados (Firestore)
    val db = Firebase.firestore

    // Criando o documento com os dados do usuário (HashMap)
    val newUser = hashMapOf(
        "name" to name,
        "email" to email,
        "senha" to senha,
        "RG" to RG,
        "CPF" to CPF
    )

    // Enviando os dados para a coleção "users" no Firestore
    db.collection("users").add(newUser)
}


@Composable
fun SignUp(modifier: Modifier = Modifier) {

    var nome by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var senha by remember { mutableStateOf("") }
    var RG by remember { mutableStateOf("") }
    var CPF by remember { mutableStateOf("") }

    Column(
        modifier = modifier.padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Criar minha conta",
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold
        )
        OutlinedTextField(
            modifier = Modifier.padding(10.dp),
            value = nome,
            onValueChange = { nome = it },
            label = { Text(text = "Nome") }
        )
        OutlinedTextField(
            modifier = Modifier.padding(10.dp),
            value = email,
            onValueChange = { email = it },
            label = { Text(text = "Email") }
        )
        OutlinedTextField(
            modifier = Modifier.padding(10.dp),
            value = senha,
            onValueChange = { senha = it },
            label = { Text(text = "Senha") }
        )
        OutlinedTextField(
            modifier = Modifier.padding(10.dp),
            value = RG,
            onValueChange = { RG = it },
            label = { Text(text = "RG") }
        )
        OutlinedTextField(
            modifier = Modifier.padding(10.dp),
            value = CPF,
            onValueChange = { CPF = it },
            label = { Text(text = "CPF") }
        )
        Button (
            onClick = {
                realizarCadastro(nome, email, senha, RG, CPF)
            }
        ) {
            Text(text = "Criar minha conta")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SignUpPreview() {
    ExperimentoFirebaseTheme {
        SignUp()
    }
}
